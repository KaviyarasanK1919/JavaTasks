package task10.employee;

public class EmployeeController {

	public static void main(String[] args) {
		
		Employee salariedEmployee = new SalariedEmployee("Z-S-1900", "kavi", "Arattai", "936123****", "kavi@gmail.com", "Kavi193e!#r", 100000, "Honorable Employee");
		
		Employee hourlyEmployee = new HourlyEmployee("Zk-e-134", "vishwa", "SalesIQ", "987654****", "vishwa@gmail.com", "Visj123@@!", 345600, 10);
		
		salariedEmployee.getEmployeeDetails();
		hourlyEmployee.getEmployeeDetails();
	}
}
