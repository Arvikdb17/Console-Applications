package com.cad.bookshub;



import com.cad.bookshub.screens.login.LoginView;

public class BooksHub {
    
	private String appName = "Books Hub Application";

	private String appVersion = "0.0.1";
	
	public static void main(String[] args)  {
		LoginView loginView=new LoginView();
        loginView.onCreate();
	}

}
