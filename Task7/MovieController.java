package Task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Task6ClassAndObject.Movie;

public class MovieController {
	static int movieID = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Movie> moviesList = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		while(run)
		{
			System.out.println("1.Add Movie.");
			System.out.println("2.Show All Movies.");
			System.out.println("3.Exit");
			
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("        ------         Enter Movie Details        ------");
				System.out.println("Enter Movie title : ");
				String title = scan.nextLine();
				System.out.println("Enter genre : ");
				String genre = scan.nextLine();
				System.out.println("Enter Director name : ");
				String director = scan.nextLine();
				System.out.println("Enter Release year : ");
				int year = scan.nextInt();
				System.out.println("Enter rating : (1-10)");
				byte rating = scan.nextByte();
				if(!(rating >= 0 && rating <= 10))
				{
					System.out.println("Enter valid rating.");
				}
				System.out.println("Enter BOX_Collection : ");
				double boxCollection = scan.nextDouble();
				
				moviesList.add(new Movie(movieID++ +"", title, genre, director, year, rating, boxCollection));
				System.out.println("Movie Added Successful.");
				break;
				
			case 2:
				for(Movie i : moviesList)
				{
					System.out.println(i);
				}
				break;
				
			case 3:
				run = false;
				break;
				
			default :
				System.out.println("Please enter valid option.");
			}
		}
		scan.close();
	}

}
