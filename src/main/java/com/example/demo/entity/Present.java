package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="present")
public class Present {
	
	@Id
	@Column(name="trans_id")
	private String presentId;
	
	@Column(name="owner_id")
	private String ownerId;
	
	@Column(name="total_amount")
	private Long totalAmount;
	
	@Column(name="current_amount")
	private Long currentAmount;
	
	@Column(name="start_time")
	private Long startTime;
	
	@Column(name="session_id")
	private String sessionId;

	@Column(name="expired")
	private Boolean expired;

	@Column(name="envelope")
	private Long envelope;

	@Column(name="equal")
	private Boolean equal;

	@Column(name="current_envelope")
	private Long currentEnvelope;

	public Present(String presentId, String ownerId, Long totalAmount, Long currentAmount, Long startTime,
			String sessionId, Boolean expired, Long envelope, Boolean equal) {
		super();
		this.presentId = presentId;
		this.ownerId = ownerId;
		this.totalAmount = totalAmount;
		this.currentAmount = currentAmount;
		this.startTime = startTime;
		this.sessionId = sessionId;
		this.expired = expired;
		this.envelope = envelope;
		this.equal = equal;
		this.currentEnvelope = envelope;
	}

	public Present() {}
	
	public Boolean getExpired() {
		return expired;
	}
	public void setExpired(Boolean expired) {
		this.expired = expired;
	}
	
	public String getPresentId() {
		return presentId;
	}
	public void setPresentId(String presentId) {
		this.presentId = presentId;
	}

	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(Long currentAmount) {
		this.currentAmount = currentAmount;
	}

	public Long getstartTime() {
		return startTime;
	}
	public void setstartTime(Long startTime) {
		this.startTime = startTime;
	}

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Long getEnvelope(){return envelope;}
	public void setEnvelope(Long envelope){this.envelope=envelope;}

	public Boolean getEqual(){return equal;}
	public void setEqual(Boolean equal){this.equal=equal;}

	public Long getCurrentEnvelope(){return currentEnvelope;}
	public void setCurrentEnvelope(Long currentEnvelope){this.currentEnvelope=currentEnvelope;}
}
