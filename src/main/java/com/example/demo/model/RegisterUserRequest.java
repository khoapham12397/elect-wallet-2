package com.example.demo.model;


public class RegisterUserRequest {
	
	private String username;
	private String fullname;
	private String password; 
	private String userId;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullName) {
		this.fullname = fullName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
