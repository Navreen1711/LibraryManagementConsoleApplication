package com.zsgs.librarymanagement.managebook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.User;

public class ManageBookView {

	private ManageBookModel manageBookModel;

	public ManageBookView() {
		manageBookModel = new ManageBookModel(this);
	}

	public void initAdd() throws IOException {
		System.out.println("\nEnter book details: ");
		Scanner scanner = new Scanner(System.in);
		Book book = new Book();
		System.out.println("\nEnter book name:");
		book.setName(scanner.nextLine());
		System.out.println("\nEnter book author:");
		book.setAuthor(scanner.nextLine());
		System.out.println("\nEnter book ID:");
		book.setId(scanner.nextInt());
		System.out.println("\nEnter book volume:");
		book.setVolume(scanner.nextInt());
		manageBookModel.addNewBook(book);
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name - " + libraryName);
	}

	public void onBookAdded(Book book) throws IOException {
		System.out.println("\n------- Book '" + book.getName() + "' added successfully ------- \n");
		checkForAddNewBook();
	}

	public void onBookExist(Book book) throws IOException {
		System.out.println("\n------- Book '" + book.getName() + "' already exist -------\n");
		checkForAddNewBook();
	}

	private void checkForAddNewBook() throws IOException {
		System.out.println("\nDo you want to add more books? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			initAdd();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n Thanks for adding books");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewBook();
		}
	}
	public void initBooklist(){
		List<Book> us = new ArrayList();
		us= LibraryDatabase.getInstance().getAllBooks();
		for(int i=0;i<us.size();i++) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("Book Name:\t "+us.get(i).getName());
			System.out.println("Author:\t "+us.get(i).getAuthor());
			System.out.println("Book ID:\t "+us.get(i).getId());
			System.out.println("Book volume:\t "+us.get(i).getVolume());
			System.out.println("-----------------------------------------------------------");
		}
    }
	
	public void initSearch() {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the Book ID:");
		int n=s.nextInt();
		List<Book> us = new ArrayList();
		us= LibraryDatabase.getInstance().getAllBooks();
		boolean find=false;
		for(int i=0;i<us.size();i++) {
			
			if(n==us.get(i).getId()) {
				find=true;
			System.out.println("-----------------------------------------------------------");
			System.out.println("Book Name:\t "+us.get(i).getName());
			System.out.println("Author:\t "+us.get(i).getAuthor());
			System.out.println("Book ID:\t "+us.get(i).getId());
			System.out.println("Book volume:\t "+us.get(i).getVolume());
			System.out.println("-----------------------------------------------------------");
			}	
			
		}
		if(!find) {
			System.out.println("Books are not available in this library");
		}
	}
}
