package com.cad.bookshub;

public abstract class BaseScreen {

	protected boolean hasNetworkConnection() {
		return checkConnection(); // Write logic for checking Internet access
	}
	
	private boolean checkConnection() {
		return true; // Write logic for check Internet access
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public void printError(String error) {
		System.err.println(error);
	}
	
	
}
