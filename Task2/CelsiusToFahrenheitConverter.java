package Task2;



public class CelsiusToFahrenheitConverter {

	public static void main(String[] args) {
		
		double celsius = 37.0;

        double FACTOR = 9.0 / 5.0;
        double OFFSET = 32.0;

        double fahrenheit = (celsius * FACTOR) + OFFSET;

        System.out.printf("%.2f Celsius is equal to %.2f Fahrenheit%n", celsius, fahrenheit);
	}

}
	