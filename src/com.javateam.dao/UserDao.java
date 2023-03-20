package com.javateam.dao;

import com.javateam.po.User;
import com.javateam.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> queryAll(){
        List<User> users=new ArrayList<User>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="select * from tb_user";
            conn= DBConnection.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                User u=new User();
                u.setUid(rs.getInt(1));
                u.setUname(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setStatus(rs.getString(4));
                users.add(u);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(conn, ps, rs);
        }
        return users;
    }

    public int addUser(User u){
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

    public int updateUser(User u){
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            String sql="update tb_user set uname=?,password=?,status=? where uid=?";
            conn=DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUname());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getStatus());
            ps.setInt(4, u.getUid());
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            DBConnection.closeAll(conn, ps, null);
        }
        return i;
    }

    public int deleteUser(int uid){
        int i=0;
        try {
            String sql="delete from tb_user where uid=?";
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, uid);
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return i;
    }

}
