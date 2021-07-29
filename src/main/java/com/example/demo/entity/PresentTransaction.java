package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="present_transaction")
public class PresentTransaction {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="receiver_wallet_id")
	private String receiverWalletId;
	
	public PresentTransaction(String id, String receiverWalletId, String presentId, Long amount, Long timestamp) {
		super();
		this.id = id;
		this.receiverWalletId = receiverWalletId;
		this.presentId = presentId;
		this.amount = amount;
		this.timestamp = timestamp;
	}
	
	public PresentTransaction() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReceiverWalletId() {
		return receiverWalletId;
	}

	public void setReceiverWalletId(String receiverWalletId) {
		this.receiverWalletId = receiverWalletId;
	}

	public String getPresentId() {
		return presentId;
	}

	public void setPresentId(String presentId) {
		this.presentId = presentId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name="present_id")
	private String presentId;
	
	@Column(name="amount")
	private Long amount;
	
	@Column(name="timestamp")
	private Long timestamp;
}
