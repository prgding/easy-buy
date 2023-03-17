package me.dingshuai.mapper;

import me.dingshuai.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	// 添加 User 数据
	int insert(User user);

	// 根据 id 删除 User 数据
	int deleteById(int userId);

	// 更新 User 数据
	// update 不能 ById, 因为容易全部赋值 id
	int update(User user);

	// 检测用户名重复
	User findOneByName(String username);

	User findOneById(int userId);

	// 用户名和密码比对
	User findOneByNameAndPwd(@Param("userName") String username,@Param("passWord") String password);

	// 查询所有 User 数据
	List<User> findAll();
}
