package Task2;

import java.util.Scanner;

public class BitwiseOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = scan.nextInt();
        System.out.print("Enter second number: ");
        int b = scan.nextInt();
        
        // Bitwise AND
        System.out.println("a & b = " + (a & b));
        
        // Bitwise OR
        System.out.println("a | b = " + (a | b));
        
        // Bitwise XOR
        System.out.println("a ^ b = " + (a ^ b));
        
        // Bitwise NOT
        System.out.println("~a = " + (~a));
        System.out.println("~b = " + (~b));
        
        // Left Shift
        System.out.println("a << 1 = " + (a << 1));
        System.out.println("b << 1 = " + (b << 1));
        
        // Right Shift
        System.out.println("a >> 1 = " + (a >> 1));
        System.out.println("b >> 1 = " + (b >> 1));
        
        scan.close();
    }
}
