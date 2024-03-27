package com.zsgs.librarymanagement.returnProcess;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Allot;
import com.zsgs.librarymanagement.search.AssignBookModel;

public class ReturnView {
	
	private ReturnModel returnModel;
	
	public ReturnView() {
		returnModel= new ReturnModel(this);
	}

	public void initreturn() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("\nAllot Book ID For Issue:");
		int n=s.nextInt();
		
		returnModel.returnCalc(n);
	}
	
	/*public void overDueCalc(int n) {
		 
		List<Allot>us= new ArrayList<>();
		us=LibraryDatabase.getInstance().getAllotBook();
		int count=0;
		for(int i=0;i<us.size();i++) {
			if(us.get(i).getAllotBookId()==n) {
				Date d1= java.sql.Date.valueOf(us.get(i).getDate());
				Date d2= java.sql.Date.valueOf(us.get(i).getCurrentDate());
				if(d2.compareTo(d1)>0) {
					System.out.println("Username: "+us.get(i).getName()+"\t"+"Book Id: "+us.get(i).getBookid()+
							"\tIssue Id: "+us.get(i).getAllotBookId()+" OverDue Ammout: rs.5");
					count=1;
				}
			}
		}
		if(count==0) {
			System.out.println("No OverDue Books");
			returnCalc(n);
		}
	}*/
	
}
