package task9;

class Calculate
{
	public int add(int a , int b)
	{
		return a + b;
	}
	public double add(double a, double b)
	{
		return a + b;
	}
	public float add(float a , float b)
	{
		return a + b;
	}
	
	
	public int subtract(int a , int b)
	{
		return a - b;
	}
	public double subtract(double a, double b)
	{
		return a - b;
	}
	public float subtract(float a , float b)
	{
		return a - b;
	}
	
	
	public int multiply(int a , int b)
	{
		return a * b;
	}
	public double multiply(double a, double b)
	{
		return a * b;
	}
	public float multiply(float a , float b)
	{
		return a * b;
	}
	
	
	public int divide(int a , int b) throws ArithmeticException
	{
		return a / b;
	}
	public double divide(double a, double b) throws ArithmeticException
	{
		return a / b;
	}
	public float divide(float a , float b) throws ArithmeticException
	{
		return a / b;
	}
}


public class MathOperations {
	
	public static void main(String[] args) {
		
		try
		{
			Calculate calculate = new Calculate();
			System.out.println("Addition : ");
			System.out.println("10 + 10 = "+calculate.add(10, 10));
			System.out.println("9.0 + 94 = "+calculate.add(9.0, 94));
			System.out.println("2.0f + 3.90f = "+calculate.add(2.0f, 3.90f));
			
			System.out.println("\nSubtraction : ");
			System.out.println("10 - 10 = "+calculate.subtract(10, 10));
			System.out.println("9.0 - 94 = "+calculate.subtract(9.0, 94));
			System.out.println("2.0f - 3.90f = "+calculate.subtract(2.0f, 3.90f));
			
			System.out.println("\nMultiplication : ");
			System.out.println("10 * 10 = "+calculate.multiply(10, 10));
			System.out.println("9.0 * 94 = "+calculate.multiply(9.0, 94));
			System.out.println("2.0f * 3.90f = "+calculate.multiply(2.0f, 3.90f));
			
			System.out.println("\nDivition : ");
			System.out.println("10 / 10 = "+calculate.divide(10, 10));
			System.out.println("9.0 / 94 = "+calculate.divide(9.0, 94));
			System.out.println("2.0f / 3.90f = "+calculate.divide(0d, 0f));
			
		}
		catch(ArithmeticException e)
		{
			System.out.println("Cannot divide by Zero.");
		}
		
	}
}
