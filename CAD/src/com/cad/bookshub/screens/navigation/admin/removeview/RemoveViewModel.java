package com.cad.bookshub.screens.navigation.admin.removeview;



import com.cad.bookshub.dto.Book;
import com.cad.bookshub.repositary.BooksHubRepositary;

public class RemoveViewModel {
	private RemoveView removeView;

	public RemoveViewModel(RemoveView removeView) {
		this.removeView=removeView;
	}

	public void removeBooks(String bookName, String isbnNo)  {
		Book book=new Book(bookName,isbnNo);
		if(BooksHubRepositary.getInstance().removeBook(book)) {
			removeView.printMessage("Book removed sucessfully");
		}
		else {
			removeView.printError("Request failed.");
		}
		
		System.out.println();
	}

}
