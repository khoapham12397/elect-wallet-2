package com.example.demo.model;

public class RegisterWalletRequest {
	private String userId;
	private String hashedPin;
	private String identity;
	private String phone;
	private String email;
	
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
