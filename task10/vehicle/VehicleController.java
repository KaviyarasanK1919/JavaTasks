package task10.vehicle;

class Vehicle
{
	public void start()
	{
		System.out.println("Vehicle is starting....");
	}
	public void stop()
	{
		System.out.println("Vehicle is stopping...");
	}
}
class Car extends Vehicle
{
	@Override
	public void start()
	{
		System.out.println("Car is starting....");
	}
	@Override
	public void stop()
	{
		System.out.println("Car is stopping...");
	}
}

class Bike extends Vehicle
{
	@Override
	public void start()
	{
		System.out.println("Bike is starting....");
	}
	@Override
	public void stop()
	{
		System.out.println("Bike is stopping...");
	}
}


public class VehicleController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
