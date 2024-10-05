package com.cad.bookshub.screens.navigation.admin;


import java.util.Scanner;

import com.cad.bookshub.BaseScreen;
import com.cad.bookshub.repositary.BooksHubRepositary;

public class AdminNavigationView extends BaseScreen{
	
	private AdminNavigationViewModel adminNavigationViewModel;
	
	public AdminNavigationView() {
		this.adminNavigationViewModel=new AdminNavigationViewModel(this);
	}

	public void onCreate()  {
		System.out.println("*************************************");
		int option;
		do {
			printMessage("Please select the operation");
			printMessage("1---> Add Books");
			printMessage("2---> Remove Books");
			printMessage("3---> View user  Details");
			printMessage("4---> View Book Details");
			printMessage("5---> Logout");
		
		option=BooksHubRepositary.scanner.nextInt();
		switch(option) {
		case 1:
			adminNavigationViewModel.addBooks();
			break;
		case 2:
			adminNavigationViewModel.removeBooks();
			break;
		case 3:
			adminNavigationViewModel.viewUserDetails();
			break;
		case 4:
			adminNavigationViewModel.viewBookDetails();
			break;
		
		case 5:
			adminNavigationViewModel.logout();;
			break;
		 default:
			 printError("Request error : ");
			onCreate();
			break;
		}
		}while(option!=5);
		System.out.println();
	}

}
