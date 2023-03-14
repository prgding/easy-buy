package me.dingshuai.service.impl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.dingshuai.mapper.UserMapper;
import me.dingshuai.pojo.User;
import me.dingshuai.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	private final UserMapper userMapper;

	public AccountServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User Login(String username, String password) {
		return userMapper.checkPwd(username, password);
	}

	@Override
	public void Register(String username, String password) {
		User user = new User(username, password);
		userMapper.addUser(user);
	}

	public int CheckIfExists(String username) {
		User user = userMapper.checkIfExists(username);
		if (user != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public void Exit(String username, HttpServletRequest request, HttpServletResponse response) {
		// 销毁会话
		HttpSession session = request.getSession(false);
		session.invalidate();

		// 销毁 cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
		}
	}
}