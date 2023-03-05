package me.dingshuai.dao.impl;

import me.dingshuai.dao.TusersDao;
import me.dingshuai.pojo.Tusers;
import me.dingshuai.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class TusersDaoImpl implements TusersDao {

	@Override
	public Tusers findById(String userId) {

		SqlSession sqlSession = SqlSessionUtil.openSession();
		Tusers user = sqlSession.selectOne("user.findById", userId);
		sqlSession.close();
		return user;
	}

	@Override
	public List<Tusers> findAll() {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		List<Tusers> list = sqlSession.selectList("user.findAll");
		sqlSession.close();
		return list;
	}

	@Override
	public Tusers findByUserNameAndPassWord(String userName, String passWord) {
		Tusers check = new Tusers(userName, passWord);
		SqlSession sqlSession = SqlSessionUtil.openSession();
		Tusers user = sqlSession.selectOne("user.findByUserNameAndPassWord",check);
		sqlSession.close();
		return user;
	}

	@Override
	public Tusers checkIfExists(String userName) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		Tusers user = sqlSession.selectOne("user.checkIfExists", userName);
		sqlSession.close();
		// 返回 Tusers 对象
		return user;
	}

	@Override
	public int addUser(Tusers tuser) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		int count = sqlSession.insert("user.addUser", tuser);
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
	public int update(Tusers tusers) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		int count = sqlSession.update("user.update", tusers);
		sqlSession.commit();
		sqlSession.close();
		return count;
	}
}
