package me.dingshuai.service.impl;

import me.dingshuai.mapper.UserMapper;
import me.dingshuai.pojo.User;
import me.dingshuai.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;

	private User user;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int Register(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int deleteUser(int userId) {
		return userMapper.deleteById(userId);
	}

	@Override
	public int modifyUserInfo(User user) {
		return userMapper.update(user);
	}

	@Override
	public User login(String username, String password) {
		System.out.println("1.username = " + username);
		System.out.println("1.password = " + password);
		return userMapper.findOneByNameAndPwd(username, password);
	}

	@Override
	public User checkIfExists(String username) {
		System.out.println("2.username = " + username);
		return userMapper.findOneByName(username);
	}

	@Override
	public User showOneUser(int userId) {
		return userMapper.findOneById(userId);
	}

	@Override
	public List<User> showUsersForAdmin() {
		return userMapper.findAll();
	}
}
