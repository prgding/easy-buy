package me.dingshuai.dao;

import me.dingshuai.pojo.Tusers;

import java.util.List;

public interface TusersDao {
	// 添加 Tusers 数据
	int addUser(Tusers tuser);

	// 根据 id 删除 Tusers 数据
	int deleteById(int id);

	// 更新 Tusers 数据
	int update(Tusers tusers);

	// 查询所有 Tusers 数据
	List<Tusers> findAll();

	Tusers findByUserNameAndPassWord(String userName, String passWord);

	// 根据 id 查询 Tusers 数据
	Tusers checkIfExists(String userName);

	Tusers findById(String userId);

}
