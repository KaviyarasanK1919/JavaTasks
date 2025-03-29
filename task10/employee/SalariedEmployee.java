package task10.employee;

public class SalariedEmployee extends Employee {

	private String message;
	
	public SalariedEmployee(String id, String name, String teamName, String mobileNumber, String email, String password,
			double salary, String message) {
		super(id, name, teamName, mobileNumber, email, password, salary);
		this.message = message;
	}
	
	@Override
	public void getEmployeeDetails()
	{
		if(message != null)
		{
			super.getEmployeeDetails();
			super.getEmployeeDetails(message);
		}
		else
		{
			super.getEmployeeDetails();
		}
	}
}
