package Task3;

import java.util.Scanner;

public class SecondOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Length Of the array : ");
		int length = scan.nextInt();
		
		int array [] = new int [length];
		
		for(int i = 0; i < length; i++)
		{
			array[i] = scan.nextInt();
		}
		
		System.out.print("Enter the number to find its second occurrence: ");
        int target = scan.nextInt();

        int count = 0;
        int index = -1;

        for (int i = 0; i < length; i++) {
            if (array[i] == target) {
                count++;
                if (count == 2) {
                    index = i;
                    break;
                }
            }
        }
        if(index == -1)
        {
        	System.out.println("Not found target"); 
        	scan.close();
        	return;
        }
        System.out.println("Second Occurence of the array is : " + array[index]);
        scan.close();
	}

}
