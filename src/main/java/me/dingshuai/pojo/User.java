package me.dingshuai.pojo;

public class User {
	// 定义属性
	private int userId;
	private String userName;
	private String passWord;
	private String location;
	private String phoneNumber;

	// 提供无参构造方法
	public User() {
	}

	// 提供带参构造方法
	public User(int userId, String userName, String passWord, String location, String phoneNumber) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.location = location;
		this.phoneNumber = phoneNumber;
	}


	// 提供 getter 和 setter 方法

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", passWord='" + passWord + '\'' +
				", location='" + location + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				'}';
	}
}
