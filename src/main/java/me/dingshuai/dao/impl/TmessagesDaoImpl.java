package me.dingshuai.dao.impl;

import me.dingshuai.dao.TmessagesDao;
import me.dingshuai.pojo.Tmessages;
import me.dingshuai.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TmessagesDaoImpl implements TmessagesDao {

	@Override
	public List<Tmessages> findAll() {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		List<Tmessages> selectAll = sqlSession.selectList("selectAll");
		sqlSession.close();
		return selectAll;
	}

	@Override
	public Tmessages findById(int msgId) {

		SqlSession sqlSession = SqlSessionUtil.openSession();
		Tmessages msg = sqlSession.selectOne("selectById", msgId);
		System.out.println("查找一条 =" + msg);
		sqlSession.close();

		return msg;
	}

	@Override
	public int addMsg(Tmessages msg) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		int count = sqlSession.insert("insert", msg);
		System.out.println("新增 =" + count);
		sqlSession.commit();
		sqlSession.close();
		return count;
	}

	@Override
	public int deleteById(int msgId) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		int count = sqlSession.delete("deleteById", msgId);
		System.out.println("删除 =" + count);
		sqlSession.commit();
		sqlSession.close();
		return count;
	}

	@Override
	public int updateMsg(Tmessages msg) {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		int count = sqlSession.update("updateById", msg);
		System.out.println("更新 =" + count);
		sqlSession.commit();
		sqlSession.close();
		return count;
	}


}
