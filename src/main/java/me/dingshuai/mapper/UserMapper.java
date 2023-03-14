package me.dingshuai.mapper;

import me.dingshuai.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	// 添加 User 数据
	int addUser(User user);

	// 根据 id 删除 User 数据
	int deleteById(int id);

	// 更新 User 数据
	int update(User user);

	int checkUsernameDuplicate(String userName);

	// 查询所有 User 数据
	List<User> findAll();

	User checkPwd(@Param("userName") String userName, @Param("passWord") String passWord);

	// 根据 id 查询 User 数据
	User checkIfExists(String userName);

	User findById(String userId);

}
