package task8.libraryManagementSystem.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Task6ClassAndObject.Book;
import task8.libraryManagementSystem.model.Transaction;
import task8.libraryManagementSystem.model.User;

public class Repository {

	private static Repository repository = null;
	public static int transactionID = 1;
	HashMap<Integer, Book> books;
	HashMap<String, User> users;
	HashMap<String, List<Transaction>> transaction;
	private Repository()
	{
		books = new HashMap<>();
		users = new HashMap<>();
		transaction = new HashMap<>();
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

	public HashMap<String, List<Transaction>> getTransaction() {
		return transaction;
	}
	
	public void setBooks(int id, Book book) {
		this.books.put(id, book);
	}

	public void setUsers(String userID, User user) {
		this.users.put(userID, user);
	}
	
	public void setTransaction(String user, Transaction newTransaction) {
		List<Transaction> list = transaction.getOrDefault(user, new ArrayList<>());;
		list.add(newTransaction);
		this.transaction.put(user, list);
	}
}
