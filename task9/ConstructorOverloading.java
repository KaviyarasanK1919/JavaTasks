package task9;

class Person 
{
	private String name;
	private int age;
	private String address;
	
	public Person(String name)
	{
		this.name = name;
	}
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public Person(String name, int age, String address)
	{
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	
}
public class ConstructorOverloading {

	public static void main(String[] args) {
		
		Person person1 = new Person("kavi");
		System.out.println("Name : "+person1.getName());
		
		Person person2 = new Person("kanna", 23);
		System.out.println("Name : "+ person2.getName() +" ,Age : "+ person2.getAge());
		
		Person person3 = new Person("Vishwa", 16, "Kalaiyar Koil");
		System.out.println("Name : "+ person3.getName() +" ,Age : "+ person3.getAge() +" ,Address : " + person3.getAddress());
	
		
	}
}
