package task10.employee;

public class Employee {
	private String id;
	private String name;
	private String teamName;
	private String mobileNumber;
	private String email;
	private String password;
	private double salary;
	
	public Employee(String id, String name, String teamName, String mobileNumber, String email, String password,
			double salary) {
		this.id = id;
		this.name = name;
		this.teamName = teamName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.salary = salary;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTeamName() {
		return teamName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void getEmployeeDetails()
	{
		System.out.println(
				"ID : " + this.id + 
				" Name : "+ this.name +
				" Mobile Number : "+ this.mobileNumber +
				" Team Name : " + this.teamName + 
				" Email : " + this.email + 
				" Salary : " + this.salary
				);
	}
	public void getEmployeeDetails(String message)
	{
		System.out.println("Addtional Message : " + message);
	}
}
