package com.zsgs.librarymanagement.manageusers;

import java.io.IOException;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;

class ManageUsersModel {

	private ManageUsersView manageUsersView;

	ManageUsersModel(ManageUsersView manageUsersView) {
		this.manageUsersView = manageUsersView;
	}

	public void addNewUser(User user) throws Exception {
		if (LibraryDatabase.getInstance().insertUser(user)) {
			manageUsersView.onUserAdded(user);
		} else {
			manageUsersView.onUserExist(user);
		}
	}
}
