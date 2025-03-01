package Task1;

class Car
{
	void callClass()
	{
		System.out.println("I am Car Class.");
	}
}

class Dog
{
	void callClass()
	{
		System.out.println("I am Dog Class.");
	}
}

class Peacock
{
	void callClass()
	{
		System.out.println("I am Peacock Class.\n");
	}
}

public class ClassFileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.callClass();
		
		Dog dog = new Dog();
		dog.callClass();
		
		Peacock peacock = new Peacock();
		peacock.callClass();
		
		System.out.println("Totally I am Created Class Count : " + 3);
		
	}

}
