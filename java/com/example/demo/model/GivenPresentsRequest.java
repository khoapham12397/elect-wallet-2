package com.example.demo.model;

public class GivenPresentsRequest {
	
	private String userId;
	private String sessionId;
	public GivenPresentsRequest(String userId, String sessionId) {
		super();
		this.userId = userId;
		this.sessionId = sessionId;
	}
	public GivenPresentsRequest() {}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
