package com.cad.bookshub.screens.navigation;



import com.cad.bookshub.BaseScreen;

public class NavigationView extends BaseScreen{
	
	private NavigationViewModel navigationViewModel;
	
	public NavigationView() {
		this.navigationViewModel=new NavigationViewModel(this);
	}

	public void onCreate()  {
		navigationViewModel.displayNavigationView();
		
	}

}
