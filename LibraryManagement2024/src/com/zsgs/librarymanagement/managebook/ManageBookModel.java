package com.zsgs.librarymanagement.managebook;

import java.io.IOException;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;

class ManageBookModel {

	private ManageBookView manageBookView;

	ManageBookModel(ManageBookView manageBookView) {
		this.manageBookView = manageBookView;
	}

	public void addNewBook(Book book) throws IOException {
		if (LibraryDatabase.getInstance().insertBook(book)) {
			manageBookView.onBookAdded(book);
		} else {
			manageBookView.onBookExist(book);
		}
	}
}
