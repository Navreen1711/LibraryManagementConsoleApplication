package com.zsgs.librarymanagement.login;

import java.util.Scanner;
import com.zsgs.librarymanagement.LibraryManagement2024;
import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;

public class LoginView {

	private LoginModel loginModel;

	public LoginView() {
		loginModel = new LoginModel(this);
	}

	public void init() throws Exception {
		System.out.println("--- " + LibraryManagement2024.getInstance().getAppName() + " --- \nversion "
				+ LibraryManagement2024.getInstance().getAppVersion());
		System.out.println("\n\nPlease login to proceed.");
		proceedLogin();
	}

	public void onSuccess() throws Exception {
		System.out.flush();
		System.out.println(
				"\n\nLogin successful...\n\n ---- welcome to " + LibraryManagement2024.getInstance().getAppName()
						+ " - v" + LibraryManagement2024.getInstance().getAppVersion() + "----");
		LibrarySetupView librarySetupView = new LibrarySetupView();
		librarySetupView.init();
	}

	public void onLoginFailed(String alertText) throws Exception {
		System.out.println(alertText);
		checkForLogin();
	}

	private void checkForLogin() throws Exception {
		System.out.println("Do you try again? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			proceedLogin();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n ---- Thanks You ----");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForLogin();
		}
	}

	private void proceedLogin() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter the user name:");
		String userName = scanner.next();
		System.out.println("Enter the password:");
		String password = scanner.next();
		loginModel.validateUser(userName, password);
	}
}