package com.zsgs.librarymanagement.returnProcess;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Allot;
import com.zsgs.librarymanagement.search.AssignBookView;

public class ReturnModel {
	private ReturnView returnView;
	
	ReturnModel(ReturnView returnView) {
		this.returnView= returnView;
	}

	public void returnCalc(int n) {
		
		List<Allot>us= new ArrayList<>();
		us=LibraryDatabase.getInstance().getAllotBook();
		
		for(int i=0;i<us.size();i++) {
			if(us.get(i).getAllotBookId()==n) {
				System.out.println("Book Return Successfully");
				us.remove(i);
			}
		}
	}
	
}
