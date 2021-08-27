package com.example.demo.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authenticate")
public class Authenticate {
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="username")
	private String username;

	@Column(name="hashed_password")
	private String hashedPassword;

	public Authenticate( String userId, String username, String hashedPassword) {
		super();
		this.userId = userId;
		this.username = username;
		this.hashedPassword = hashedPassword;
	}
	public Authenticate() {}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
}
