package com.example.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class ExampleService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	StudentRepository studentRepository;
	
	public void add(Student st) {
		studentRepository.save(st);
	}
	
	/*
	
	
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void topUp(TopupRequest request) {
		String walletId = request.getWalletId(); 
		Long amount  = request.getAmount();
		
		Wallet wallet = entityManager.find(Wallet.class, walletId, LockModeType.PESSIMISTIC_WRITE);
		wallet.setBalance(wallet.getBalance()+ amount);
	
		String id= GenerationUtil.generateId();
		
		String autoDes = request.getWalletId() + " charge "+ request.getAmount() +" VND"; 
		
		String des = request.getMessage();
		MoneyTransaction tsx= new MoneyTransaction( walletId , amount, System.currentTimeMillis(), 
				true, autoDes,des, 0);
		
		transactionRepository.save(tsx);
		
		
	}
	
	
	//String transactionId, String UserProfileId, Long amount, Long timestamp, boolean isAdd,
	//String autoDescription, String addedDescription, int transactionType
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void sendP2P(SendP2PRequest request) throws SQLException {
		Wallet senderWallet = entityManager.find(Wallet.class, request.getSenderId(), LockModeType.PESSIMISTIC_WRITE);
		Wallet receiverWallet = entityManager.find(Wallet.class, request.getReceiverId(), LockModeType.PESSIMISTIC_WRITE);
		Long amountSender = senderWallet.getBalance();
		Long amount = request.getAmount();
		if(amountSender < amount) {
			throw new SQLException("balance of sender is not enught to send");
		}
		senderWallet.setBalance(amountSender-amount);
		receiverWallet.setBalance(receiverWallet.getBalance()+ amount);
		
		String id1= GenerationUtil.generateId();
		String id2 = GenerationUtil.generateId();
		
		String autoDescription = "null";//senderWallet.getFullName()+" send "+String.valueOf(amount)+" to "+  receiver.getFullName();
		// o day can chinh lau : // dunvya :
		//
		Long timestamp =  System.currentTimeMillis();
		
		MoneyTransaction sendTsx = new MoneyTransaction(request.getSenderId(),amount, timestamp, 
				false,autoDescription, request.getMesssage(), 1);
		
		MoneyTransaction receiveTsx = new MoneyTransaction(request.getReceiverId(),amount,
				timestamp,true,autoDescription, request.getMesssage(), 1);
				
		
		transactionRepository.save(sendTsx);
		transactionRepository.save(receiveTsx);
	}
	
	
	
	public List<MoneyTransaction> getTransactionUserProfile(String UserProfileId) {
		
		return null;
	}
	
	public void updateAccount() {
		
	}
	*/
}
