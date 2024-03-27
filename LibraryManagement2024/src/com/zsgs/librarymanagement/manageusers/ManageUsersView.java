package com.zsgs.librarymanagement.manageusers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.User;

public class ManageUsersView {

	private ManageUsersModel manageUserModel;

	public ManageUsersView() {
		manageUserModel = new ManageUsersModel(this);
	}

	public void initAdd() throws Exception {
		System.out.println("Enter the following user Details: ");
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		System.out.println("\nEnter user name:");
		user.setName(scanner.nextLine());
		System.out.println("\nEnter user emailId:");
		user.setEmailId(scanner.next());
		manageUserModel.addNewUser(user);
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name - " + libraryName);
	}

	public void onUserAdded(User user) throws Exception {
		System.out.println("\n------- User '" + user.getName() + "' added successfully ------- \n");
		checkForAddNewUser();
	}

	public void onUserExist(User user) throws Exception {
		System.out.println("\n------- User '" + user.getName() + "' already exist -------\n");
		checkForAddNewUser();
	}

	private void checkForAddNewUser() throws Exception {
		System.out.println("Do you want to add more users? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			initAdd();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n Thanks for adding users");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewUser();
		}
	}
	public void initUserlist(){
		List<User> us = new ArrayList();
		us= LibraryDatabase.getInstance().getAllUser();
		for(int i=0;i<us.size();i++) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("User Name: "+us.get(i).getName());
			System.out.println("User EmailID: "+us.get(i).getEmailId());
			System.out.println("-----------------------------------------------------------");
		}
    }
	
}
