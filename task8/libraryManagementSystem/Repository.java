package task8.libraryManagementSystem;

import java.util.HashMap;

import Task6ClassAndObject.Book;

public class Repository {

	private static Repository repository = null;
	
	HashMap<Integer, Book> books;
	HashMap<String, User> users;
	private Repository()
	{
		books = new HashMap<>();
		users = new HashMap<>();
	}
	public static Repository getInstance()
	{
		if(repository == null)
		{
			return repository =  new Repository();
		}
		return repository;
	}

	public HashMap<Integer, Book> getBooks() {
		return books;
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public void setBooks(int id, Book book) {
		this.books.put(id, book);
	}

	public void setUsers(String userID, User user) {
		this.users.put(userID, user);
	}
}
