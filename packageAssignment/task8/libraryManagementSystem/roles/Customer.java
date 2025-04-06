package task8.libraryManagementSystem.roles;

import java.util.List;
import java.util.Scanner;

import task8.libraryManagementSystem.LibraryController;
import task8.libraryManagementSystem.database.Repository;
import task8.libraryManagementSystem.model.Transaction;
import task8.libraryManagementSystem.transaction.LibraryTransaction;

public class Customer extends Person implements LibraryTransaction
{

	public void borrowBook(String user, int book)
	{
		Repository repository = Repository.getInstance();
		repository.setTransaction(user, new Transaction(Repository.transactionID++ , book, true));
		System.out.println("Book buys successfull..👍😎");
	}
	public void returnBook(String user, int book) throws NullPointerException
	{
		Repository repository = Repository.getInstance();
		List<Transaction> list = repository.getTransaction().get(user);
		for(Transaction i : list)
		{
			if(i.getBookID() == book && i.isBookStatus() == true)
			{
				i.setBookStatus(false);
				System.out.println("Book return Successfull...👍👍");
				return;
			}
		}
		System.out.println("No Book found...");
	}
	public void viewTransactions(String user)
	{
		Repository repository = Repository.getInstance();
		List<Transaction> list = repository.getTransaction().get(user);
		
		for(Transaction i : list)
		{
			System.out.println("Book ID : " + repository.getBooks().get(i.getBookID()).getId());
			System.out.println("Book Name : " + repository.getBooks().get(i.getBookID()).getTitle());
			System.out.println("Book Author : " + repository.getBooks().get(i.getBookID()).getAuthor());
			System.out.println("Book Price : " + repository.getBooks().get(i.getBookID()).getPrice());
			System.out.println("Book ISBN : " + repository.getBooks().get(i.getBookID()).getIsbn());
			System.out.println("Book Status : " + (i.isBookStatus() == true ? "Buyed" : "Returned"));
		}
	}
	public void showMenu(String userId)
	{
		Scanner scan = LibraryController.scan;
		
		try
		{
			boolean run = true;
			while(run)
			{
				System.out.println("1.Show All Books \n2.Buy Book \n3.Return Book \n4.View Transaction History \n5.Edit Profile \n6.Exit");
				
				int choice = scan.nextInt();
				switch(choice)
				{
				case 1:
					viewBooks();
					break;
				
				case 2:
					System.out.println("Enter Book ID : ");
					int bookID = scan.nextInt();
					borrowBook(userId, bookID);
					break;
					
				case 3:
					System.out.println("Enter Book ID : ");
					bookID = scan.nextInt();
					returnBook(userId, bookID);
					break;
					
					
				case 4 : 
					viewTransactions(userId);
					break;
					
				case 5:
					editOrAddUsers(userId);
					System.out.println("SuceesFully Edited.");
					break;
					
				case 6:
					run = false;
					System.out.println("Bye... Bye...👋👋");
					break;
					
				default : 
					System.out.println("Please Enter valid choice....😒");
				}
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No Books Found...❌❌");
			System.out.println(e);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
