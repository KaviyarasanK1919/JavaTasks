package Task6ClassAndObject;

public class Employee {
	private int employeeId;
    private String name;
    private String department;
    private double salary;
    private String email;
    private String phoneNumber;
    
    private static int totalEmployees = 0;
    
	public Employee(int employeeId, String name, String department, double salary, String email, String phoneNumber) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public double getSalary() {
		return salary;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
	public static int getTotalEmployees() {
	        return totalEmployees;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", department=" + department + ", salary="
				+ salary + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
    
	
}
