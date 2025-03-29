package task10.employee;

public class HourlyEmployee extends Employee{
	
	private static final int SALARY_PER_HOUR = 400;
	public HourlyEmployee(String id, String name, String teamName, String mobileNumber, String email, String password,
			double salaryPerHour, int workedHours) {
		super(id, name, teamName, mobileNumber, email, password, SALARY_PER_HOUR * workedHours);
	}
	
	@Override
	public void getEmployeeDetails()
	{
		super.getEmployeeDetails();
		System.out.println("Salary Per Hour : " + SALARY_PER_HOUR);
	}
}
