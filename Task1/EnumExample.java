package Task1;

import java.util.Scanner;

public class EnumExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a Number 0-7. : ");
		int dayNumber = scan.nextInt();
		switch(dayNumber)
		{
		case 0:
			System.out.println(Day.SUNDAY.getDay());
			break;
		case 1:
			System.out.println(Day.MONDAY.getDay());
			break;
		case 2:
			System.out.println(Day.TUESDAY.getDay());
			break;
		case 3:
			System.out.println(Day.WEDNESDAY.getDay());
			break;
		case 4:
			System.out.println(Day.THURSDAY.getDay());
			break;
		case 5:
			System.out.println(Day.FRIDAY.getDay());
			break;
		case 6:
			System.out.println(Day.SATURDAY.getDay());
			break;
		default :
			System.out.println("Please Enter a number 0-7.");
		}
		scan.close();
	}
	
}
 enum Day
{
	SUNDAY("Today Sunday."),
	MONDAY("Today Monday."),
	TUESDAY("Today Tuesday."),
	WEDNESDAY("Today Wednesday"),
	THURSDAY("Today Thursday."),
	FRIDAY("Today Friday."),
	SATURDAY("Today Saturday.");
	
	private String day;
	
	private Day(final String day)
	{
		this.day = day;
	}
	public String getDay()
	{
		return this.day;
	}
}
