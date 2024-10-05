package com.cad.bookshub.screens.login;



import com.cad.bookshub.BaseScreen;
import com.cad.bookshub.dto.User;
import com.cad.bookshub.repositary.BooksHubRepositary;
import com.cad.bookshub.screens.navigation.NavigationView;

public class LoginView extends BaseScreen{
	private LoginViewModel loginViewModel;
	
	public LoginView(){
		this.loginViewModel=new LoginViewModel(this);
	}

	public void onCreate()  {
		
		printMessage("****** Welcome to BooksHub ******");
		
		printMessage("\nPlease Login to Proceed");
		printMessage("\nEnter User name :");
		String name=BooksHubRepositary.scanner.next();
		printMessage("\nEnter User password :");
		String password=BooksHubRepositary.scanner.next();
		boolean isAdmin;
		printMessage("Please Select Type  :");
		printMessage("1----> Admin");
		printMessage("2----> User");
		int n=BooksHubRepositary.scanner.nextInt();
		isAdmin=n==1;
		
		loginViewModel.validateUser(name,password,isAdmin);
			
		
	
		System.out.println();
	}

	public void navigateView()  {
		NavigationView nv=new NavigationView();
		nv.onCreate();
		System.out.println();
	}

}
