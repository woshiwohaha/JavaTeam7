package com.javateam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javateam.po.JueSe;

import com.javateam.util.DBConnection;

public class JueSeDao {
	public static List<JueSe> queryAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<JueSe> stus = new ArrayList<JueSe>();
		String sql = "select * from juese";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareCall(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				JueSe s = new JueSe();
				s.setId(rs.getInt(1));
				s.setJname(rs.getString(2));
				s.setJqx(rs.getString(3));
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

	// 新增





	//
	public int updateOne(int sid, String str, String str1) {
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "update student set " + str + "=? where sid=?";
		System.out.println(str + str1 + sid);
		int i = 0;
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareCall(sql);
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
		String sql = "delete from juese where sid =?";
		Connection conn = null;
		PreparedStatement ps = null;
		String sql1 = "alter table student drop sid";
		String sql2 = "alter TABLE student add sid int(11) primary key auto_increment FIRST";
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
