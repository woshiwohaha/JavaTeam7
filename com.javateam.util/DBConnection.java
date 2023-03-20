package com.javateam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	static String UserName = "root";
	static String password = "123456";
	static String url = "jdbc:mysql://127.0.0.1:3306/b514?useSSL=false&serverTimezone=UTC";

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, UserName, password);
		return conn;
	}

	public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs)  {
		try {
			if(conn!=null){
				conn.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
