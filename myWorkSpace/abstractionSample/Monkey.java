package myWorkSpace.abstractionSample;

public class Monkey extends Animal{

	public Monkey(String name)
	{
		super(name);
	}
	@Override
	public void makeSound() {
		System.out.println("Monkey makes sound.");
	}

	@Override
	public void sleep() {
		System.out.println("Monkey is sleeping.");
	}
	
	@Override
	public String getAnimalName()
	{
		return super.name;
	}
}
