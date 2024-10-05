package com.cad.minvangi.screen.view;

import java.util.Scanner;

import com.cad.minvangi.screen.viewmodel.UserNavigationViewModel;

public class UserNavigationScreen extends NavigationScreen {
	private UserNavigationViewModel userNavViewModel;
	
    public UserNavigationScreen() {
    	this.userNavViewModel=new UserNavigationViewModel(this);
    }

  //displays user actions
	public void onCreate() {
		System.out.println("*************************************");
		System.out.println("Please select the operation");
		int option;
		do {
		System.out.println("Please select the operation");
		System.out.println("1---> Withdraw amount");
		System.out.println("2---> Deposit amount");
		System.out.println("3---> Check Balance");
		System.out.println("4---> Logout");
		
		Scanner scanner=new Scanner(System.in);
		 option=scanner.nextInt();
		switch(option) {
		case 1:
			userNavViewModel.withDrawAmount();
			break;
		case 2:
			userNavViewModel.depositAmount();
			break;
		case 3:
			userNavViewModel.checkBalance();
			break;
		case 4:
			userNavViewModel.logout();
			break;
		
		 default:
			System.out.print("Request error : ");
			onCreate();
			break;
		}
		}while(option!=6);
		
	}
    
}
