package com.github.bcsuther.onestopfitness.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="UserProfile")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private Date accountCreatedDate;
	private String accountType;
	private String password;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getAccountCreatedDate() {
		return accountCreatedDate;
	}
	public void setAccountCreatedDate(Date accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
