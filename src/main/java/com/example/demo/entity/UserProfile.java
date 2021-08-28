package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="user", indexes = @Index(name="user_index", columnList = "user_id", unique = true))
public class UserProfile {
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="address")
	private String address;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="email")
	private String email;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	

	public Boolean getGender() {
		return isFemale;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public Boolean isFemale() {
		return isFemale;
	}

	public void setGender(Boolean gender) {
		this.isFemale = gender;
	}

	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	

	public UserProfile(String userId, String fullName,  String address,
			String phone, String identityNumber, Boolean gender, Date dateOfBirth) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		
		this.address = address;
		this.phone = phone;
		this.identityNumber = identityNumber;
		this.isFemale = gender;
		this.dateOfBirth = dateOfBirth;
		
	}
	
	public UserProfile() {}

	@Column(name="phone")
	private String phone;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="gender")
	private Boolean isFemale;
	

	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
}	
