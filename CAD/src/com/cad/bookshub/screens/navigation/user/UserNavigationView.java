package com.cad.bookshub.screens.navigation.user;



import com.cad.bookshub.BaseScreen;
import com.cad.bookshub.repositary.BooksHubRepositary;

public class UserNavigationView extends BaseScreen{
	
	private UserNavigationViewModel userNavigationViewModel;
	
	public UserNavigationView() {
		this.userNavigationViewModel=new UserNavigationViewModel(this);
	}

	public void onCreate() {
		printMessage("*************************************");
		int option;
		do {
			printMessage("Please select the operation");
			printMessage("1---> Issue Books");
			printMessage("2---> Return Books");
			printMessage("3---> View Books Issue/Return History");
			printMessage("4---> Logout");
			printMessage("Option : ");
		
		option=BooksHubRepositary.scanner.nextInt();
		switch(option) {
		case 1:
			userNavigationViewModel.issueBook();
			break;
		case 2:
			userNavigationViewModel.returnBook();
			break;
		case 3:
			userNavigationViewModel.viewBooksHistory();
			break;
		case 4:
			userNavigationViewModel.logout();
			break;
		
		 default:
			 printError("Request error : ");
			onCreate();
			break;
		}
		}while(option!=4);
		
		System.out.println();
	}

}
