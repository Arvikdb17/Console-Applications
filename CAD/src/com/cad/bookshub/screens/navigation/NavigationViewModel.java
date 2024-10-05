package com.cad.bookshub.screens.navigation;



import com.cad.bookshub.interfaces.ILogout;
import com.cad.bookshub.repositary.BooksHubRepositary;
import com.cad.bookshub.screens.login.LoginView;
import com.cad.bookshub.screens.navigation.admin.AdminNavigationView;
import com.cad.bookshub.screens.navigation.user.UserNavigationView;

public class NavigationViewModel implements ILogout {

	private NavigationView navigationView;
	public NavigationViewModel(NavigationView navigationView) {
		this.navigationView=navigationView;
	}
	public NavigationViewModel() {

		
	}
	
	public void displayNavigationView()  {
		if(BooksHubRepositary.getInstance().isLoggedInAccountAdmin()) {
			AdminNavigationView adNavigationView=new AdminNavigationView();
			adNavigationView.onCreate();
			
		}
		else {
			UserNavigationView usNavigationView=new UserNavigationView();
			usNavigationView.onCreate();
			
		}
	}
	@Override
	public void logout() {
		navigationView.printMessage("Thank you please come again..!");
	/*	LoginView ls=new LoginView();
		ls.onCreate();*/
		
	}

}
