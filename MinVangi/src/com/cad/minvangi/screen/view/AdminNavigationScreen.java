package com.cad.minvangi.screen.view;
import java.util.Scanner;

import com.cad.minvangi.dto.Account;
import com.cad.minvangi.screen.viewmodel.*;

public class AdminNavigationScreen extends NavigationScreen {
	private AdminNavigationViewModel adNavigationViewModel;
	
	public AdminNavigationScreen() {
		adNavigationViewModel=new AdminNavigationViewModel(this);
	}
	
	//displays admins actions
	public void onCreate() {
		System.out.println("*************************************");
		int option;
		do {
		System.out.println("Please select the operation");
		System.out.println("1---> Add Account");
		System.out.println("2---> Remove Account");
		System.out.println("3---> View user Account Details");
		System.out.println("4---> Deposit user Account");
		System.out.println("5---> Debit user Account");
		System.out.println("6---> Logout");
		Scanner scanner=new Scanner(System.in);
		 option=scanner.nextInt();
		switch(option) {
		case 1:
			adNavigationViewModel.addAccount();
			break;
		case 2:
			adNavigationViewModel.removeAccount();
			break;
		case 3:
			adNavigationViewModel.viewUserAccountDetails();
			break;
		case 4:
			adNavigationViewModel.depositToUserAccount();
			break;
		case 5:
			adNavigationViewModel.debitFromUserAccount();
			break;
		case 6:
			adNavigationViewModel.logout();;
			break;
		 default:
			System.out.print("Request error : ");
			onCreate();
			break;
		}
		}while(option!=6);
	}

}
