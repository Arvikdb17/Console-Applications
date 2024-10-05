package com.cad.bookshub.screens.navigation.admin.userview;



import com.cad.bookshub.BaseScreen;
import com.cad.bookshub.repositary.BooksHubRepositary;

public class UserView extends BaseScreen{
	private UserViewModel userViewModel;
	
	public UserView() {
		this.userViewModel=new UserViewModel(this);
	}

	public void onCreate()  {
		printMessage("Please Select an option :");
		printMessage("1----->  View All User");
		printMessage("2----->  View specific User");
		   int option=BooksHubRepositary.scanner.nextInt();
		   switch(option) {
		   case 1:
			   userViewModel.showAllUserDetails();
			   break;
		   case 2 :
			   userViewModel.showUserDetails();
		   }
		   
		   System.out.println();
	}

}
