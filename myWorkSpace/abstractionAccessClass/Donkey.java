package myWorkSpace.abstractionAccessClass;

import myWorkSpace.abstractionSample.Animal;

public class Donkey extends Animal{

	public Donkey(String name) {
		super(name);
	}

	@Override
	protected void makeSound() {
		System.out.println("Donkey makes bad sound.");
	}

	@Override
	protected void sleep() {
		System.out.println("Donkey is sleeping");
	}

	@Override
	protected String getAnimalName() {
		return super.name;
	}

}
