package com.example.demo.model;

public class SendP2PRequest {
	
	String senderId;
	public SendP2PRequest(String senderId, String receiverId, Long amount, String messsage) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.amount = amount;
		this.messsage = messsage;
	}
	public String getSenderId() {
		return senderId;
	}
	public SendP2PRequest() {}
	
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	
	String receiverId;
	Long amount;
	String messsage;
}
