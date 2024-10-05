package com.cad.bookshub.screens.navigation.admin.userview;

import com.cad.bookshub.repositary.BooksHubRepositary;
import com.cad.bookshub.dto.*;


import java.util.List;

public class UserViewModel {
	private UserView userView;
	
	UserViewModel(UserView userView){
		this.userView=userView;
	}

	public void showAllUserDetails()  {
		List<User>  users=BooksHubRepositary.getInstance().getAllUser();
		if(users != null) {
			userView.printMessage("All User Details");
			for(User u: users) {
				userView.printMessage("Name : "+u.getName()+" IdNo : "+u.getIdNo());
				for(Book b : u.getBooksBorrowed()) {
					userView.printMessage(b.getTitle());
				}
				for(String s : u.getBooksHistory()) {
					userView.printMessage(s);
				}
				userView.printMessage("************************");
			}
			
		}
		System.out.println();
		
		
	}

	public void showUserDetails() {
		userView.printMessage("Please enter the Details");
		userView.printMessage("Name : ");
	    String name=BooksHubRepositary.scanner.next();
	    userView.printMessage("\nIdNo : ");
	    int id=BooksHubRepositary.scanner.nextInt();
	    
	    User u=BooksHubRepositary.getInstance().getUser(name,id);
	    
	    if(u !=null) {
	    	userView.printMessage("User Detail");
	    	userView.printMessage("Name : "+u.getName()+" IdNo : "+u.getIdNo());
	    	for(Book b : u.getBooksBorrowed()) {
	    		userView.printMessage(b.getTitle());
			}
			for(String s : u.getBooksHistory()) {
				userView.printMessage(s);
			}
			userView.printMessage("************************");
	    }
	    else
	    	userView.printError("No user matched with your details.");
	    
	    System.out.println();
	}

}
