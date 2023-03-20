package com.javateam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javateam.po.RiZhi;

import com.javateam.util.DBConnection;

public class RiZhiDao {
	public static int addStu(RiZhi stu) {
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		String sql = "insert into rizhi (user_id, action) values (?,?);";

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareCall(sql);
			ps.setInt(1, stu.getUser_id());
			ps.setString(2, stu.getAction());
			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeAll(conn, ps, null);
		}
		return i;
	}
	
	public static List<RiZhi> queryAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RiZhi> stus = new ArrayList<RiZhi>();
		String sql = "select * from RiZhi";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareCall(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				RiZhi s = new RiZhi();
				s.setId(rs.getInt(1));
				s.setUser_id(rs.getInt(2));
				s.setAction(rs.getString(3));
				s.setTimestamp(rs.getString(4));
				stus.add(s);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeAll(conn, ps, rs);
		}
		return stus;
	}

}
