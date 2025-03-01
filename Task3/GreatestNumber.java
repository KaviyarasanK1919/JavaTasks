package Task3;

import java.util.Scanner;

public class GreatestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter 3 Numbers : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		System.out.println("Greatest Number is : "+ (num1 < num2 ? num2 < num3 ? num3 : num2 : num1 < num3 ? num3 : num1));
		scan.close();
	}

}
