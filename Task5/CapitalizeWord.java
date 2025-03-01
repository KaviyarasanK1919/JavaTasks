package Task5;

import java.util.Scanner;

public class CapitalizeWord {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter sentence : ");
		String string = scan.nextLine();
		
		String result = "";
		boolean flag = true;
		for(char ch : string.toCharArray())
		{
			if(ch == ' ')
			{
				flag = true;
				result += " ";
			}
			else
			{
				boolean canCap = false;
				if(flag && ch >= 'a' && ch <= 'z')
				{
					canCap = true;
				}
				if(canCap && flag)
				{
					result += Character.toUpperCase(ch);
				}
				else
				{
					result += ch;
				}
				flag = false;
			}
		}
		System.out.println(result);
		scan.close();
	}

}
