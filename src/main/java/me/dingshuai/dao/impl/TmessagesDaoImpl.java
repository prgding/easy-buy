package me.dingshuai.dao.impl;

import me.dingshuai.dao.TmessagesDao;
import me.dingshuai.pojo.Tmessages;
import me.dingshuai.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TmessagesDaoImpl implements TmessagesDao {

	@Override
	public List<Tmessages> findAll() {
		List<Tmessages> list = new ArrayList<>();
		String sql = "select * from tmessages";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Tmessages Tmessages = new Tmessages();
				Tmessages.setMsgId(rs.getInt("msgId"));
				Tmessages.setMsgSender(rs.getString("msgSender"));
				Tmessages.setMsgContent(rs.getString("msgContent"));
				Tmessages.setMsgContent(rs.getString("msgStatus"));
				list.add(Tmessages);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public int addMsg(Tmessages msg) {
		int status = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into tmessages(msgId,msgSender,msgContent,msgStatus) values(?,?,?,?)";
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, msg.getMsgId());
			ps.setString(2, msg.getMsgContent());
			ps.setString(3, msg.getMsgContent());
			ps.setString(4, msg.getMsgStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, ps, null);
		}
		return status;
	}

	@Override
	public int deleteById(int msgId) {
		int status = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from tmessages where msgId = ?";
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, msgId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, ps, null);
		}
		return status;
	}

	@Override
	public int updateMsg(Tmessages msg) {
		int status = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE tmessages SET msgSender = ?, msgContent = ?, msgStatus = ? WHERE msgId = ?";
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, msg.getMsgContent());
			ps.setString(2, msg.getMsgContent());
			ps.setString(3, msg.getMsgStatus());
			ps.setInt(4, msg.getMsgId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, ps, null);
		}
		return status;
	}

	@Override
	public Tmessages findById(int msgId) {
		Tmessages user = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 使用 DButil 类的 getConnection 方法获取数据库连接
			conn = DButil.getConnection();

			// 创建 SQL 查询语句
			String sql = "SELECT * FROM tmessages WHERE msgId = ? ";

			// 创建 PreparedStatement 对象
			stmt = conn.prepareStatement(sql);

			// 为 PreparedStatement 对象的参数赋值
			stmt.setInt(1, msgId);

			// 使用 PreparedStatement 对象的 executeQuery 方法执行查询
			rs = stmt.executeQuery();

			// 如果查询结果不为空，则创建 Tmessages 对象
			if (rs.next()) {
				user = new Tmessages();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 使用 DButil 类的 close 方法关闭连接
			DButil.close(conn, stmt, rs);
		}

		// 返回 Tmessages 对象
		return user;
	}
}
