package com.cad.minvangi;
import com.cad.minvangi.screen.*;
import com.cad.minvangi.screen.view.LoginScreen;

public class MinVangi {

	private String appName = "MinVangi Application";

	private String appVersion = "0.0.1";
	
	
	
	public static void main(String[] args) {
		LoginScreen loginScreen=new LoginScreen();
		loginScreen.onCreate();

	}

}
