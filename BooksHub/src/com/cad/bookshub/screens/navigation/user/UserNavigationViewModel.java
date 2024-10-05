package com.cad.bookshub.screens.navigation.user;

import java.util.Date;
import java.util.List;

import com.cad.bookshub.repositary.BooksHubRepositary;
import com.cad.bookshub.screens.navigation.NavigationViewModel;

public class UserNavigationViewModel extends NavigationViewModel{
	private UserNavigationView userNavigationView;

	public UserNavigationViewModel(UserNavigationView userNavigationView) {
		this.userNavigationView=userNavigationView;
	}

	public void issueBook() {
		userNavigationView.printMessage("****** Please enter Book Details ******");
		userNavigationView.printMessage("Book name : ");
		String name=BooksHubRepositary.scanner.next();
		userNavigationView.printMessage("\nAuthor : ");
		String author=BooksHubRepositary.scanner.next();
		if(BooksHubRepositary.getInstance().isBookPresent(name,author)) {
			if(BooksHubRepositary.getInstance().isBookAvailable(name,author)) {
				if(BooksHubRepositary.getInstance().issueBook(name, author)) {
					Date date=new Date();
					BooksHubRepositary.getInstance().getLoggedInUser().updateBooksHistoryDetails("Book Name : "+name+" Author : "+author+" issued on : "+ date);
					userNavigationView.printMessage("Book issued sucessfully.");
				}
			}
			else
				userNavigationView.printError("Book isn't available right now please come back after some days. Sorry for the inconvenience");
		}
		else
			userNavigationView.printError("Book isn't available in this library. Sorry for the inconvenience");
		
		System.out.println();
	}

	public void returnBook() {
		userNavigationView.printMessage("****** Please enter Book Details ******");
		userNavigationView.printMessage("Book name : ");
		String name=BooksHubRepositary.scanner.next();
		userNavigationView.printMessage("\nAuthor : ");
		String author=BooksHubRepositary.scanner.next();
		if(BooksHubRepositary.getInstance().isBookPresent(name,author)) {
			BooksHubRepositary.getInstance().returnBook(name,author);
			Date date=new Date();
			BooksHubRepositary.getInstance().getLoggedInUser().updateBooksHistoryDetails("Book Name : "+name+" Author : "+author+" returned on : "+ date);
			userNavigationView.printMessage("Book returned sucessfully.");
		}
		else {
			userNavigationView.printError("Books mismatch please check with any other library.");
		}
		System.out.println();
	}

	public void viewBooksHistory() {
		List<String> history=BooksHubRepositary.getInstance().getLoggedInUser().getBooksHistory();
		if(history!=null) {
			userNavigationView.printMessage("Books History");
			for(String s: history)
				userNavigationView.printMessage(s);
			
		}
		
	    
	    System.out.println();
	}

}
