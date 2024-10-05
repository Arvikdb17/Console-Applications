package com.cad.bookshub.dto;

public class Book {
	private String title;
	private String author;
	private String isbnNo;
	private boolean isAvailable;
	
	public Book(String title, String author, String isbnNo) {
		super();
		this.title = title;
		this.author = author;
		this.isbnNo = isbnNo;
	    this.isAvailable=true;
	}
	
	public Book(String bookName, String isbnNo) {
		this.title=bookName;
		this.isbnNo=isbnNo;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
