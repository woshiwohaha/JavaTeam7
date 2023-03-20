package com.javateam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.javateam.po.QuanXian2;

import com.javateam.util.DBConnection;

public class QuanXianDao {
	// 查询
	public static List<QuanXian2> queryAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QuanXian2> stus = new ArrayList<QuanXian2>();
		String sql = "select * from quanxianjihe";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareCall(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				QuanXian2 s = new QuanXian2();
				s.setId(rs.getInt(1));
				s.setQ2name(rs.getString(2));
				s.setJihe(rs.getString(3));
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

	public static String query(int i) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String str = null;
		String sql = "select * from quanxianjihe where id=?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareCall(sql);
			ps.setInt(1, i);
			rs = ps.executeQuery();
			while (rs.next()) {
				str = rs.getString(3);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeAll(conn, ps, rs);
		}

		return str;
	}

	public static String query1(int i) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String str = null;
		String sql = "select qname from quanxian where id=?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareCall(sql);
			ps.setInt(1, i);
			rs = ps.executeQuery();
			while (rs.next()) {
				str = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeAll(conn, ps, rs);
		}
		System.out.println(str);
		return str;
	}

	// 新增
	public int addStu(QuanXian2 stu) {
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		String sql = "insert into quanxianjihe values(null,?,?)";

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareCall(sql);
			ps.setString(1, stu.getQ2name());
			ps.setString(2, stu.getJihe());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeAll(conn, ps, null);
		}
		return i;
	}

	// 修改


	

	//
	public int updateOne(int i2, int sid, String str, String str1) {
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "update quanxianjihe set " + str + "=? where id=?";
		String sql2 = "update juese set " + str + "=? where id=?";
		System.out.println(str + str1 + sid);
		int i = 0;
		try {
			conn = DBConnection.getConnection();
			ps = i2 == 2 ? conn.prepareCall(sql) : conn.prepareCall(sql2);
			ps.setString(1, str1);
			ps.setInt(2, sid);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeAll(conn, ps, null);
		}
		return i;
	}

	// 删除
	public int delete(int sid) {
		String sql = "delete from quanxianjihe where id =?";
		Connection conn = null;
		PreparedStatement ps = null;
		String sql1 = "alter table quanxianjihe drop id";
		String sql2 = "alter TABLE quanxianjihe add id int(11) primary key auto_increment FIRST";
		int i = 0;
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareCall(sql);
			ps.setInt(1, sid);
			i = ps.executeUpdate();
			ps.executeUpdate(sql1);
			ps.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeAll(conn, ps, null);
		}
		return i;

	}

}
