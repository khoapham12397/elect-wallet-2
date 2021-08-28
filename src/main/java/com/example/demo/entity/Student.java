package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public String getMajor() {return major;}
	public void setMajor(String major) {this.major = major;}

	@Column(name="email")
	private String email;
	
	@Column(name="major")
	private String major;
}
