package Task3;

import java.util.Scanner;

public class SumEvenNumbers {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter length of the array : ");
		int length = scan.nextInt();
		System.out.println("Enter Elements : ");
		int arr[] = new int [length];
		for(int i = 0; i < length; i++)
		{
			arr[i] = scan.nextInt();
		}
		long sum = 0;
		for(int i = 0; i < length; i++)
		{
			if(arr[i] % 2 == 1)
			{
				continue;
			}
			sum += arr[i];
		}
		System.out.println("Sum of the even Numbers : "+ sum);
		scan.close();
	}

}
