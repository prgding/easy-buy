package me.dingshuai.pojo;

public class Tusers {
	// 定义属性
	private int userid;
	private String username;
	private String password;
	private String location;
	private String phoneNumber;

	// 提供无参构造方法
	public Tusers() {
	}

	// 提供带参构造方法
	public Tusers(String username, String password) {
		this.username = username;
		this.password = password;
		this.location = "";
		this.phoneNumber = "";
	}

	// 提供 getter 和 setter 方法
	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
