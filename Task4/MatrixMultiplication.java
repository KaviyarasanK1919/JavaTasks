package Task4;

import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter number of rows of first matrix: ");
	        int rows1 = scanner.nextInt();
	        System.out.print("Enter number of columns of first matrix: ");
	        int cols1 = scanner.nextInt();

	        int[][] matrix1 = new int[rows1][cols1];
	        int[][] matrix2 = new int[rows1][cols1];
	        int[][] product = new int[rows1][cols1];

	        System.out.println("Enter elements of first matrix:");
	        for (int i = 0; i < rows1; i++) {
	            for (int j = 0; j < cols1; j++) {
	                matrix1[i][j] = scanner.nextInt();
	            }
	        }

	        System.out.println("Enter elements of second matrix:");
	        for (int i = 0; i < rows1; i++) {
	            for (int j = 0; j < cols1; j++) {
	                matrix2[i][j] = scanner.nextInt();
	            }
	        }
	        
	        for (int i = 0; i < rows1; i++) {
	            for (int j = 0; j < cols1; j++) {
	                product[i][j] = 0;
	                for (int k = 0; k < cols1; k++) {
	                    product[i][j] += matrix1[i][k] * matrix2[k][j];
	                }
	            }
	        }

	        System.out.println("Product of the matrices:");
	        for (int i = 0; i < rows1; i++) {
	            for (int j = 0; j < cols1; j++) {
	                System.out.print(product[i][j] + " ");
	            }
	            System.out.println();
	        }

	        scanner.close();
	}

}
