package com.cad.bookshub.screens.login;

import com.cad.bookshub.dto.User;
import com.cad.bookshub.repositary.BooksHubRepositary;

class LoginViewModel {

	private LoginView loginView;
	
	public LoginViewModel(LoginView loginView) {
		this.loginView=loginView;
	}

	public void validateUser(String name, String password, boolean isAdmin) {
		if(BooksHubRepositary.getInstance().validateUser(name,password,isAdmin)) {
			loginView.printMessage("Welcome back : "+name);
			loginView.navigateView();
		}
		else {
			loginView.printError("Invalid User name or password");
			loginView.onCreate();
		}
	
		
	}

}
