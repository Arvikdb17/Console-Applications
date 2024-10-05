package com.cad.minvangi.screen.viewmodel;

import com.cad.minvangi.screen.view.*;

import com.cad.minvangi.dto.*;
import com.cad.minvangi.repositary.MinVangiRepositary;

import java.util.*;

public class LoginScreenViewModel {
	private LoginScreen loginScreen;
	
	
	public LoginScreenViewModel(LoginScreen loginScreen) {
		this.loginScreen=loginScreen;
		
		
	}
    
     
	public void validateUser(String userName, String password, boolean admin) {
		
		Account account= MinVangiRepositary.getInstance().validateAndGetAccount(userName,password,admin);
		if(account != null) {
			loginScreen.navigateScreen(account);
		}
	}
	

}
