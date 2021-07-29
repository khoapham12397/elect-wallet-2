package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {
	
	@Id
	@Column(name="wallet_id")
	private String walletId;
	
	public Wallet(String walletId, Long balance) {
		super();
		this.walletId = walletId;
		this.balance = balance;
	}
	
	public Wallet() {}
	
	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	

	@Column(name="balance")
	private Long balance;
	
	public String getHashedPin() {
		return hashedPin;
	}

	public void setHashedPin(String hashedPin) {
		this.hashedPin = hashedPin;
	}



	@Column(name="hashed_pin")
	private String hashedPin;
}
