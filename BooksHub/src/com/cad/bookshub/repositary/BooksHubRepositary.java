package com.cad.bookshub.repositary;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cad.bookshub.dto.*;
public class BooksHubRepositary {
	
	private static  BooksHubRepositary booksHubRepositary;
	public static Scanner scanner=new Scanner(System.in);
	private   List<Book> books;
	private   List<User> users;
	private   User loggedInUser;
	
	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	private BooksHubRepositary() {
		this.books=new ArrayList<>();
		addDefaultBooks();
		this.users=new ArrayList<>();
		User admin=new User("admin","admin");
		admin.setAdmin(true);
		users.add(admin);
		User user=new User("user","user");
		users.add(user);
		
		
	}
	
	private  void addDefaultBooks(){
		
		books.add(new Book("Sapiens","Yuval","1001"));
		books.add(new Book("Educated","Tara","1002"));
		books.add(new Book("ImmortalLife","Rebecca","1003"));
		books.add(new Book("Habits","Charles","1004"));
		books.add(new Book("Becoming","Michelle","1005"));
		
	}
	
	public static BooksHubRepositary getInstance() {
		if(booksHubRepositary==null) {
			 booksHubRepositary=new BooksHubRepositary();
		}
		
		return  booksHubRepositary;
	}

	public boolean validateUser(String name, String password, boolean isAdmin) {
		for(User user:users ) {
			if(user.getName().equals(name) && user.getPassword().equals(password) && user.isAdmin()==isAdmin) {
				this.loggedInUser=user;
				return true;
			}
				
                
		}
		return false;
	}

	public  boolean isLoggedInAccountAdmin() {
		return getInstance().loggedInUser.isAdmin();
		
	}

	public void addBooks(Book book) {
	    books.add(book);
	}

	public  boolean removeBook(Book book) {
		for(Book b :books) {
			if(b.getTitle().equals(book.getTitle()) && b.getIsbnNo().equals(book.getIsbnNo()) && b.isAvailable()){
				books.remove(b);
				return true;
			
			}
		}
		return false;
		
	}

	public  List<Book> getAllBooks(){
		return books;
	}

	public Book getBook(String name, String author) {
		for(Book b :books) {
			if(b.getTitle().equals(name) && b.getAuthor().equals(author)){
				return b;
			
			}
		}
		return null;
	}

	public List<User> getAllUser() {
	    return	users;
		
	}

	public User getUser(String name, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isBookPresent(String name,String author) {
		for(Book b : books) {
			if(b.getAuthor().equals(author) && b.getTitle().equals(name))
				return true;
		}
		return false;
	}

	public boolean isBookAvailable(String name, String author) {
		for(Book b : books) {
			if(b.getAuthor().equals(author) && b.getTitle().equals(name) && b.isAvailable())
				return true;
		}
		return false;
	}

	public boolean issueBook(String name, String author) {
		for(Book b : books) {
			if(b.getAuthor().equals(author) && b.getTitle().equals(name)) {
				b.setAvailable(false);
				return true;
			}
		}
		return false;
	}

	public void returnBook(String name, String author) {
		for(Book b: books) {
			if(b.getTitle().equals(name)&& b.getAuthor().equals(author)) {
				b.setAvailable(true);
			}
		}
		
	}

	

}
