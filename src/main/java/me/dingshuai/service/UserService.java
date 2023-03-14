package me.dingshuai.service;

import org.apache.catalina.User;

import java.util.List;

public interface UserService {
	void update();

	List<User> show();
}
