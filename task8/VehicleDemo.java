package task8;

class Vehicle
{
	public int tyreCount;
	private double engineCC;
	private String color;
	private String fuelType;
	
	public Vehicle(int tyreCount, double engineCC, String color, String fuelType) {
		this.tyreCount = tyreCount;
		this.engineCC = engineCC;
		this.color = color;
		this.fuelType = fuelType;
	}
	public void displayMainDetails()
	{
		System.out.println("----  Vehicle Type : "+ this.getClass().getSimpleName());
		System.out.println("Tyre Count : " + tyreCount);
		System.out.println("Engine CC : "+ engineCC);
		System.out.println("Color : "+ color);
		System.out.println("Fuel Type : "+ fuelType);
	}
}

class Car extends Vehicle
{
	private boolean isContainsAC;
	public Car(int tyreCount, double engineCC, String color, String fuelType, boolean isContainsAC)
	{
		super(tyreCount, engineCC, color, fuelType);
		this.isContainsAC = isContainsAC;
	}
	public void displayDetails()
	{
		super.displayMainDetails();
		System.out.println("Car Has AC : "+ (isContainsAC ? "YES" : "NO"));
		System.out.println("        -----------------------------              ");
	}
}

class Bike extends Vehicle
{
	private boolean hasPhoneHolder;
	public Bike(int tyreCount, double engineCC, String color, String fuelType, boolean hasPhoneHolder)
	{
		super(tyreCount, engineCC, color, fuelType);
		this.hasPhoneHolder = hasPhoneHolder;
	}
	public void displayDetails()
	{
		super.displayMainDetails();
		System.out.println("Bike Has PhoneHolder : "+ (hasPhoneHolder ? "YES" : "NO"));
		System.out.println("        -----------------------------              ");
	}
}
public class VehicleDemo {

	public static void main(String[] args) {
		
		Car car = new Car(4, 1190,"Black","Petrol",true);
		car.displayDetails();
		
		Bike bike = new Bike(2, 200, "Black", "petrol", true);
		bike.displayDetails();
	}

}
