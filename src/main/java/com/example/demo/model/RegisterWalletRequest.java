package com.example.demo.model;

public class RegisterWalletRequest {
	private String userId;
	private String hashedPin;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHashedPin() {
		return hashedPin;
	}
	public void setHashedPin(String hashedPin) {
		this.hashedPin = hashedPin;
	}
}
