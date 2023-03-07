package me.dingshuai.dao.impl;
import me.dingshuai.dao.MessagesDao;
import me.dingshuai.pojo.Messages;
import me.dingshuai.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class MessagesDaoImpl implements MessagesDao {
	@Override
	public int addMsg(Messages msg) {
		SqlSession sqlSession = SqlSessionUtil.open();
		int count = sqlSession.insert("msg.insert", msg);
		System.out.println("msg.新增 =" + count);
		sqlSession.commit();
		return count;
	}

	@Override
	public int deleteById(int msgId) {
		SqlSession sqlSession = SqlSessionUtil.open();
		int count = sqlSession.delete("msg.deleteById", msgId);
		System.out.println("msg.删除 =" + count);
		sqlSession.commit();
		return count;
	}

	@Override
	public int updateMsg(Messages msg) {
		SqlSession sqlSession = SqlSessionUtil.open();
		int count = sqlSession.update("msg.updateById", msg);
		System.out.println("msg.更新 =" + count);
		sqlSession.commit();
		return count;
	}
	@Override
	public List<Messages> findAll() {
		SqlSession sqlSession = SqlSessionUtil.open();
		return sqlSession.selectList("msg.selectAll");
	}

	@Override
	public Messages findById(int msgId) {
		SqlSession sqlSession = SqlSessionUtil.open();
		Messages msg = sqlSession.selectOne("msg.selectById", msgId);
		System.out.println("msg.查找一条 =" + msg);
		return msg;
	}
}
