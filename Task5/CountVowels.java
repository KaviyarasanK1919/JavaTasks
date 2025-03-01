package Task5;

import java.util.Scanner;

public class CountVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter sentence : ");
		String string = scan.nextLine();
		int count = 0;
		for(char ch : string.toCharArray())
		{
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
			{
				count++;
			}
		}
		System.out.println("Total number of Vowels : " + count);
		scan.close();
	}

}
