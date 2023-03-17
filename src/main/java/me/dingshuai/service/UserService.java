package me.dingshuai.service;

import me.dingshuai.pojo.User;

import java.util.List;

public interface UserService {
	int Register(User user);

	int deleteUser(int userId);

	int modifyUserInfo(User user);

	User login(String username, String password);

	User checkIfExists(String username);

	User showOneUser(int userId);

	List<User> showUsersForAdmin();
}
