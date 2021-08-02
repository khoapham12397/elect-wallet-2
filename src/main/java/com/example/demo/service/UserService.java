package com.example.demo.service;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Authenticate;
import com.example.demo.entity.UserProfile;
import com.example.demo.entity.Wallet;
import com.example.demo.model.ChangePasswordRequest;
import com.example.demo.model.ChangePinRequest;
import com.example.demo.model.RegisterUserRequest;
import com.example.demo.model.RegisterWalletRequest;
import com.example.demo.model.UserProfileResponse;
import com.example.demo.repository.AuthenticateRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WalletRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	AuthenticateRepository authenRepository;
	
	public UserProfileResponse getUserProfile(String userId) {
		 
		 UserProfile user = userRepository.findById(userId).get();
		
		 UserProfileResponse profile = new UserProfileResponse(user.getPhone(),user.getFullName(),
				 user.getAddress(),user.getIdentityNumber(),user.isFemale());
		 profile.setUserId(userId);
		 return profile;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String changePassword(ChangePasswordRequest rq) {
		
		Authenticate authen = entityManager.find(Authenticate.class, rq.getUserId());
		
		if(BCrypt.checkpw(rq.getOldPassword(),authen.getHashedPassword())) {
			String hashedPass = BCrypt.hashpw(rq.getNewPassword(), BCrypt.gensalt());
			authen.setHashedPassword(hashedPass);
			return hashedPass;
		}
		
		return null; 
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Boolean changePin(ChangePinRequest rq) {
		
		Wallet wallet = entityManager.find(Wallet.class, rq.getUserId());
		
		if(rq.getOldPin().equals(wallet.getHashedPin())) {
			wallet.setHashedPin(rq.getNewPin());
			return true;
		}
		return false; 
	}
	
	public void changeProfile(UserProfile profile) {
		userRepository.save(profile);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerWallet(RegisterWalletRequest rq) {
		
		UserProfile profile = entityManager.find(UserProfile.class, rq.getUserId(),LockModeType.PESSIMISTIC_WRITE);
		profile.setIdentityNumber(rq.getIdentity());
		profile.setPhone(rq.getPhone());
		Wallet wallet = new Wallet();
		wallet.setWalletId(rq.getUserId()); wallet.setBalance(0L);
		wallet.setHashedPin(rq.getHashedPin());
		walletRepository.save(wallet);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void registerUser(RegisterUserRequest rq) {
		
		System.out.println("register user id : "+ rq.getUserId()+ " and username: "+ rq.getUsername()
		+", fullname : "+ rq.getFullname() +", password:" + rq.getPassword());
		
		UserProfile profile= new UserProfile();
		
		profile.setFullName(rq.getFullname());
		profile.setUserId(rq.getUserId());
		
		Authenticate authen = new Authenticate();
		authen.setUserId(rq.getUserId());
		authen.setUsername(rq.getUsername());
		authen.setHashedPassword(BCrypt.hashpw(rq.getPassword(), BCrypt.gensalt()));
		
		userRepository.save(profile);
		authenRepository.save(authen);
		
	}
	@Transactional()
	public Long getBalance(String userId) {
		Wallet  wallet = entityManager.find(Wallet.class, userId);
		if(wallet == null) throw new RuntimeException("wallet is not exist");
		return wallet.getBalance();
	}
}

