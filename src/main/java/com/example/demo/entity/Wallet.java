package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="wallet", indexes = @Index(name = "wallet_index", columnList = "user_id", unique = true))
public class Wallet {
	@Id
	@Column(name="user_id")
	private String walletId;

	@Column(name="balance")
	private Long balance;

	@Column(name="hashed_pin")
	private String hashedPin;

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

	public String getHashedPin() {
		return hashedPin;
	}
	public void setHashedPin(String hashedPin) {
		this.hashedPin = hashedPin;
	}
}
