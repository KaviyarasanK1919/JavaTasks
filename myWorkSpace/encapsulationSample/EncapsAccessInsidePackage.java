package myWorkSpace.encapsulationSample;

public class EncapsAccessInsidePackage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User("kavi", 10);
		
		//System.out.println(user.age); // when i use default access specifier in user class attributes i can directly invoke user class fields.
		//System.out.println(user.name); // when i use default access specifier in user class attributes i can directly invoke user class fields.
		
		System.out.println(user.getName());
		System.out.println(user.getAge());
	}

}
