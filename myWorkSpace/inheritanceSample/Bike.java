package myWorkSpace.inheritanceSample;

public class Bike  extends Vehicle{
	
	String model;
	protected Bike(String model) // If I change the visibility to default Splendor Bike class can't see it
	{
		super("Bike", 2022);
		this.model = model;
	}
	
	/* why use protected instead of public ?
		I know this constructor will be invokable only within the package and inherited subclasses
	*/
}
