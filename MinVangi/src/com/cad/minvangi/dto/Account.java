package com.cad.minvangi.dto;

public class Account {
	private String username;
	private String password;
	private double balance;
	private boolean admin;
	private String aadharNo ; 
	
	
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.setAdmin(false);
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getAadhar() {
		return aadharNo;
	}
	public void setAadhar(String aadhar) {
		this.aadharNo = aadhar;
	}
   
}
