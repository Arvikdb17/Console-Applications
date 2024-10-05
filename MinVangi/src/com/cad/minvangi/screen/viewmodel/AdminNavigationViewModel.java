package com.cad.minvangi.screen.viewmodel;

import java.util.List;
import java.util.Scanner;

import com.cad.minvangi.dto.Account;
import com.cad.minvangi.repositary.MinVangiRepositary;
import com.cad.minvangi.screen.view.AdminNavigationScreen;

public class AdminNavigationViewModel extends NavigationScreenViewModel{
	private AdminNavigationScreen adNavigationScreen;
    Scanner scanner =new Scanner(System.in);
	public AdminNavigationViewModel(AdminNavigationScreen adNavigationScreen) {
		super(adNavigationScreen);
		this.adNavigationScreen=adNavigationScreen;
	}

	//Adds new account in repositary
	public void addAccount() {
		System.out.println("*************************************");
		Account account=new Account();
		System.out.println("Enter User Name :");
		account.setUsername(scanner.next());
		System.out.println("Enter Password :");
		account.setPassword(scanner.next());
		System.out.println("Enter aadhar no.");
		account.setAadhar(scanner.next());
		getAccountType(account);
		if(!account.isAdmin())
		  account.setBalance(1000);
		MinVangiRepositary.accounts.add(account);
		System.out.println("Account added successfully..");
		
		
	}

	//Gets account type for creating new Account
	private void getAccountType(Account account) {
		System.out.println("*************************************");
		System.out.println("Please Select Account Type :");
		System.out.println("1---> Admin");
		System.out.println("2---> User");
		int accountType=scanner.nextInt();
		if(accountType==1) {
			account.setAdmin(true);
		}
		else if(accountType==2)
			account.setAdmin(false);
		else {
			System.out.println("Invalid request ");
			getAccountType(account);
		}
	}

	//Remove account from repositary if already present
	public void removeAccount() {
		System.out.println("*************************************");
		System.out.println("Enter User Name :");
		
		String name=scanner.next();
		System.out.println("Enter aadhar no.");
		String aadhar=scanner.next();
		boolean isRemoved=false;
		for(int i=0;i<MinVangiRepositary.accounts.size();i++) {
			if(MinVangiRepositary.accounts.get(i).getUsername().equals(name) && MinVangiRepositary.accounts.get(i).getAadhar().equals(aadhar)) {
				MinVangiRepositary.accounts.remove(MinVangiRepositary.accounts.get(i));
				isRemoved=true;
			}
		}
		if(isRemoved) System.out.println("Account removed Successfully");
		else {
			System.out.println("Request failed please try Again");
			adNavigationScreen.onCreate();
		}
		
	}

	//Displays all account details
	public void viewUserAccountDetails() {
		System.out.println("*************************************");
		System.out.println("User Details...");
		List<Account> accounts=MinVangiRepositary.getUserDetails();
		for(int i=0;i<accounts.size();i++) {
			Account account=accounts.get(i);
			System.out.println(i+". Name : "+account.getUsername()+" AadharNo. : "+account.getAadhar()+" Balance : "+account.getBalance());
		}
		
	}

	//deposit amount to user account
	public void depositToUserAccount() {
		System.out.println("*************************************");
		boolean isValid=false;
		int count=3;
		while(isValid!=true && count>0) {
			System.out.println("Enter User Name :");
			String name=scanner.next();
			System.out.println("Enter aadhar no.");
			String aadhar=scanner.next();
			if(MinVangiRepositary.isAccountPresent(name,aadhar)) {
				isValid=true;
				System.out.println("Enter the amount to be credited :");
				int amount=scanner.nextInt();   //must provide Exception Handler in future
				MinVangiRepositary.creditAmount(name,aadhar,amount);
				System.out.println("Amount credited successfully");
				
			}
			else {
				System.out.println("Please enter valid account");
				count--;
			}
		}
		if(count<=0)
			System.out.println("Request failed.");
		adNavigationScreen.onCreate();
		
	}

	//debits amount form user account
	public void debitFromUserAccount() {
		System.out.println("*************************************");
		
		boolean isValid=false;
		int count=3;
		while(isValid!=true && count>0) {
			System.out.println("Enter User Name :");
			String name=scanner.next();
			System.out.println("Enter aadhar no.");
			String aadhar=scanner.next();
			if(MinVangiRepositary.isAccountPresent(name,aadhar)) {
				isValid=true;
				System.out.println("Enter the amount to be debited :");
				int amount=scanner.nextInt();   //must provide Exception Handler in future
				if(MinVangiRepositary.debitAmount(name,aadhar,amount))
				  System.out.println("Amount debited successfully");
				else  System.out.println("Insufficient balance ...");
				adNavigationScreen.onCreate();
			}
			else {
				System.out.println("Please enter valid account");
				count--;
			}
		}
		if(count<=0)
			System.out.println("Request failed.");
		adNavigationScreen.onCreate();
	}
	
}
