package Task4;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter length of the array : ");
		int length = scan.nextInt();
		System.out.println("Enter Elements : ");
		int nums[] = new int [length];
		for(int i = 0; i < length; i++)
		{
			nums[i] = scan.nextInt();
		}
		System.out.println("Enter number of Rorate : ");
		int k = scan.nextInt();
		int ans[] = new int[nums.length];
        k = k % ans.length;
        int ind = nums.length - k;
        int index = 0;
        for(int i= ind;i< nums.length; i++)
        {
            ans[index++] = nums[i];
        }
        for(int i = 0; i < ind; i++){
            ans[index++] = nums[i];
        }
        System.out.println(Arrays.toString(ans));
        scan.close();
	}

}
