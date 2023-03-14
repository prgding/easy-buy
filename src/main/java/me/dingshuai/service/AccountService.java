package me.dingshuai.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.dingshuai.pojo.User;

public interface AccountService {
	User Login(String username, String password);

	int CheckIfExists(String username);

	void Register(String username, String password);

	void Exit(String username, HttpServletRequest request, HttpServletResponse response);
}
