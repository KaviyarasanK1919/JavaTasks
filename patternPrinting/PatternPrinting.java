package patternPrinting;

public class PatternPrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		rightHalfPyramid(n);
		invertedRightHalfPyramid(n); 
		invertedLeftHalfPyramid(n);
		leftHalfPyramidPattern(n);
		fullPyramid(n);
		invertedFullPyramidPattern(n);
		halfDiamond(n); // right Pascal Triangle
		squareHollowPattern(n);
		rhombusPattern(n);
		diamondStarPattern(n);
		palindromeTrianglePattern(n);
		butterflyStarPattern(n);
		squareFillPattern(n);
		reverseNumberTrianglePattern(n);
		mirrorImageTrianglePattern(n);
		hollowTrianglePattern(n);
		hollowReverseTrianglePattern(n);
		hollowDiamondPyramid(n);
		hollowHourglassPattern(n);
		pascalTriangle(n);
		kPattern(n);
	}

	private static void kPattern(int n) {
		System.out.println("K Pattern : ");
		int printStar = 0;
		for(int i = 0; i < 2 * n - 1; i++)
		{
			if(i < n)
			{
				printStar = n - i;
			}
			else
			{
				printStar = i - n + 2;
			}
			for(int j = 0; j < printStar; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void pascalTriangle(int n) {
		System.out.println("Pascal Triangle : ");
		for(int i = 1;i <= n; i++)
		{
			for(int j = 0;j < n - i; j++)
			{
				System.out.print(" ");
			}
			int value = 1;
			for(int j = 1;j <= i; j++)
			{
				System.out.print(value +" ");
				value = value * (i - j) / j;
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void hollowHourglassPattern(int n) {
		System.out.println("Hollow Hourglass Pattern : ");
		int printSpace = 0;
		int printStar = 0;
		for(int i = 0; i < n * 2 - 1; i++)
		{
			if(i < n)
			{
				printSpace = i;
				printStar = n - i;
			}
			else
			{
				printSpace = 2 * n - i - 2;
				printStar = n - printSpace;
			}
			for(int j = 0; j < printSpace; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j < printStar; j++)
			{
				if(i == 0 || i == n * 2 - 2 || j == 0 || j == printStar - 1)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void hollowDiamondPyramid(int n) {
		System.out.println("Hollow Diamond Pyramid : ");
		int printSpace = 0;
		int printStar = 0;
		for(int i = 0; i < n * 2 - 1; i++)
		{
			if(i < n)
			{
				printSpace = n - i;
				printStar = 2 * i + 1;
			}
			else
			{
				printSpace = i - n + 2;
				printStar = (2 * n) - (2 * i) + 2 + n;
			}
			for(int j = 0;j < printSpace; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0;j < printStar; j++)
			{
				if(j == 0 || j == printStar - 1)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void hollowReverseTrianglePattern(int n) {
		System.out.println("Hollow Reverse Triangle Pattern : ");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < i; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j < 2 * n - 2 * i - 1; j++)
			{
				if(i == 0 || j == 0 || j == 2 * n - 2 * i - 2)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void hollowTrianglePattern(int n) {
		System.out.println("Hollow Triangle Pattern : ");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n - i; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j <=  2 * i; j++)
			{
				if(i == 0 || i == n - 1 || j == 0 || j == 2 * i)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void mirrorImageTrianglePattern(int n) {
		System.out.println("Mirror Image Triangle Pattern : ");
		int printSpace = 0;
		int printStar = 0;
		int value = 0;
		for(int i = 0; i < n * 2 - 1; i++)
		{
			if(i < n)
			{
				printSpace = i;
				printStar = n - i;
				value = i + 1;
			}
			else
			{
				printSpace = 2 * n - i - 2;
				printStar = n - printSpace;
				value = printSpace + 1;
			}
			for(int j = 0; j < printSpace; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j < printStar; j++)
			{
				System.out.print(value++ + " ");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void reverseNumberTrianglePattern(int n) {
		System.out.println("Reverse number Triangle Pattern : ");
		for(int i = 0; i < n; i++)	
		{
			for(int j = 0; j < i; j++)
			{
				System.out.print(" ");
			}
			int value =  i + 1;
			for(int j = 0; j < n - i; j++)
			{
				System.out.print(value++ + " ");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void squareFillPattern(int n) {
		System.out.println("Square Fill Pattern : ");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void butterflyStarPattern(int n) {
		System.out.println("Butterfly Star Pattern : ");
		for(int i = 1; i <= n * 2; i++)
		{
			if(i <= n)
			{
				for(int j = 1; j <= (n * 2); j++)
				{
					if(j <= i || Math.abs(j - (2 * n)) < i)
					{
						System.out.print("*");
					}
					else
					{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			else
			{
				for(int j = 1; j <= n * 2; j++)
				{
					if(n * 2 - i + 1 >= j || j >= i)
					{
						System.out.print("*");
					}
					else
					{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		System.out.println("\n         --------------------");
	}

	private static void palindromeTrianglePattern(int n) {
		System.out.println("Palindrome Triangle Pattern : ");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n - i; j++)
			{
				System.out.print("  ");
			}
			boolean flag = true;
			int value = i + 1;
			for(int j = 0; j < (2 * i) + 1; j++)
			{
				if(flag)
				{
					System.out.print(value-- + " ");
					if(value == 0)
					{
						flag = false;
						value++;
					}
				}
				else
				{
					System.out.print(++value + " ");
				}
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void diamondStarPattern(int n) {
		System.out.println("Diamond Star Pattern : ");
		int printSpace = 0;
		int printStar = 0;
		for(int i = 0; i < n * 2 - 1; i++)
		{
			if(i < n)
			{
				printSpace = n - i;
				printStar = 2 * i + 1;
			}
			else
			{
				printSpace = i - n + 2;
				printStar = (2 * n) - (2 * i) + 2 + n;
			}
			for(int j = 0;j < printSpace; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0;j < printStar; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void rhombusPattern(int n) {
		System.out.println("Rhombus Pattern : \n");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j <= n - i; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j < n; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void squareHollowPattern(int n) {
		System.out.println("Square Hollow Pattern : \n");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i == 0 || i == n - 1 || j == 0 || j == n - 1)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void halfDiamond(int n) {
		System.out.println("Half Diamond  : \n");
		int printStar = 0;
		for(int i = 0; i < 2 * n - 1; i++)
		{
			if(i < n)
			{
				printStar = i + 1;
			}
			else
			{
				printStar = n - (i - n) - 1;
			}
			for(int j = 0; j < printStar; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void invertedFullPyramidPattern(int n) {
		System.out.println("Inverted Full Pyramid Pattern : \n");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0;j < i; j++)
			{
				System.out.print("  ");
			}
			for(int j = 0; j < 2 * n - (2 * i) - 1; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void fullPyramid(int n) {
		System.out.println("Full Pyramid : \n");
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n - i; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j <= i; j++)
			{
				System.out.print(i + 1+" ");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void leftHalfPyramidPattern(int n) {
		System.out.println("Left Half Pyramid Pattern : \n");
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= n - i; j++)
			{
				System.out.print("  ");
			}
			for(int j = 1; j <= i; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------");
	}

	private static void invertedLeftHalfPyramid(int n) {
		System.out.println("Inverted Left Half Pyramid : \n");
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0;j < i; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j < n - i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------           ");
	}

	private static void invertedRightHalfPyramid(int n) {
		System.out.println("Inverted Right Half Pyramid  : \n");
		
		for(int i = n; i >= 1; i--)
		{
			for(int j = 0; j < i; j++)
			{
				System.out.print(j+1+" ");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------           ");
	}

	private static void rightHalfPyramid(int n) {
		System.out.println("Right Half Pyramid : \n");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0;j <= i; j++)
			{
				System.out.print(j+1+" ");
			}
			System.out.println();
		}
		System.out.println("\n         --------------------           ");
	}
	
	
}
