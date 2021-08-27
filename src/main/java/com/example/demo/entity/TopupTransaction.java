package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topup_transaction")

public class TopupTransaction {
	
	@Id
	@Column(name="trans_id")
	private String id;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="amount")
	private Long amount;
	
	@Column(name="timestamp")
	private Long timestamp;

	public String getId() {return id;}
	public void setId(String id) {
		this.id = id;
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

	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
