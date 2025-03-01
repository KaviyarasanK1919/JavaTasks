package Task4;

import java.util.Arrays;
import java.util.Scanner;

public class JaggedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows : ");
		int N = sc.nextInt();
		double[][] weightPerson = new double[N][]; 
		int option ;
		do {
			System.out.println("1 .Add weight ");
			System.out.println("2 .Get minimum weight ");
			System.out.print("Enter the option : ");
			option =sc.nextInt();
			switch(option) {
			case 1:
				System.out.print("Enter your row : ");
				int row = sc.nextInt();
				System.out.print("Enter the new weight : ");
				double weight = sc.nextDouble();
				if(row >= N)
						System.out.println("Wrong row");
				else {
					weightPerson[row]=addWeight(weightPerson[row],weight);
					System.out.println("New Weights added successfully : "+Arrays.toString(weightPerson[row]));
				}
				break;
			case 2:
				System.out.print("Enter your row : ");
				int rowIdx = sc.nextInt();
				System.out.println("Minimum weight of person : " + getMinimumWeight(weightPerson[rowIdx]));
				break;
			default:
				System.out.println("Invalid Option");
			}
		}while(option==1||option==2);
		sc.close();
	}
	private static double getMinimumWeight(double[] personWeights) {
		if (personWeights.length > 0) {
            double min = personWeights[0];
            for (double weight : personWeights) {
                if (weight < min) {
                    min = weight;
                }
            }
            return min;
        } else {
            System.out.println("No weights available");
            return 0.0;
        }
		
	}

	private static double[] addWeight(double[] personWeights, double weight) {
		double[] newWeights ;
		if(personWeights != null) {
			newWeights = new double[personWeights.length+1];
			for(int i=0;i<personWeights.length;i++)
					newWeights[i]=personWeights[i];
	        newWeights[personWeights.length] = weight;
		}
		else {
			newWeights = new double[1];
			newWeights[0]=weight;
		}
        return newWeights;
	}

}