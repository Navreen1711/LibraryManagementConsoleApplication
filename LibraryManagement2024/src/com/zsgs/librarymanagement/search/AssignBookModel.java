package com.zsgs.librarymanagement.search;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.model.Allot;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.User;

public class AssignBookModel {
	
	private AssignBookView assignBookView;
	
	AssignBookModel(AssignBookView assignBookView) {
		this.assignBookView= assignBookView;
	}

	public void addNewAllot(Allot al) {
		System.out.println("The second allot" +al.getBookid() );
		if (LibraryDatabase.getInstance().insertAllot(al)) {
			assignBookView.onBookAdded(al);
		} else {
			assignBookView.onBookExist(al);
		}
	}

	
	
}
