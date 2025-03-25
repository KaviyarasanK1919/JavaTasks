package task8.libraryManagementSystem.roles;

import java.util.Scanner;

import Task6ClassAndObject.Book;
import task8.libraryManagementSystem.LibraryController;
import task8.libraryManagementSystem.Repository;

public class Admin extends Person {
	private static int generateAdminID = 1;
	private static int bookID = 5;
	public void showMenu(String userID)
	{
		Scanner scan =  LibraryController.getScanner();
		
		try
		{
			boolean run = true;
			Repository repository = Repository.getInstance();
			while(run)
			{
				System.out.println("1.Add Books \n2.Remove Books \n3.Add Admin \n4.Exit");
				int choice = scan.nextInt();
				scan.nextLine();
				switch(choice)
				{
				case 1:
					System.out.println("Enter Title : ");
					String title = scan.nextLine();
					System.out.println("Enter Author name : ");
					String AuthorName = scan.nextLine();
					System.out.println("Enter Price : ");
					double price = scan.nextDouble();
					scan.nextLine();
					System.out.println("Enter ISBN Number : ");
					String isbnNumber = scan.nextLine();
					
					repository.setBooks(bookID, new Book(bookID++ +"", title, AuthorName, price, isbnNumber));
					
					System.out.println("Book Added Successfully...😎😎");
					break;
					
				case 2:
					System.out.println("Enter Book Id : ");
					int bookId = scan.nextInt();
					
					repository.getBooks().remove(bookId);
					
					System.out.println("Book Removes Successful.");
					break;
					
				case 3:
					
					editOrAddUsers("Admin"+ generateAdminID++);
					break;
					
				case 4:
					run = false;
					System.out.println("Bye... Bye...👋👋");
					break;
					
				default : 
					System.out.println("Please Enter valid choice....😒");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
