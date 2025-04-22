package myWorkSpace.abstractionSample;

public abstract class Animal {
	
	protected abstract void makeSound();
	protected abstract void sleep();
	protected abstract String getAnimalName();
	
	public void commonThings() 
	{
		System.out.println("this animal has Eye and nose.");
	}
	
	protected String name;
	protected Animal(String name)
	{
		this.name = name;
	}
	
}
