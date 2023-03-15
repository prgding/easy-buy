package me.dingshuai.service;

import me.dingshuai.pojo.User;

public interface AccountService {
	User Login(String username, String password);

	int CheckIfExists(String username);

	void Register(String username, String password);

}
