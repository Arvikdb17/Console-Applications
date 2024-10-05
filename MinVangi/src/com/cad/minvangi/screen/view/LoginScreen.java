package com.cad.minvangi.screen.view;

import java.util.Scanner;

import com.cad.minvangi.BaseScreen;
import com.cad.minvangi.dto.Account;
import com.cad.minvangi.screen.viewmodel.*;

public class LoginScreen extends BaseScreen{
	
	private LoginScreenViewModel loginScreenViewModel;
	
	public LoginScreen() {
		loginScreenViewModel=new LoginScreenViewModel(this);
	}
	
	//Get user details for login
	public void onCreate() {
		if (hasNetworkConnection()) {
			System.out.println("*************************************");
			System.out.println("Welcome to MinVangi Service ...");
			
			System.out.println("\n\nPlease login to proceed.");
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nEnter the user name:");
			String userName = scanner.next();
			System.out.println("Enter the password:");
			String password = scanner.next();
			boolean admin;
			System.out.println("Please Select Type  :");
			System.out.println("1----> Admin");
			System.out.println("2----> User");
			int n=scanner.nextInt();
			admin=n==1;
			
			
			loginScreenViewModel.validateUser(userName, password,admin);
		} else {
			System.out.println("Please check internet connection");
		}
	}

	public void showAdminNavigationScreen() {
		AdminNavigationScreen adminNavigationScreen=new AdminNavigationScreen();
		adminNavigationScreen.onCreate();
		
	}
	
	public void showUserNavigationScreen() {
		UserNavigationScreen userNavScreen=new UserNavigationScreen();
		userNavScreen.onCreate();
	}

	public void navigateScreen(Account account) {
		NavigationScreen navigationScreen=new NavigationScreen();
		navigationScreen.onCreate(account);
		
	}

}
