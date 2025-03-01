package Task4;

import java.util.Scanner;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Matrix row : ");
		int n = scan.nextInt();
		
		int arr[][] = new int [n][n];
		int count = 0;
		for(int layer = 0; layer < (n+1)/2; layer++) {
			for(int ptr = layer; ptr< n - layer; ptr++) {
				arr[layer][ptr] = ++count;
			}
			for(int ptr =layer + 1; ptr < n - layer; ptr++) {
				arr[ptr][n - layer - 1] = ++count;
			}
			for(int ptr = layer + 1; ptr < n - layer ; ptr++) {
				arr[n - layer - 1][n - ptr -1] = ++count;
			}
			for(int ptr = layer+ 1; ptr < n - layer -1; ptr++) {
				arr[n - ptr - 1][layer] = ++count;
			}
		}
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		scan.close();
	}

}
