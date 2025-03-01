package Task3;

import java.util.Scanner;

public class PrintPrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number : ");
		int n = scan.nextInt();
		
		boolean visited [] = new boolean [n];
		
		for(int i = 2; i * i < n; i++)
		{
			if(!visited[i])
			{
				for(int j = i * i; j < n; j += i)
				{
					visited[j] = true;
				}
			}
		}
		System.out.println("Prime Numbers are : ");
		for(int i = 2; i < n; i++)
		{
			if(!visited[i])
			{
				System.out.print(i + " ");
				
			}
		}
		scan.close();
	}

}
