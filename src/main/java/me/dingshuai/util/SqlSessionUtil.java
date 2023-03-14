package me.dingshuai.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
	public SqlSessionUtil() {
	}

	private static SqlSessionFactory sqlSessionFactory;
	private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

	static {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}


	public static SqlSession open() {
		SqlSession sqlSession = local.get();
		if (sqlSession == null) {
			System.out.println("sqlSession为空，新建一个");
			sqlSession = sqlSessionFactory.openSession();
			local.set(sqlSession);
		}
		return sqlSession;
	}

	public static void close(SqlSession sqlSession) {
		if (sqlSession != null) {
			System.out.println("有sqlSession，关闭");
			sqlSession.close();
			local.remove();
		}
	}
}
