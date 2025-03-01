package Task5;

import java.util.Scanner;

public class ValidEmailCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter mail : ");
		String string = scan.nextLine();
		scan.close();
		if(string.length() < 7)
		{
			System.out.println("Invalid");
			return;
		}
		if(string.charAt(0) == '@'|| string.charAt(0) == '.')
		{
			System.out.println("Invalid");
			return;
		}
		if(!string.endsWith(".com"))
		{
			System.out.println("Invalid");
			return;
		}
		System.out.println("Valid");
		
	}

}
