package com.cad.bookshub.screens.navigation.admin.addview;

import com.cad.bookshub.BaseScreen;
import com.cad.bookshub.repositary.BooksHubRepositary;

public class AddView extends BaseScreen{
	private AddViewModel addViewModel;
	
	public AddView() {
		this.addViewModel=new AddViewModel(this);
	}

	public void onCreate() {
		int option=1;
		do {	
			printMessage("*** Please enter the Book details *** ");
			printMessage("Name :");
		String bookName=BooksHubRepositary.scanner.next();
		printMessage("\nAuthor :");
		String author=BooksHubRepositary.scanner.next();
		printMessage("\nISBN Number :");
		String isbnNo=BooksHubRepositary.scanner.next();
		
		addViewModel.addBooks(bookName,author,isbnNo);
		printMessage("Please select the option");
		printMessage("1-----> Add more Books");
		printMessage("2-----> Finish adding");
		option=BooksHubRepositary.scanner.nextInt();
		
		}while(option==1);
		
		System.out.println();
		
		
		
		
	}

}
