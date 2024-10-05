package com.cad.bookshub.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
	 private String name;
     private static int idNo;
	 private String password;
     private List<Book> booksBorrowed;
     private List<String> booksHistory;
     private boolean isAdmin;
     
     public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User(String name, String password) {
 		super();
 		this.name = name;
 		this.password = password;
 		this.idNo++;
 		booksBorrowed=new ArrayList<Book>();
 		booksHistory=new ArrayList<String>();
 		
 	}
    
     public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
 		return name;
 	}

 	public void setName(String name) {
 		this.name = name;
 	}

 	public int getIdNo() {
 		return idNo;
 	}

 	public void setIdNo(int memberShipId) {
 		this.idNo = memberShipId;
 	}

 	public String getPassword() {
 		return password;
 	}

 	public void setPassword(String password) {
 		this.password = password;
 	}

 	public List<Book> getBooksBorrowed() {
 		return booksBorrowed;
 	}

 	public void setBooksBorrowed(List<Book> booksBorrowed) {
 		this.booksBorrowed = booksBorrowed;
 	}

 	public List<String> getBooksHistory() {
 		return booksHistory;
 	}

 	public void updateBooksHistoryDetails(String booksHistoryDetail) {
 		this.booksHistory.add(booksHistoryDetail);
 	}
}
