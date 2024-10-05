package com.cad.minvangi.screen.viewmodel;

import com.cad.minvangi.dto.Account;
import com.cad.minvangi.repositary.MinVangiRepositary;
import com.cad.minvangi.screen.interfaces.ILogout;
import com.cad.minvangi.screen.view.AdminNavigationScreen;
import com.cad.minvangi.screen.view.LoginScreen;
import com.cad.minvangi.screen.view.NavigationScreen;
import com.cad.minvangi.screen.view.UserNavigationScreen;

public class NavigationScreenViewModel implements ILogout{
	
	private NavigationScreen navigationScreen;

	public NavigationScreenViewModel(NavigationScreen navigationScreen) {
		this.navigationScreen=navigationScreen;
	}

	
	//Must create methods identifying user type and call respective 
	// viewmodel methods.
	
	
	@Override
	public void logout() {
		System.out.println("Thank you for banking with us.");
		LoginScreen ls=new LoginScreen();
		ls.onCreate();
		
	}


	public void displayNavigationScreen(Account account) {
		if(account.isAdmin()) {
			AdminNavigationScreen adNavigationScreen = new AdminNavigationScreen();
			adNavigationScreen.onCreate();
		}
		else {
			UserNavigationScreen usNavigationScreen=new UserNavigationScreen();
			usNavigationScreen.onCreate();
		}
		
	}

}
