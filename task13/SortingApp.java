package task13;


import java.util.Scanner;

interface Sortable
{
	void sort(int arr[]);
}

class BubbleSort implements Sortable
{
	public static final int BUBBLE_SORT_ID = 3;
	public void sort(int arr[])
	{
		bubbleSort(arr);
	}

	private void bubbleSort(int arr[]) {
		for(int i = 0; i < arr.length - 1; i++)
		{
			for(int j = 0; j < arr.length-1-i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
		}
	}
}

class MergeSort implements Sortable
{
	public static final int MERGE_SORT_ID = 2;
	
	public void sort(int arr[])
	{
		mergeSort(arr, 0, arr.length-1);
	}

	private void mergeSort(int[] arr, int left, int right) {
		
		if(left >= right)
		{
			return;
		}
		
		int mid = left + (right - left) / 2;
		
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		
		int leftStart = left;
		int rightStart = mid + 1;
		
		int A [] = new int [mid - left + 1];
		int B [] = new int [right - mid];
		
		for(int i = 0;  i < A.length; i++)
		{
			A[i] = arr[leftStart + i];
		}
		for(int i = 0; i < B.length; i++)
		{
			B[i] = arr[rightStart + i];
		}
		
		int ind = left;
		int p1 = 0;int p2 = 0;
		while(p1 < A.length && p2 < B.length)
		{
			if(A[p1] <= B[p2])
			{
				arr[ind++] = A[p1++];
			}
			else
			{
				arr[ind++] = B[p2++];
			}
		}
		while(p1 < A.length)
		{
			arr[ind++] = A[p1++];
		}
		while(p2 < B.length)
		{
			arr[ind++] = B[p2++];
		}
	}
}

class QuickSort implements Sortable
{
	public static final int QUICK_SORT_ID = 1;
	public void sort(int arr[])
	{
		quickSort(arr, 0, arr.length-1);
	}

	private void quickSort(int[] arr, int low, int high) {
		if(low < high)
		{
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		
		for(int j = low; j < high; j++)
		{
			if(arr[j] <= pivot)
			{
				i++;
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		int t = arr[i + 1];
		arr[i+1] = arr[high];
		arr[high] = t;
		return i + 1;
	}
}


public class SortingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Length of the Array : ");
		try
		{
			int length = scan.nextInt();
			
			int arr[] = new int [length];
			System.out.println("Enter Array Elements : ");
			
			for(int i = 0; i < length; i++)
			{
				System.out.println("Enter "+ (i + 1) + " Element.");
				arr[i] = scan.nextInt();
			}
			
			System.out.println("Before sorting : ");
			for(int i = 0; i < arr.length; i++)
			{
				System.out.print(arr[i] + " ");
			}
			
			
			System.out.println("Enter an option : \n1.Quick Sort \n2.Merge Sort \n3.BubbleSort");
			int choice = scan.nextInt();
			
			Sortable sort;
			
			switch(choice)
			{
			case QuickSort.QUICK_SORT_ID:
				sort = new QuickSort();
				break; 
				
			case MergeSort.MERGE_SORT_ID:
				sort = new MergeSort();
				break;
				
			case BubbleSort.BUBBLE_SORT_ID:
				sort = new BubbleSort();
				break;
				
			default :
				System.out.println("Please Select valid option.");
				scan.close();
				return;
			}
			
			
			sort.sort(arr);
			System.out.println("After sorting : ");
			for(int i = 0; i < arr.length; i++)
			{
				System.out.print(arr[i] + " ");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		scan.close();
	}

}
