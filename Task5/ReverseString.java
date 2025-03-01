package Task5;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter sentence : ");
		String string = scan.nextLine();
		
		String ans = "";
		for(int i = string.length()-1; i >= 0; i--)
		{
			ans += string.charAt(i);
		}
		System.out.println("Revered String is : "+ ans);
		scan.close();
	}
}
