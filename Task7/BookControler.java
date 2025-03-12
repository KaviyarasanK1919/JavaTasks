package Task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Task6ClassAndObject.Book;

public class BookControler {
	static int bookID = 1;
	public static void main(String[] args) {
		
		List<Book> bookList = new ArrayList<>();
		
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		while(run)
		{
			System.out.println("1.Add Book");
			System.out.println("2.Show All Books");
			System.out.println("3.Exit");
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Book Title :" );
				String title = scan.nextLine();
				System.out.println("Enter Author Name : ");
				String authorName = scan.nextLine();
				System.out.println("Enter Book price : ");
				double price = scan.nextDouble();
				scan.nextLine();
				System.out.println("Enter ISBN Number : ");
				String isbn = scan.nextLine();
				
				bookList.add(new Book(bookID++ +"", title, authorName, price, isbn));
				break;
				
			case 2:
				for(Book i : bookList)
				{
					System.out.println(i);
				}
				break;
				
			case 3 : 
				run = false;
				break;
				
			default :
				System.out.println("Please");
			}
		}
		scan.close();
	}

}
