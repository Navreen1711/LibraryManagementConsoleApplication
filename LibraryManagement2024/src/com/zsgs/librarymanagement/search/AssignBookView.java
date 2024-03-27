package com.zsgs.librarymanagement.search;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Allot;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.User;
import java.util.*;

public class AssignBookView {
	
	private AssignBookModel assignBookModel;
	
	public AssignBookView() {
		assignBookModel= new AssignBookModel(this);
	}
	
	public void initAdd() {
		Scanner s = new Scanner(System.in);
		Allot al= new Allot();
		System.out.println("Enter User Name:");
		al.setName(s.nextLine());
		
		System.out.println("\nEnter Book ID: ");
		al.setBookid(s.nextInt());
		
		System.out.println("\nAllot Book ID For Issue:");
		al.setAllotBookId(s.nextInt());
		
		/*System.out.println("\nEnter Issue Date:");
		al.setDate(s.nextLine());
		
		System.out.println("\nEnter Current Date:");
		al.setCurrentDate(s.nextLine());*/
		
		//System.out.println("Allot model"+ al.getBookid());
		assignBookModel.addNewAllot(al);
	}


	public void onBookAdded(Allot allot) {
		System.out.println("\n------- Book '" + allot.getName() + "' assign successfully ------- \n");
		checkForAddNewBook();
	}
	
	public void onBookExist(Allot allot) {
		System.out.println("\n------- Book '" + allot.getName() + "' already assign -------\n");
		checkForAddNewBook();
	}

	
	private void checkForAddNewBook() {
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

	public void initShowList() {
		List<Allot> us = new ArrayList();
		us= LibraryDatabase.getInstance().getAllotBook();
		for(int i=0;i<us.size();i++) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("Book Name:\t "+us.get(i).getName());
			System.out.println("Book ID:\t "+us.get(i).getBookid());
			System.out.println("Issue no:\t "+us.get(i).getAllotBookId());
			System.out.println("-----------------------------------------------------------");
		}
		if(us.size()==0) {
			System.out.println("There is no borrowed book history");
		}
		
	}
	

}
