package Task1;

import java.util.Scanner;

public class TypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter float value : "); // change float value to integer
		float floatNumber = scan.nextFloat();
		System.out.println("Float to Int value is : "+ (int)floatNumber);
		
		System.out.println("Enter double Value : ");
		double doubleNumber = scan.nextDouble();
		System.out.println("Double to float value is : "+(float)doubleNumber);
		
		System.out.println("Enter integer value : ");
		int intNumber = scan.nextInt();
		System.out.println("integer to short value is : "+ (short)intNumber);
		
		scan.close();
	}

}
