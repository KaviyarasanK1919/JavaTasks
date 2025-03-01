package Task3;

import java.util.Scanner;

public class StudentGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

        System.out.print("Enter student's score: ");
        int score = scan.nextInt();

        String grade;

        if (score >= 90) {
            grade = "A+";
        } else if (score >= 80) {
            grade = "A";
        } else if (score >= 70) {
            grade = "B+";
        } else if (score >= 60) {
            grade = "B";
        } else if(score >= 40){
            grade = "C";
        }
        else
        {
        	grade = "D";
        }
        System.out.println("The student's grade is: " + grade);
        scan.close();
	}

}
