package myWorkSpace.inheritanceSample;

public class Vehicle {
	String name;
	int year;
	Vehicle(String name, int year){
		this.name = name;
		this.year = year;
	}
	public void sound()
	{
		System.out.println("Turr.....");
	}
	
	/*
	 * why use public sound() method?
	 *  	Suppose inherited class cannot have a sound method at that time 
	 *  	this sound method will be invoked.
	 *  	In this scenario I only preferable access modifier is "public".
	 */
}
