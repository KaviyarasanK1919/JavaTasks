package task8.libraryManagementSystem.roles;

import java.util.Scanner;

import task8.libraryManagementSystem.LibraryController;

public class Customer extends Person{

	public void showMenu(String userId)
	{
		Scanner scan = LibraryController.getScanner();
		
		try
		{
			boolean run = true;
			while(run)
			{
				System.out.println("1.Show All Books \n2.Edit Profile \n3.Exit");
				
				int choice = scan.nextInt();
				switch(choice)
				{
				case 1:
					viewBooks();
					break;
					
				case 2:
					editOrAddUsers(userId);
					System.out.println("SuceesFully Edited.");
					break;
					
				case 3 :
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
