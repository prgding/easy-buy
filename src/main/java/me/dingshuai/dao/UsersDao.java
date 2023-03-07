package me.dingshuai.dao;

import me.dingshuai.pojo.Users;

import java.util.List;

public interface UsersDao {
	// 添加 Users 数据
	int addUser(Users user);

	// 根据 id 删除 Users 数据
	int deleteById(int id);

	// 更新 Users 数据
	int update(Users users);

	// 查询所有 Users 数据
	List<Users> findAll();

	Users findByUserNameAndPassWord(String userName, String passWord);

	// 根据 id 查询 Users 数据
	Users checkIfExists(String userName);

	Users findById(String userId);

}
