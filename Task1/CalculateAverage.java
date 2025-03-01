package Task1;

import java.util.Scanner;

public class CalculateAverage {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double sum = 0;
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Enter Person "+(i+1)+" Weight.");
			sum += scan.nextInt();;
		}
		System.out.println("Average of 10 Weights is : " + sum / 10);
		scan.close();
	}

}
