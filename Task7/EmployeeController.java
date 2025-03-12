package Task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Task6ClassAndObject.Employee;

public class EmployeeController {

	static int employeeID = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		while(run)
		{
			System.out.println("1.Add Employee.");
			System.out.println("2.Show All Employees.");
			System.out.println("3.Exit");
			
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice)
			{
			case 1:
				
				System.out.println("        ------         Enter Employee Details        ------");
				System.out.println("Enter Name : ");
				String name = scan.nextLine();
				System.out.println("Enter Department : ");
				String deptName = scan.nextLine();
				System.out.println("Enter Salary : ");
				double salary = scan.nextDouble();
				scan.nextLine();
				System.out.println("Enter Email : ");
				String email = scan.nextLine();
				System.out.println("Enter MobileNumber : ");
				String mobileNumber = scan.nextLine();
				
				employeeList.add(new Employee(employeeID++ +"", name, deptName, salary, email, mobileNumber));
				
				break;
				
			case 2:
				for(Employee i : employeeList)
				{
					System.out.println(i);
				}
				break;
				
			case 3:
				run = false;
				break;
				
			default :
				System.out.println("Please Enter valid option.");
				break;
			}
		}
		scan.close();
	}

}
