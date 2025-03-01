package Task2;

public class VariableScope {

	public static void main(String[] args) {
		
		int outsideVar = 100;  

        if (outsideVar > 50) {
            int insideVar = 200;  
            System.out.println("Inside if block.");
            System.out.println("Outside Variable: " + outsideVar);
            System.out.println("Inside Variable: " + insideVar);
        }

        System.out.println("Outside if block.");
        System.out.println("Outside Variable: " + outsideVar);

        // System.out.println("Inside Variable: " + insideVar);  
        // Compiler Error: Cannot find symbol - insideVar is out of scope here
	}

}
