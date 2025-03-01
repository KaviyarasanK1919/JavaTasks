package Task5;

import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter sentence : ");
		String string = scan.nextLine();
		
		string += " ";
		String result = "";
		String temp = "";
		
		for(int i = 0; i < string.length(); i++)
		{
			if(string.charAt(i) == ' ')
			{
				
				for(int j = temp.length()-1; j >= 0; j--)
				{
					result += temp.charAt(j);
				}
				result += " ";
				temp = "";
				/*
				 * result = temp +" " + result;
				   temp = "";
				 */
			}
			else
			{
				temp += string.charAt(i);
			}
		}
		System.out.println(result);
		scan.close();
	}

}
