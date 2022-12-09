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
				Tusers.setUserId(rs.getInt("userid"));
				Tusers.setUsername(rs.getString("username"));
				Tusers.setPassword(rs.getString("password"));
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
	public Tusers findByUsernameAndPassword(String username, String password) {
		Tusers user = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 使用 DButil 类的 getConnection 方法获取数据库连接
			conn = DButil.getConnection();

			// 创建 SQL 查询语句
			String sql = "SELECT * FROM tusers WHERE username = ? AND password = ?";

			// 创建 PreparedStatement 对象
			stmt = conn.prepareStatement(sql);

			// 为 PreparedStatement 对象的参数赋值
			stmt.setString(1, username);
			stmt.setString(2, password);

			// 使用 PreparedStatement 对象的 executeQuery 方法执行查询
			rs = stmt.executeQuery();

			// 如果查询结果不为空，则创建 Tusers 对象，并设置属性值
			if (rs.next()) {
				user = new Tusers();
				user.setUserId(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
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
	public Tusers findByUsername(String username) {
		Tusers user = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 使用 DButil 类的 getConnection 方法获取数据库连接
			conn = DButil.getConnection();

			// 创建 SQL 查询语句
			String sql = "SELECT * FROM tusers WHERE username = ? ";

			// 创建 PreparedStatement 对象
			stmt = conn.prepareStatement(sql);

			// 为 PreparedStatement 对象的参数赋值
			stmt.setString(1, username);

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
		String sql = "insert into tusers(username,password,location,phoneNumber) values(?,?,?,?)";
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
		String sql = "delete from tusers where userid = ?";
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
		String sql = "UPDATE Tusers SET username = ?, password = ?, location = ?, phoneNumber = ? WHERE userid = ?";
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
