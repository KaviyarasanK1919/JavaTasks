package task12;

import java.util.Scanner;

abstract class Employee
{
	private String name;
	private String id;
	private String mobileNumber;
	private String email;
	private String password;

	public Employee(String name, String id, String mobileNumber, String email, String password) {
		this.name = name;
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}

	abstract void calculateSalary();
	
	public void displayDetails()
	{
		System.out.println(
				"ID : "+ id +
				"\nName : " + name +
				"\nMobile Number : " + mobileNumber +
				"\nEmail : "+ email + 
				"\nPassword : " + password
				);
	}
	
}


class SalariedEmployee extends Employee
{
	private double salary;
	public SalariedEmployee(String name, String id,String mobileNumber,String  email,String  password , double salary) 
	{
        super(id, name, mobileNumber, email, password);
        this.salary = salary;
	}
	@Override
	public void calculateSalary()
	{
		System.out.println("Salary : " + salary);
	}
}

class HourlyEmployee extends Employee
{
	private double salary ;
    public HourlyEmployee(String name, String id,String mobileNumber,String  email,String  password ,double salary) {
        super(id, name, mobileNumber, email, password);
        this.salary = salary;
    }
	@Override
	public void calculateSalary()
	{
		System.out.println("Salary : "+ salary);
	}
}



public class EmployeeManagementSystem {

	private static final String HOURLY_EMP_ID = "HRE-ZS-";
	private static final String SALARIED_EMP = "SLE-ZS-";
	
	private static int id = 100;
	private static final double HOURLY_RATE = 1500; 
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee Type\n 1: Hourly\n 2: Salaried: ");
		int choice = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter name : ");
		String name = scan.nextLine();
		
		System.out.println("Enter Mobile Number : ");
		String mobileNumber = scan.nextLine();
		
		System.out.println("Enter Email : ");
		String email = scan.nextLine();
		
		System.out.println("Enter Password : ");
		String password = scan.nextLine();
		
		
		Employee employee;
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter Working Hours : ");
			int hours = scan.nextInt();
			
			employee = new HourlyEmployee(HOURLY_EMP_ID + id++ , name, mobileNumber, email, password, HOURLY_RATE * hours);
			
			break;
			
		case 2:
			System.out.println("Enter Salary : ");
			double salary = scan.nextDouble();
			
			employee = new SalariedEmployee(SALARIED_EMP + id++, name, mobileNumber, email, password,  salary);
			break;
			
		default :
			System.out.println("Invalid choice....🚀🚀🤦‍♀️🤦‍♀️");
			scan.close();
			return;
		}
		
		employee.displayDetails();
		employee.calculateSalary();
		
		scan.close();
	}
}
