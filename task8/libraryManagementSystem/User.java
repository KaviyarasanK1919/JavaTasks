package task8.libraryManagementSystem;

public class User {
	private String userID;
	private String name;
	private int age;
	private String phoneNumber;
	private String email;
	private String password;
	
	public User(String iD, String name, int age, String phoneNumber,String email, String password) {
		this.userID = iD;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", password=" + password + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getID() {
		return userID;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setID(String iD) {
		this.userID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
