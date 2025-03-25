package task8.libraryManagementSystem;

import java.util.Scanner;

import Task6ClassAndObject.Book;
import task8.libraryManagementSystem.roles.Customer;
import task8.libraryManagementSystem.roles.Person;

public class LibraryController {
	private static int bookID = 1;
	private static final String ADMIN_ID = "Admin_@#19";// default Admin id for to add Another Admin
	private static final String PASSWORD = "AdmIn!@19*";
	private static long generateUserID = 100;
	
	public static void main(String[] args) {
		
		
		Repository repository = Repository.getInstance();
		
		repository.setUsers(ADMIN_ID, new User( ADMIN_ID,"Default_ID", 0,"", "", PASSWORD));
		
		repository.setBooks(bookID, new Book(bookID++ +"", "Demon Slayer","Kavi", 100, "12345"));
		repository.setBooks(bookID, new Book(bookID++ +"", "Sun Breathing","Tanjiro", 100, "12376545"));
		repository.setBooks(bookID, new Book(bookID++ +"", "Thunder Breathing","Zenitsu", 100, "7646345"));
		repository.setBooks(bookID, new Book(bookID++ +"", "Beast Breathing","Inozuke", 100, "343434"));
		Scanner scan = new Scanner(System.in);
		
		try
		{
			boolean run = true;
			
			while(run)
			{
				System.out.println("1.Login \n2.Register \n3.Exit");
				
				int choice = scan.nextInt();
				scan.nextLine();
				switch(choice)
				{
				case 1 :
				System.out.println("Enter User ID : ");
				String userID = scan.nextLine();
				System.out.println("Enter Password : ");
				String password = scan.nextLine();
				
				if(!repository.getUsers().containsKey(userID))
				{
					System.out.println("Invalid UserID or Password...🤦‍♀️!");
					return;
				}
				if(!repository.getUsers().get(userID+"").getPassword().equals(password))
				{
					System.out.println("Invalid UserID or Password...!");
					return;
				}
				System.out.println("Welcome to Library Management.(❁´◡`❁)");
					
				Person person = Person.getAuthorization(userID);
				
				person.showMenu(userID+"");
						
				break;
						
				case 2 :
					Person customer = new Customer();
					customer.editOrAddUsers("User" + generateUserID++);
					break;
				case 3:
					run = false;
					System.out.println("Thankyou for Visiting..😊🚀");
					break;
						
				default :
					System.out.println("Please Enter valid Choice...!😒😒");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Hii");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				scan.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static Scanner getScanner()
	{
		return new Scanner(System.in);
	}
}
