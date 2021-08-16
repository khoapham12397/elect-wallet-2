package com.example.demo.model;

public class SendPresentRequest {
	private String userId;
	private Long amount;
	private String sessionId;
	private String presentId;
	private Long envelope;
	private Boolean type;

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

	public Long getEnvelope(){return envelope;}
	public void setEnvelope(Long envelope){this.envelope=envelope;}

	public Boolean getType(){return type;}
	public void setType(Boolean type){this.type=type;}
}
