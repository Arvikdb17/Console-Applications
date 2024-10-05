package com.cad.minvangi.screen.viewmodel;

import java.util.Scanner;

import com.cad.minvangi.dto.Account;
import com.cad.minvangi.repositary.MinVangiRepositary;
import com.cad.minvangi.screen.view.UserNavigationScreen;

public class UserNavigationViewModel extends NavigationScreenViewModel{
	private UserNavigationScreen userNavScreen;

	public UserNavigationViewModel(UserNavigationScreen userNavigationScreen) {
		super(userNavigationScreen);
		this.userNavScreen=userNavigationScreen;
	}
	

	public void withDrawAmount() {
		System.out.println("*************************************");
		System.out.println("Enter the amount to Withdraw");
		Scanner scanner=new Scanner(System.in);
		int amount=scanner.nextInt() ;
		Account acc=MinVangiRepositary.getLoggedInAccount();
		if(MinVangiRepositary.debitAmount(acc.getUsername(), acc.getAadhar(), amount))
			System.out.println("Amount dispensed please collect it in the cash dispenser");
		else System.out.println("Insufficient balance");
		System.out.println("Thank you for banking with us.");
	}

	public void depositAmount() {
		System.out.println("*************************************");
		System.out.println("Enter the amount to deposited");
		Scanner scanner=new Scanner(System.in);
		int amount=scanner.nextInt() ;
		Account acc=MinVangiRepositary.getLoggedInAccount();
		MinVangiRepositary.creditAmount(acc.getUsername(), acc.getAadhar(), amount);
		System.out.println("Amount deposited sucessfully.");
		System.out.println("Thank you for banking with us.");
	}

	public void checkBalance() {
		System.out.println("*************************************");
		Account acc=MinVangiRepositary.getLoggedInAccount();
		System.out.println("Available Balance : "+MinVangiRepositary.getLoggedInAccount().getBalance());
		
		
	}

}
