package listinterfacetask;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class LinkedListAssignment {
	public static void main(String args[]) {
		
		System.out.println("------------------           Linked List  ---------------------");
		LinkedList<Integer> numbers = new LinkedList<>();
		numbers.add(5);numbers.add(10);numbers.add(15);numbers.add(20);numbers.add(25);
		System.out.println("Print First Element :- " + numbers.get(0));
		System.out.println("Print Last Element :- " + numbers.get(numbers.size()-1)+"\n");
		
		
		List<String> numberLetters = new LinkedList<>();
		numberLetters.add("one");numberLetters.add("two");numberLetters.add("three");numberLetters.add("four");numberLetters.add("five");numberLetters.add("three");
		System.out.println("Before changing the n : \n" + numberLetters);
		modifyElementToUpperCase(numberLetters);
		System.out.println("After changing the n : \n" + numberLetters);
		
		removeFunction();
		removeQueueElement();
		reverseList();
	}

	private static void modifyElementToUpperCase(List<String> numberLetters) {
		ListIterator<String> iterator = numberLetters.listIterator();
		while(iterator.hasNext())
		{
			if(iterator.next().equals("three"))
			{
				iterator.set("THREE");
			}
		}
	}
	
	public static void removeFunction()
	{
		LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("\nOriginal List: " + numbers);

        numbers.remove(2);

        numbers.removeLast();

        System.out.println("Modified List: " + numbers);
	}
	
	public static void removeQueueElement()
	{
		Queue<String> queue = new LinkedList<>();

        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");
        queue.add("Diana");

        System.out.println("\nInitial Queue: " + queue);

        queue.poll();
        queue.poll();
        
        System.out.println("Queue after removing two names: " + queue);
	}
	
	public static void reverseList() {
		LinkedList<Character> characters = new LinkedList<>();
        characters.add('A');
        characters.add('B');
        characters.add('C');
        characters.add('D');
        characters.add('E');

        System.out.println("\nOriginal List: " + characters);

        Collections.reverse(characters);

        System.out.println("Reversed List: " + characters);
        
    }
}
