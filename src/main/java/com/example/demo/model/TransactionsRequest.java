package com.example.demo.model;

public class TransactionsRequest {
	private String userId;
	private int direct;
	private int type; 
	private Long startTime;
	private Long endTime;
	public TransactionsRequest(String userId, int direct, int type, Long startTime, Long endTime) {
		super();
		this.userId = userId;
		this.direct = direct;
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public TransactionsRequest() {}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	
}
