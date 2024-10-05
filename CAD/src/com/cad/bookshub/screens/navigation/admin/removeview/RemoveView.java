package com.cad.bookshub.screens.navigation.admin.removeview;



import com.cad.bookshub.BaseScreen;
import com.cad.bookshub.repositary.BooksHubRepositary;

public class RemoveView extends BaseScreen{
	
	private RemoveViewModel removeViewModel;
	
	public RemoveView() {
		this.removeViewModel=new RemoveViewModel(this);
	}

	public void onCreate()  {
		int option=1;
		do {	
		printMessage("*** Please enter the Book details *** ");
		printMessage("Name :");
		String bookName=BooksHubRepositary.scanner.next();
		printMessage("\nISBN No. :");
		
		String isbnNo=BooksHubRepositary.scanner.next();
		
		removeViewModel.removeBooks(bookName,isbnNo);
		printMessage("Please select the option");
		printMessage("1-----> Remove more Books");
		printMessage("2-----> Finish removing");
		option=BooksHubRepositary.scanner.nextInt();
		
		}while(option==1);
		
		System.out.println();
	}

}
