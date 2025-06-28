package model;

public class User {
	private String userID, name, password, place, post, district, countryCode, role;
	private long mobileNumber,  pinCode;
	private int id;
	
	public User(int id, String name, String password)
	{
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public User(int id, String userID, String name, long mobileNumber, String countryCode, String password, String role, String place,
			String postName, long pinCode, String district) {
		super();
		this.id = id;
		this.userID = userID;
		this.name = name;
		this.password = password;
		this.place = place;
		this.district = district;
		this.countryCode = countryCode;
		this.post = postName;
		this.pinCode = pinCode;
		this.role = role;
		this.mobileNumber = mobileNumber;
	}

	public long getPinCode() {
		return pinCode;
	}


	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}


	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}

	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getCounrtyCode() {
		return countryCode;
	}


	public void setCounrtyCode(String counrtyCode) {
		this.countryCode = counrtyCode;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
}
