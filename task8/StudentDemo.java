package task8;

class Student
{
	private String name;
	private String mobileNumber;
	private int age;
	private String registerNumber;
	
	public Student(String name, String mobileNumber, int age, String registerNumber)
	{
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.age = age;
		this.registerNumber = registerNumber;
	}
	public void display()
	{
		System.out.println("Name : " + this.name);
		System.out.println("Mobile Number : "+ this.mobileNumber);
		System.out.println("Age : "+ this.age);
		System.out.println("Register Number : "+ this.registerNumber);
		System.out.println("He/She Top Ten in Rank : " + (getIsTopTen() == true ? "YES" : "NO") );
	}
	public boolean getIsTopTen()
	{
		return false;
	}
}
class ZSGSStudent extends Student
{
	private boolean isTopTen;
	public ZSGSStudent(String name, String mobileNumber, int age, String registerNumber, boolean isTopTen)
	{
		super(name, mobileNumber, age, registerNumber);
		this.isTopTen = isTopTen;
	}
	@Override
	public boolean getIsTopTen()
	{
		return isTopTen;
	}
}
public class StudentDemo {

	public static void main(String[] args) {
		
		Student student = new ZSGSStudent("Kavi", "93611232509", 22, "1128679", true);
		student.display();
	}

}
