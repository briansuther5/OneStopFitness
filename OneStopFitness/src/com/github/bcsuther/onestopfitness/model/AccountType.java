package com.github.bcsuther.onestopfitness.model;

public class AccountType {

	public final static AccountType administrator = new AccountType("Administrator", "A");
	public final static AccountType accountHolder = new AccountType("Account Holder", "AH");
	public final static AccountType guest = new AccountType("Guest", "G");
	
	private String value;
	private String name;
	
	public AccountType(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getAccountName() {
		return this.name;
	}
	
	public String getAccountValue() {
		return this.value;
	}
}
