package Task3;

import java.util.Scanner;

public class Multiplicationtable {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number:  ");
        int number = scan.nextInt();

        System.out.println("Multiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i +" x "+ number + " = "+ number * i);
        }

        scan.close();
	}

}
