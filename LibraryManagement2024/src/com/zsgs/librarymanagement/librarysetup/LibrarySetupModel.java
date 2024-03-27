package com.zsgs.librarymanagement.librarysetup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Library;

class LibrarySetupModel {

	
	private LibrarySetupView librarySetupView;

	private Library library;

	LibrarySetupModel(LibrarySetupView librarySetupView) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {
		this.librarySetupView = librarySetupView;
		library = LibraryDatabase.getInstance().getLibrary();
	}

	public void startSetup() throws Exception {
		if (library == null || library.getLibraryId() == 0) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete(library);
		}
	}

	public void createLibrary(Library library) throws Exception {
		if (library.getLibraryName().length() <3  || library.getLibraryName().length() > 50) {
			librarySetupView.showAlert("Enter valid name");
			return;
		}
		this.library = LibraryDatabase.getInstance().insertLibrary(library);		
		librarySetupView.onSetupComplete(library);
	}
}
