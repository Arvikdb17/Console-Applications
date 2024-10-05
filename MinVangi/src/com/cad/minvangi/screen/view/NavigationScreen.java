package com.cad.minvangi.screen.view;


import com.cad.minvangi.dto.Account;
import com.cad.minvangi.screen.viewmodel.NavigationScreenViewModel;

public class NavigationScreen{
    
	private NavigationScreenViewModel nSViewModel;
	
	public NavigationScreen() {
		this.nSViewModel=new NavigationScreenViewModel(this);
	}
	
	public void onCreate(Account account) {
		nSViewModel.displayNavigationScreen(account);
	
	}
	

}
