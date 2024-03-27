package com.zsgs.librarymanagement.datalayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.zsgs.librarymanagement.LibraryManagement2024;
import com.zsgs.librarymanagement.model.Allot;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;

public class LibraryDatabase {

	private static LibraryDatabase libraryDatabase;

	private Library library;
	private User user;
	
	private List<Book> bookList = new ArrayList();
	private List<User> userList = new ArrayList();
	private List<Allot> allotbook= new ArrayList();
	
	void saveBook() throws IOException {
		
		JSONArray jsArray= new JSONArray();
		for(int i=0;i<bookList.size();i++) {
			JSONObject js=new JSONObject();
			js.put("Book Name",bookList.get(i).getName());
			js.put("Book Author",bookList.get(i).getAuthor());
			js.put("Book ID",bookList.get(i).getId());
			js.put("Book Volume",bookList.get(i).getVolume());
			
			jsArray.add(js);
		}
		
		FileWriter filewriter= new FileWriter("JSONBook.json");
		filewriter.write(jsArray.toJSONString());
		filewriter.close();
	}
	
	private List<Book> getBookList() throws FileNotFoundException, IOException, ParseException{
		List<Book>book= new ArrayList();
		File file = new File("JSONBook.json");
		if(!file.exists() || file.length()==0) {
			return book;
		}
		JSONParser parser= new JSONParser();
		JSONArray jArray= (JSONArray) parser.parse(new FileReader("JSONBook.json"));
		
		for(Object obj: jArray) {
			JSONObject jObj= (JSONObject)obj;
			String name=(String) jObj.get("Book Name");
			String author=(String) jObj.get("Book Author");
			long id= (long) jObj.get("Book ID");
			long volume=(long) jObj.get("Book Volume");
			
			Book b = new Book();
			b.setName(name);
			b.setAuthor(author);
			b.setId((int)id);
			b.setVolume((int)volume);
			book.add(b);
		}
		
		return book;
	}
	void saveUser() throws IOException {
		
		JSONArray jsArray= new JSONArray();
		for(int i=0;i<userList.size();i++) {
			JSONObject js=new JSONObject();
			js.put("User Name",userList.get(i).getName());
			js.put("User EmailID",userList.get(i).getEmailId());
			jsArray.add(js);
		}
		
		FileWriter filewriter= new FileWriter("JSONUser.json");
		filewriter.write(jsArray.toJSONString());
		filewriter.close();
	}
	
	private List<User> getUserList() throws FileNotFoundException, IOException, ParseException{
		List<User>user= new ArrayList();
		File file = new File("JSONUser.json");
		if(!file.exists() || file.length()==0) {
			return user;
		}
		JSONParser parser= new JSONParser();
		JSONArray jArray= (JSONArray) parser.parse(new FileReader("JSONUser.json"));
		
		for(Object obj: jArray) {
			JSONObject jObj= (JSONObject)obj;
			String name=(String) jObj.get("User Name");
			String email=(String) jObj.get("User EmailID");
			
			User u = new User();
			u.setName(name);
			u.setEmailId(email);
			
			user.add(u);
		}
		
		
		return user;
	}
	

	public static LibraryDatabase getInstance() {

		if (libraryDatabase == null) {
			libraryDatabase = new LibraryDatabase();
		}
		return libraryDatabase;
	}

	public Library getLibrary() throws java.text.ParseException, FileNotFoundException, IOException, ParseException{
		
		bookList=getBookList();
		userList=getUserList();
		return library;// SQL query and it's result here.
	}

	public Library insertLibrary(Library library2) {
		this.library = library2;
		this.library.setLibraryId(1);
		return library;
	}

	public List<Book> getAllBooks() {
		return bookList;
	}
	public List<User> getAllUser() {
		return userList;
	}
	public List<Allot> getAllotBook() {
		return allotbook;
	}

	public Book getBook(int bookId) {
		for (Book book : bookList) {
			if (book.getId() == bookId) {
				return book;
			}
		}
		// select query with where condition.
		return null;
	}

	public List<Book> searchBooks(String bookName) {
		List<Book> searchResult = new ArrayList();
		for (Book book : bookList) {
			if (book.getName().contains(bookName)) {
				searchResult.add(book);
			}
		}
		// select query with where condition.
		return searchResult;
	}

	public boolean insertBook(Book book) throws IOException {
		boolean hasBook = false;
		for (Book addedBook : bookList) {
			if (addedBook.getName().equals(book.getName()) && addedBook.getAuthor().equals(book.getAuthor())) {
				hasBook = true;
				break;
			}
		}
		if (hasBook) {
			return false;
		} else {
			bookList.add(book);
			saveBook();
			return true;
		}
	}

	public boolean insertUser(User user) throws IOException {
		boolean hasUser = false;
		for (User addedUser : userList) {
			if (addedUser.getEmailId().equals(user.getEmailId())) {
				hasUser = true;
				break;
			}
		}
		if (hasUser) {
			return false;
		} else {
			userList.add(user);
			saveUser();
			return true;
		}
	}

	public boolean insertAllot(Allot allot) {
		System.out.println("The name"+allot.getName());
		boolean hasBook = false;
		for (Allot addedBook : allotbook) {
			if (addedBook.getName().equals(allot.getName()) || addedBook.getBookid()==allot.getBookid() ) {
				hasBook = true;
				break;
			}
		}
		if (hasBook) {
			return false;
		} else {
			
			allotbook.add(allot);
			System.out.println("Print Allot"+ allotbook);
			return true;
		}
	}
	
	

}
