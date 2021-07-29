package com.example.demo.model;

public class ReceivePresentRequest {
	
	private String presentId;
	private String userId;
	public String getPresentId() {
		return presentId;
	}
	public void setPresentId(String presentId) {
		this.presentId = presentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ReceivePresentRequest(String presentId, String userId) {
		super();
		this.presentId = presentId;
		this.userId = userId;
	}
	public ReceivePresentRequest() {}
	
}
