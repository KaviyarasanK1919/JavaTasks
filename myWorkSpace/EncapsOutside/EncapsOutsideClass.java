package myWorkSpace.EncapsOutside;

import myWorkSpace.encapsulationSample.User;

public class EncapsOutsideClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User("kanna", 13); // when I set user class constructor as a default i can't create object at this time.
											// because default access specifier only accessible within a package
		System.out.println(user.getAge());
		//System.out.println(user.age); i can't directly invoke age because age is secured by default (or) private access modifier.
	}

}
