package me.dingshuai.pojo;

public class Tusers {
	// 定义属性
	private int userId;
	private String userName;
	private String passWord;
	private String location;
	private String phoneNumber;

	// 提供无参构造方法
	public Tusers() {
	}

	// 提供带参构造方法
	public Tusers(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
		this.location = "";
		this.phoneNumber = "";
	}

	// 提供 getter 和 setter 方法
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPassword(String passWord) {
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
}
