package com.cad.bookshub.screens.navigation.admin.bookview;

import java.util.List;

import com.cad.bookshub.BaseScreen;
import com.cad.bookshub.dto.Book;
import com.cad.bookshub.repositary.BooksHubRepositary;

class BookViewModel extends BaseScreen {
	private BookView bookView;
	
	BookViewModel(BookView bookView){
		this.bookView=bookView;
	}

	public void showAllBooksDetails() {
		List<Book> books=BooksHubRepositary.getInstance().getAllBooks();
		int n=1;
		bookView.printMessage("All Books Details");
		for(Book b:books) {
			if(b.isAvailable())
			 bookView.printMessage(n+". Name : "+b.getTitle()+" Author : "+b.getAuthor()+ " ISBN N0. : "+b.getIsbnNo()+" Status : Available");
			else
				bookView.printError(n+". Name : "+b.getTitle()+" Author : "+b.getAuthor()+ " ISBN N0. : "+b.getIsbnNo()+" Status : Not Available");
			n++;
		}
		
		System.out.println();
	}

	public void showBookDetails() {
		bookView.printMessage("Please enter the Details");
		bookView.printMessage("Name : ");
	    String name=BooksHubRepositary.scanner.next();
	    bookView.printMessage("\nAuthor : ");
	    String author=BooksHubRepositary.scanner.next();
	    
	    Book b=BooksHubRepositary.getInstance().getBook(name,author);
	    if(b !=null) {
	    	bookView.printMessage("Book Details");
	    	if(b.isAvailable())
	    		bookView.printMessage(". Name : "+b.getTitle()+" Author : "+b.getAuthor()+ " ISBN N0. : "+b.getIsbnNo()+" Status : Available");
				else
					bookView.printError(". Name : "+b.getTitle()+" Author : "+b.getAuthor()+ " ISBN N0. : "+b.getIsbnNo()+" Status : Not Available");
	    }
	    else
	    	bookView.printError("No book matched in this Library");
		
	    System.out.println();
	}

}
