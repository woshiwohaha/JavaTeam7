package com.javateam.dao;

import com.javateam.po.User;
import com.javateam.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public User logon(String uname, String password) {
        int flag=0;
        User u=new User();
        try {
            String sql="select * from tb_user where uname=? and password=?";
            Connection conn= DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                u.setUname(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setStatus(rs.getString(4));
            }

        }catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return u;
    }

    public int login(User u) {
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            String sql="insert into student values(null,?,?,?)";
            conn=DBConnection.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, u.getUname());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getStatus());
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            DBConnection.closeAll(conn, ps, null);
        }
        return i;
    }
}

