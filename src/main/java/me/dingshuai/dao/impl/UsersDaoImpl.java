package me.dingshuai.dao.impl;

import me.dingshuai.dao.UsersDao;
import me.dingshuai.pojo.Users;
import me.dingshuai.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UsersDaoImpl implements UsersDao {

	@Override
	public Users findById(String userId) {

		SqlSession sqlSession = SqlSessionUtil.openSession();
		Users user = sqlSession.selectOne("user.findById", userId);
		sqlSession.close();
		return user;
	}

	@Override
	public List<Users> findAll() {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		List<Users> list = sqlSession.selectList("user.findAll");
		sqlSession.close();
		return list;
	}

	@Override
	public Users findByUserNameAndPassWord(String userName, String passWord) {
		Users check = new Users(userName, passWord);
		SqlSession sqlSession = SqlSessionUtil.openSession();
		Users user = sqlSession.selectOne("user.findByUserNameAndPassWord",check);
		sqlSession.close();
		return user;
	}

	@Override
	public Users checkIfExists(String userName) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		Users user = sqlSession.selectOne("user.checkIfExists", userName);
		sqlSession.close();
		// 返回 Users 对象
		return user;
	}

	@Override
	public int addUser(Users user) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		int count = sqlSession.insert("user.addUser", user);
		sqlSession.commit();
		sqlSession.close();
		return count;
	}

	@Override
	public int deleteById(int id) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		int count = sqlSession.delete("user.deleteById", id);
		sqlSession.commit();
		sqlSession.close();
		return count;
	}

	@Override
	public int update(Users users) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		int count = sqlSession.update("user.update", users);
		sqlSession.commit();
		sqlSession.close();
		return count;
	}
}
