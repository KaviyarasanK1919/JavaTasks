package myWorkSpace.abstractionAccessClass;

import myWorkSpace.abstractionSample.Monkey;

public class AbstractionAccessMainClass {

	public static void main(String[] args) {
		
		Monkey monkey = new Monkey("Jimmy");
		System.out.println(monkey.getAnimalName());
		
		Donkey donkey = new Donkey("lexmi");
		System.out.println(donkey.getAnimalName());
		
		monkey.commonThings();
	}

}
