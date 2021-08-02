package com.example.demo.model;

public class SendPresentRequest {
	private String userId;
	private Long amount;
	private String sessionId;
	private String presentId;
	
	public String getPresentId() {
		return presentId;
	}
	public void setPresentId(String presentId) {
		this.presentId = presentId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
}
