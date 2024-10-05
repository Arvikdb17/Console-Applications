package com.cad.bookshub.screens.navigation.admin;


import com.cad.bookshub.screens.navigation.NavigationViewModel;
import com.cad.bookshub.screens.navigation.admin.addview.AddView;
import com.cad.bookshub.screens.navigation.admin.bookview.BookView;
import com.cad.bookshub.screens.navigation.admin.removeview.RemoveView;
import com.cad.bookshub.screens.navigation.admin.userview.UserView;

public class AdminNavigationViewModel extends NavigationViewModel {
	
	private AdminNavigationView adminNavigationView;
	
	AdminNavigationViewModel(AdminNavigationView adminNavigationView){
		this.adminNavigationView=adminNavigationView;
	}

	public void addBooks()  {
		AddView av=new AddView();
		av.onCreate();
		System.out.println();
	}

	public void removeBooks() {
		RemoveView rv=new RemoveView();
		rv.onCreate();
		
		System.out.println();
	}

	public void viewUserDetails() {
		UserView uv=new UserView();
		uv.onCreate();
		
		System.out.println();
	}

	public void viewBookDetails() {
		BookView bv=new BookView();
		bv.onCreate();
		
		System.out.println();
	}
	
	

}
