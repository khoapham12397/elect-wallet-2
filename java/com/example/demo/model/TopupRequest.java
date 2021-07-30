package com.example.demo.model;

public class TopupRequest {
	
	public TopupRequest(String walletId, Long amount, String message) {
		super();
		this.walletId = walletId;
		this.amount = amount;
		this.message = message;
	}
	
	public TopupRequest() {}
	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String walletId;
	
	private Long amount;
	
	private String message;
}
