package com.zsgs.librarymanagement.librarysetup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement2024;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.manageusers.ManageUsersView;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.returnProcess.ReturnView;
import com.zsgs.librarymanagement.search.AssignBookView;


//Access modifier for this LibrarySetupView class should be public. 
//So that outside of the package this class can be accessed and can create instance for this class.
public class LibrarySetupView {

	// This variable should be private.
	// so that outside of this class cannot access this variable.
	private LibrarySetupModel librarySetupModel;

	// This Constructor should be public.
	// so that all classes can create instance of this class.
	public LibrarySetupView() throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {
		librarySetupModel = new LibrarySetupModel(this);
	}

	public void init() throws Exception {
		librarySetupModel.startSetup();
	}

	public void onSetupComplete(Library library) throws Exception {
		System.out.println("\nLibrary setup completed\n");
		System.out.println("\nCurrent Library Name - " + library.getLibraryName());
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println(
					"\n 1. Add Book\n 2. Add user \n 3. Show list of Books \n 4. User'List \n 5. Search Book \n"
					+ " 6. Borrow Book \n 7. Return Book \n 8. Borrow Book List \n 9. Logout \n 0. Exit \n Enter your Choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				new ManageBookView().initAdd();
				break;
			case 2:
				new ManageUsersView().initAdd();
				break;
			case 3:
				System.out.println("\nList of books in the Library \n");
				new ManageBookView().initBooklist();
				break;
			case 4:
				System.out.println("Library user's list:");
				new ManageUsersView().initUserlist();
				break;
			case 5:
				new ManageBookView().initSearch();
				break;
			case 6:
				new AssignBookView().initAdd();
				break;
			case 7:
				new ReturnView().initreturn();
				break;
			case 8:
				new AssignBookView().initShowList();
				break;
			case 9:
				System.out.println("\n-- You are logged out successfully -- \n\n");
				new LoginView().init();
				return; 
			case 0:
				System.out.println("\n-- Thanks for using " + LibraryManagement2024.getInstance().getAppName() + " --");
				return; 
			default:
				System.out.println("\nPlease Enter valid choice\n");
			}
		}
	}

	public void showAlert(String alert) throws Exception {
		System.out.println(alert);
		initiateSetup();
	}

	public void initiateSetup() throws Exception {
		System.out.println("\n\nEnter library details:");
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		System.out.println("\nEnter library name:");
		library.setLibraryName(scanner.nextLine());
		System.out.println("\nEnter library email:");
		library.setEmailId(scanner.nextLine());
		librarySetupModel.createLibrary(library);
	}
}
