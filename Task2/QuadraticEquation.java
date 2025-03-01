package Task2;

import java.util.Scanner;

public class QuadraticEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);// a = 5 b = 6 c= 1
		System.out.println("Enter Value1 : ");
		int a = scan.nextInt();
		System.out.println("Enter Value2 : ");
		int b = scan.nextInt();
		System.out.println("Enter Value3 : ");
		int c = scan.nextInt();
		int bSquare = b * b;
		b = -b;
		int fourAc = 4 * a * c;
		int inRoot = bSquare - fourAc; // x = -b +- squareroot(b^2 - 4ac) / 2a
		int twoA = 2 * a;
		
		System.out.println((b+Math.sqrt(inRoot))/ twoA);
		System.out.println((b-Math.sqrt(inRoot))/ twoA);
		scan.close();
	}

}
