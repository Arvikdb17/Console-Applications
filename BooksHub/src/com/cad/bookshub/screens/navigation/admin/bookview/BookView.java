package com.cad.bookshub.screens.navigation.admin.bookview;

import com.cad.bookshub.BaseScreen;
import com.cad.bookshub.repositary.BooksHubRepositary;

public class BookView extends BaseScreen{
	
	private BookViewModel bookViewModel;
	
	public BookView() {
		this.bookViewModel=new BookViewModel(this);
	}
	
	
   public void onCreate() {
	   
	   printMessage("Please Select an option :");
	   printMessage("1----->  View All Books");
	   printMessage("2----->  View specific Book");
	   int option=BooksHubRepositary.scanner.nextInt();
	   switch(option) {
	   case 1:
		   bookViewModel.showAllBooksDetails();
		   break;
	   case 2 :
		   bookViewModel.showBookDetails();
	   }
	   
	   System.out.println();
	   
   }
}
