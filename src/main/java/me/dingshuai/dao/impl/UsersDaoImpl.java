package me.dingshuai.dao.impl;
import me.dingshuai.dao.UsersDao;
import me.dingshuai.pojo.Users;
import me.dingshuai.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
	@Override
	public int addUser(Users user) {
		SqlSession sqlSession = SqlSessionUtil.open();
		int count = sqlSession.insert("user.addUser", user);
		sqlSession.commit();
		return count;
	}

	@Override
	public int deleteById(int id) {
		SqlSession sqlSession = SqlSessionUtil.open();
		int count = sqlSession.delete("user.deleteById", id);
		sqlSession.commit();
		return count;
	}

	@Override
	public int update(Users users) {
		SqlSession sqlSession = SqlSessionUtil.open();
		int count = sqlSession.update("user.update", users);
		sqlSession.commit();
		return count;
	}

	@Override
	public Users findById(String userId) {

		SqlSession sqlSession = SqlSessionUtil.open();
		return sqlSession.selectOne("user.findById", userId);
	}

	@Override
	public List<Users> findAll() {
		SqlSession sqlSession = SqlSessionUtil.open();
		return sqlSession.selectList("user.findAll");
	}

	@Override
	public Users findByUserNameAndPassWord(String userName, String passWord) {
		Users check = new Users(userName, passWord);
		SqlSession sqlSession = SqlSessionUtil.open();
		return sqlSession.selectOne("user.findByUserNameAndPassWord",check);
	}

	@Override
	public Users checkIfExists(String userName) {
		SqlSession sqlSession = SqlSessionUtil.open();
		// 返回 Users 对象
		return sqlSession.selectOne("user.checkIfExists", userName);
	}

}
