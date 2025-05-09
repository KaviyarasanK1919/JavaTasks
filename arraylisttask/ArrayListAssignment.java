package arraylisttask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;



public class ArrayListAssignment {

	public static void main(String[] args) {
		
		System.out.println("3rd Fruits : "+getThirdElement()+"\n");
		
		System.out.print("Printing below 30 : ");
		printUnderThirtyElements();
		
		char searchChar = 'E';
		int index = findCharacterIndex( searchChar);
	    System.out.println("Index of '" + searchChar + "': " + index+"\n");
	    
	    sortList();
	    
	    convertArrayListToArrayAndViceVersa();
	}

	private static void convertArrayListToArrayAndViceVersa() {
		ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");

        String[] fruitArray = fruits.toArray(new String[fruits.size()]);

        System.out.println("\nArray:");
        for (String fruit : fruitArray) {
            System.out.println(fruit);
        }

        ArrayList<String> newFruitList = new ArrayList<>(Arrays.asList(fruitArray));

        System.out.println("\nArrayList:");
        for (String fruit : newFruitList) {
            System.out.println(fruit);
        }
	}

	private static void sortList() {
		ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomNum = random.nextInt(100) + 1;
            numbers.add(randomNum);
        }

        System.out.println("Original List: " + numbers);

        Collections.sort(numbers);

        System.out.println("Sorted List (Ascending): " + numbers);
	}

	private static void printUnderThirtyElements() {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(10);numbers.add(20);numbers.add(30);numbers.add(40);numbers.add(50);
		Iterator<Integer> iterator = numbers.iterator();
		
		while(iterator.hasNext())
		{
			int value = iterator.next();
			if(value > 30)
			{
				iterator.remove();
			}
			else
			{
				System.out.print(value+" ");
			}
		}
		System.out.println("\n");
	}

	private static String getThirdElement() 
	{
		ArrayList<String> fruits = new ArrayList<>();
		
		fruits.add("Water Melon");
		fruits.add("Mango");
		fruits.add("Banana");
		fruits.add("Jack Fruit");
		fruits.add("Grapes");
		
		return fruits.get(2);
	}
	public static int findCharacterIndex(char target) 
	{
		
		ArrayList<Character> characters = new ArrayList<>();

        characters.add('A');
        characters.add('B');
        characters.add('C');
        characters.add('D');
        characters.add('E');
        characters.add('F');
        characters.add('G');
        characters.add('H');
        characters.add('I');
        characters.add('J');
        
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i) == target) {
                return i;
            }
        }
        return -1;
	}
	
}
