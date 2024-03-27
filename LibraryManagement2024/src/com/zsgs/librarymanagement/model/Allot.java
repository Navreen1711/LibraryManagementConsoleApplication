package com.zsgs.librarymanagement.model;

public class Allot {
	
	private String name;
	private int bookid;
	private int allotBookId;
	private String Date;
	private String currentDate;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBookid() {
		return bookid;
	}
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	public int getAllotBookId() {
		return allotBookId;
	}
	
	public void setAllotBookId(int allotBookId) {
		this.allotBookId = allotBookId;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
}
