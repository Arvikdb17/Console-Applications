package com.cad.minvangi.repositary;

import java.util.ArrayList;
import java.util.List;

import com.cad.minvangi.dto.Account;

public class MinVangiRepositary {
	
	private static Account loggedInAccount;
	
	private static MinVangiRepositary minVangiRepositary;
	
	public static List<Account> accounts;
	
	private MinVangiRepositary() {
		accounts=new ArrayList<>();
		Account adminAccount=new Account("admin","admin");
		adminAccount.setAdmin(true);
		adminAccount.setAadhar("1234");
		this.accounts.add(adminAccount);
		Account userAccount=new Account("user","user");
		userAccount.setAdmin(false);
		userAccount.setAadhar("10000");
		userAccount.setBalance(1000);
		this.accounts.add(userAccount);
	}
	
	//returns current class object (Singleton)
	public static MinVangiRepositary getInstance() {
		if(minVangiRepositary != null)
			return minVangiRepositary;
		
		return new MinVangiRepositary();
	}
    
	//validates and returns validated account
	public Account validateAndGetAccount(String userName, String password,boolean isAdmin) {
		
		for(Account acc : accounts) {
			if(acc.getUsername().equals(userName) && acc.getPassword().equals(password) && acc.isAdmin()==isAdmin) {
				loggedInAccount=acc;
				return acc;
			}
		}
		return null;
	}
	
	
	// returns currently logged in account
	public static Account getLoggedInAccount() {	
			return loggedInAccount;
			
	}

	
	//return list of user and admin accounts
	public static List<Account> getUserDetails() {
		
		return accounts;
	}

	//checks if account is present or not
	public static boolean isAccountPresent(String name, String aadhar) {
		for(Account acc: accounts) {
			if(acc.getUsername().equals(name) && acc.getAadhar().equals(aadhar))
				return true;
		}
		
		return false;
	}
  
	//Credits amount to user account
	public static void creditAmount(String name, String aadhar, int amount) {
		for(Account acc : accounts) {
			if(acc.getUsername().equals(name) && acc.getAadhar().equals(aadhar)) {
				acc.setBalance(acc.getBalance()+amount);
			}
		}
	}
    
	//debits amount from accounts
	public static boolean debitAmount(String name, String aadhar, int amount) {
		for(Account acc : accounts) {
			if(acc.getUsername().equals(name) && acc.getAadhar().equals(aadhar)) {
				if(acc.getBalance()>amount) {
					acc.setBalance(acc.getBalance()-amount);
					return true;
				}
			}
		}
		return false;
	}

	

}
