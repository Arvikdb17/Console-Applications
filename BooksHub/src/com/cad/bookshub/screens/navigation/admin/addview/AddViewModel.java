package com.cad.bookshub.screens.navigation.admin.addview;

import com.cad.bookshub.dto.Book;
import com.cad.bookshub.repositary.BooksHubRepositary;

public class AddViewModel {
	private AddView addView;

	public AddViewModel(AddView addView) {
		this.addView=addView;
	}

	public void addBooks(String bookName, String author, String isbnNo) {
		Book book=new Book(bookName,author,isbnNo);
		BooksHubRepositary.getInstance().addBooks(book);
		addView.printMessage("Book Sucessfully added.");
		
		
		System.out.println();
	}

}
