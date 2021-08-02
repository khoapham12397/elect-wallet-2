package com.example.demo.model;

public class ChangePinRequest {
	private String userId;
	private String oldPin;
	private String newPin;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOldPin() {
		return oldPin;
	}
	public void setOldPin(String oldPin) {
		this.oldPin = oldPin;
	}
	public String getNewPin() {
		return newPin;
	}
	public void setNewPin(String newPin) {
		this.newPin = newPin;
	}
}
