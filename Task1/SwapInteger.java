package Task1;

import java.util.Scanner;

public class SwapInteger {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number 1 : ");
		int num1 = scan.nextInt();
		System.out.println("Enter Number 2 : ");
		int num2 = scan.nextInt();
		System.out.println("Before Swapping : "+ num1 +" and "+ num2);
		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;
		
		System.out.println("After Swapping : "+ num1 +" and "+ num2);
		scan.close();
	}

}
