package me.dingshuai.dao.impl;

import me.dingshuai.dao.TusersDao;
import me.dingshuai.pojo.Tusers;
import me.dingshuai.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TusersDaoImpl implements TusersDao {

	@Override
	public Tusers findById(String userId) {
		Tusers user = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 使用 DButil 类的 getConnection 方法获取数据库连接
			conn = DButil.getConnection();

			// 创建 SQL 查询语句
			String sql = "SELECT * FROM tusers WHERE userId = ? ";

			// 创建 PreparedStatement 对象
			stmt = conn.prepareStatement(sql);

			// 为 PreparedStatement 对象的参数赋值
			stmt.setInt(1, Integer.parseInt(userId));

			// 使用 PreparedStatement 对象的 executeQuery 方法执行查询
			rs = stmt.executeQuery();

			// 如果查询结果不为空，则创建 Tusers 对象
			if (rs.next()) {
				user = new Tusers();
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("passWord"));
				user.setLocation(rs.getString("location"));
				user.setPhoneNumber(rs.getString("phoneNumber"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 使用 DButil 类的 close 方法关闭连接
			DButil.close(conn, stmt, rs);
		}

		// 返回 Tusers 对象
		return user;
	}

	@Override
	public List<Tusers> findAll() {
		List<Tusers> list = new ArrayList<>();
		String sql = "select * from tusers";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Tusers Tusers = new Tusers();
				Tusers.setUserId(rs.getInt("userId"));
				Tusers.setUsername(rs.getString("userName"));
				Tusers.setPassword(rs.getString("passWord"));
				Tusers.setLocation(rs.getString("location"));
				Tusers.setPhoneNumber(rs.getString("phoneNumber"));
				list.add(Tusers);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public Tusers findByUserNameAndPassWord(String userName, String passWord) {
		Tusers user = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 使用 DButil 类的 getConnection 方法获取数据库连接
			conn = DButil.getConnection();

			// 创建 SQL 查询语句
			String sql = "SELECT * FROM tusers WHERE userName = ? AND passWord = ?";

			// 创建 PreparedStatement 对象
			stmt = conn.prepareStatement(sql);

			// 为 PreparedStatement 对象的参数赋值
			stmt.setString(1, userName);
			stmt.setString(2, passWord);

			// 使用 PreparedStatement 对象的 executeQuery 方法执行查询
			rs = stmt.executeQuery();

			// 如果查询结果不为空，则创建 Tusers 对象，并设置属性值
			if (rs.next()) {
				user = new Tusers();
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("passWord"));
				user.setLocation(rs.getString("location"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 使用 DButil 类的 close 方法关闭连接
			DButil.close(conn, stmt, rs);
		}

		// 返回 Tusers 对象
		return user;
	}

	@Override
	public Tusers checkIfExists(String userName) {
		Tusers user = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 使用 DButil 类的 getConnection 方法获取数据库连接
			conn = DButil.getConnection();

			// 创建 SQL 查询语句
			String sql = "SELECT * FROM tusers WHERE userName = ? ";

			// 创建 PreparedStatement 对象
			stmt = conn.prepareStatement(sql);

			// 为 PreparedStatement 对象的参数赋值
			stmt.setString(1, userName);

			// 使用 PreparedStatement 对象的 executeQuery 方法执行查询
			rs = stmt.executeQuery();

			// 如果查询结果不为空，则创建 Tusers 对象
			if (rs.next()) {
				user = new Tusers();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 使用 DButil 类的 close 方法关闭连接
			DButil.close(conn, stmt, rs);
		}

		// 返回 Tusers 对象
		return user;
	}

	@Override
	public int addUser(Tusers tuser) {
		int status = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into tusers(userName,passWord,location,phoneNumber) values(?,?,?,?)";
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tuser.getUsername());
			ps.setString(2, tuser.getPassword());
			ps.setString(3, tuser.getLocation());
			ps.setString(4, tuser.getPhoneNumber());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, ps, null);
		}
		return status;
	}

	@Override
	public int deleteById(int id) {
		int status = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from tusers where userId = ?";
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, ps, null);
		}
		return status;
	}

	@Override
	public int update(Tusers tusers) {
		int status = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE Tusers SET userName = ?, passWord = ?, location = ?, phoneNumber = ? WHERE userId = ?";
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tusers.getUsername());
			ps.setString(2, tusers.getPassword());
			ps.setString(3, tusers.getLocation());
			ps.setString(4, tusers.getPhoneNumber());
			ps.setInt(5, tusers.getUserId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, ps, null);
		}
		return status;
	}
}
