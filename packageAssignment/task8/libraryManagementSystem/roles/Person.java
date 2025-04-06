package task8.libraryManagementSystem.roles;



import java.util.HashMap;
import java.util.Scanner;

import Task6ClassAndObject.Book;
import task8.libraryManagementSystem.LibraryController;
import task8.libraryManagementSystem.database.Repository;
import task8.libraryManagementSystem.model.User;

public abstract class Person {
	public abstract void showMenu(String id);
	
	public static Person getAuthorization(String userID)
	{
		if(userID.contains("Admin"))
		{
			return new Admin();
		}
		else
		{
			return new Customer();
		}
	}
	public void viewBooks()
	{
		Repository repository = Repository.getInstance();
		System.out.println("Book Details : ");
		HashMap<Integer, Book> books = repository.getBooks();
		for(Integer i :books.keySet())
		{
			System.out.println("Book ID : "+ books.get(i).getId());
			System.out.println("Book Name : "+ books.get(i).getTitle());
			System.out.println("Author Name : "+ books.get(i).getAuthor());
			System.out.println("Price : " + books.get(i).getPrice());
			System.out.println("ISBN Number : "+ books.get(i).getIsbn());
			System.out.println("       ---------------------         ");
		}
	}
	
	public void editOrAddUsers(String Id)
	{
		
		Scanner scan = LibraryController.getScanner();
		
		System.out.println("Enter name : ");
		String name = scan.nextLine();
		System.out.println("Enter Age : ");
		int age = scan.nextInt();
		if(age > 0 && age > 150)
		{
			System.out.println("Invalid Age...🤦‍♀️!");
			return;
		}
		scan.nextLine();
		System.out.println("Enter phone Number : ");
		String mobileNumber = scan.nextLine();
		System.out.println("Enter Email ");
		String email = scan.nextLine();
		System.out.println("Enter Password : ");
		String emailPassword = scan.nextLine();
		
		Repository repository = Repository.getInstance();
		repository.setUsers(Id, new User(Id, name, age, mobileNumber,email, emailPassword));
		System.out.println("Your User ID : "+(Id));	
	}
}
