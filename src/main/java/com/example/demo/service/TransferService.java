package com.example.demo.service;

import java.sql.SQLException;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Authenticate;
import com.example.demo.entity.P2PTransaction;
import com.example.demo.entity.Present;
import com.example.demo.entity.TopupTransaction;
import com.example.demo.entity.UserProfile;
import com.example.demo.entity.Wallet;
import com.example.demo.model.GetP2PsRequest;
import com.example.demo.model.GetPresentRequest;
import com.example.demo.model.GetTopupsRequest;
import com.example.demo.model.ReturnPresent;
import com.example.demo.model.SendP2PRequest;
import com.example.demo.model.SendPresentRequest;
import com.example.demo.model.TopupDirectRequest;
import com.example.demo.model.TopupRequest;
import com.example.demo.repository.PresentRepository;
import com.example.demo.util.GenerationUtil;

@Service
public class TransferService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Autowired
	PresentRepository presentRepository;

	@Transactional(propagation= Propagation.REQUIRED)
	public void addBalance(String userId, Long amount) {
		Wallet w = entityManager.find(Wallet.class, userId);
		w.setBalance(w.getBalance()  + amount);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Long topup(TopupRequest request) {
		String walletId = request.getWalletId(); 
		Long amount  = request.getAmount();
		
		Wallet wallet = entityManager.find(Wallet.class, walletId, LockModeType.PESSIMISTIC_WRITE);
		if(wallet ==null) {
			//System.out.println("wallet  is  null");
			return 0L;
		}
		
		wallet.setBalance(wallet.getBalance()+ amount);

		
		TopupTransaction tsx =new TopupTransaction();
		tsx.setAmount(amount);
		tsx.setTimestamp(System.currentTimeMillis());
		tsx.setUserId(walletId);
		
		entityManager.persist(tsx);
		//entityManager.flush();
		return tsx.getId();
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Long topupDirect(TopupDirectRequest request) {
		String userId = request.getUserId(); 
		String pin = request.getPin();
		
		Wallet wallet = entityManager.find(Wallet.class, userId, LockModeType.PESSIMISTIC_WRITE);
		if(wallet ==null) {
			System.out.println("wallet  is  null");
			return -1L;
		}
		if(!pin.equals(wallet.getHashedPin())) return 0L;
		
		Long amount  = request.getAmount();
		
		
		
		wallet.setBalance(wallet.getBalance()+ amount);

		
		
		TopupTransaction tsx =new TopupTransaction();
		tsx.setAmount(amount);
		tsx.setTimestamp(System.currentTimeMillis());
		tsx.setUserId(userId);
		entityManager.persist(tsx);
		return tsx.getId();
		
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long sendP2P(SendP2PRequest request) throws SQLException {
		String receiverId = request.getReceiverId();
		String senderId = request.getSenderId();
		Wallet senderWallet = entityManager.find(Wallet.class, senderId, LockModeType.PESSIMISTIC_WRITE);
		Wallet receiverWallet = entityManager.find(Wallet.class, receiverId, LockModeType.PESSIMISTIC_WRITE);
		
	
		Long amountSender = senderWallet.getBalance();
		Long amount = request.getAmount();
		if(amountSender < amount) {
			return 0L;
		}
		senderWallet.setBalance(amountSender-amount);
		receiverWallet.setBalance(receiverWallet.getBalance()+ amount);
		

		Long timestamp =  System.currentTimeMillis();
		
		P2PTransaction tsx =new P2PTransaction();
		tsx.setAmount(amount);
		tsx.setDescription(request.getMesssage());
		tsx.setReceiverId(receiverId);
		tsx.setSenderId(senderId);
		tsx.setTimestamp(timestamp);
		
		entityManager.persist(tsx);
		return tsx.getId();
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean sendPresent(SendPresentRequest rq) {
		
		Wallet wallet = entityManager.find(Wallet.class, rq.getUserId());
		Long amount = rq.getAmount();
		if(wallet.getBalance() >= amount) {
			wallet.setBalance(wallet.getBalance() - amount);
			return true;
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Boolean createPresent(SendPresentRequest rq) {
		String userId  = rq.getUserId();
		
		Wallet wallet = entityManager.find(Wallet.class,userId, LockModeType.PESSIMISTIC_WRITE);
		Long amount = rq.getAmount();
		if(wallet.getBalance() < amount) return false;
		wallet.setBalance(wallet.getBalance() - amount);
		//String presentId, String ownerId, Long totalAmount, Long currentAmount, Long startTime,
		//String sessionId, Boolean expire
		Present pr = new Present(rq.getPresentId(),rq.getUserId(),rq.getAmount(),rq.getAmount(),System.currentTimeMillis(),
				rq.getSessionId(), false);
		
		
		presentRepository.save(pr);
	
		
		return true;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long getPresent(GetPresentRequest rq) {
		String presentId = rq.getPresentId();
		System.out.println("Find present id: "+ presentId);
		Present pr = entityManager.find(Present.class, presentId,LockModeType.PESSIMISTIC_WRITE);
		if(pr==null) return -1L;
		if(pr.getExpired()) return 0L;
		Long startTime = pr.getstartTime();
		
		if(System.currentTimeMillis()- startTime>=24*60*60*1000) {
			pr.setExpired(true);
			presentRepository.delete(pr);
			return -1L;
		}
		Long cur = pr.getCurrentAmount(),am = 0L;
		Long y= cur/10000;
		if(y==0) am=cur;
		else {
			Random rd = new Random();
			am = (Math.abs(rd.nextLong())% (Math.min(y+1,10L)))*10000;
			if(am==0) am = 10000L; 
		}
		
		Long remind = cur - am;
		if(remind==0) pr.setExpired(true);
		else pr.setCurrentAmount(remind);
		Wallet wallet = entityManager.find(Wallet.class,rq.getUserId(), LockModeType.PESSIMISTIC_WRITE);
		wallet.setBalance(wallet.getBalance() + am);
		return am;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void removePresent(String presentId) {
		Present pr = entityManager.find(Present.class, presentId, LockModeType.PESSIMISTIC_WRITE);
		if(pr==null) return;
		String userId = pr.getOwnerId();
		if(pr.getCurrentAmount()>0) {
			Wallet wallet = entityManager.find(Wallet.class, userId,LockModeType.PESSIMISTIC_WRITE);
			wallet.setBalance(wallet.getBalance() + pr.getCurrentAmount());
		}
		
		presentRepository.delete(pr);
	}
	
	public void getTopupTransactions(GetTopupsRequest rq) {
		
	}
	
	
	public void getP2PTransactions(GetP2PsRequest rq) {
		
		String sql="select ts.id, ts.amount,ts.timestamp, s.username, r.username from P2PTransaction ts join Authenticate a";
		entityManager.createQuery("");
	}
}
