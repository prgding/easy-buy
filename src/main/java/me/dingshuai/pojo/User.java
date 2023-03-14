package me.dingshuai.pojo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
import org.springframework.stereotype.Component;

@Component
public class User implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
//		System.out.println("绑定");
		ServletContext application = event.getSession().getServletContext();
		Integer loggedInUser = (Integer)application.getAttribute("loggedInUser");
		if(loggedInUser == null) {
			application.setAttribute("loggedInUser", 1);
		}else {
			application.setAttribute("loggedInUser", loggedInUser + 1);
		}
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
//		System.out.println("解绑");
		ServletContext application = event.getSession().getServletContext();
		Integer loggedInUser = (Integer)application.getAttribute("loggedInUser");
		application.setAttribute("loggedInUser", loggedInUser - 1);
	}

	// 定义属性
	private int userId;
	private String userName;
	private String passWord;
	private String location;
	private String phoneNumber;

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

	// 提供无参构造方法
	public User() {
	}


	// 提供带参构造方法
	public User(String userName, String passWord) {
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
