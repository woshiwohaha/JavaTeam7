package com.javateam.dao;

import com.yly.po.Score;
import com.yly.po.Students;
import com.yly.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDao {
    //学生注册

    public int Signup(Students s){
        int i=0;
        int j=0;
        try {
            String sql1 = "insert into tb_user values(null,?,?,?)";

            String  sql2 = "insert into tb_students values(null,?,?)";
            Connection conn  = DBConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(sql2);

            ps1.setInt(1,s.getClassid());
            ps1.setString(2,s.getSname());
            i = ps1.executeUpdate();
            PreparedStatement ps2 = conn.prepareStatement(sql1);
            ps2.setString(1,s.getSname());
            ps2.setInt(2,s.getPassword());
            ps2.setString(3,"学生");
            j = ps2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i>0&&j>0)
        {
            return i;
        }
        else {
            return 0;
        }

    }
    //学生奖惩
    //1.学生成绩展示
    public List<Score> qeryAll(){
        List<Score> s = new ArrayList<Score>();
        try {
            String sql1 = "select * from tb_score";
            Connection conn  = DBConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                Score sc = new Score();
                sc.setSid(rs.getInt(1));
                sc.setCid(rs.getInt(2));
                sc.setScore(rs.getInt(3));
                s.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    //2.学生奖励
    public List<Score> Jangli(){
        List<Score> s = new ArrayList<Score>();
        try {
            String sql1 = "select tb_score.sid, tb_score.cid, tb_score.score from tb_score join(select cid,max(score) as max_score from tb_score group by cid) as max_scores on tb_score.cid = max_scores.cid and tb_score.score = max_scores.max_score";
            Connection conn  = DBConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                Score sc =  new Score();
                sc.setSid(rs.getInt(1));
                sc.setCid(rs.getInt(2));
                sc.setScore(rs.getInt(3));
                s.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    //3.学生处罚
    public List<Score> Chengfa(){
        List<Score> s = new ArrayList<Score>();
        try {
            String sql1 = "select tb_score.sid, tb_score.cid, tb_score.score from tb_score join(select cid,min(score) as min_score from tb_score group by cid) as min_scores on tb_score.cid = min_scores.cid and tb_score.score = min_scores.min_score";
            Connection conn  = DBConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                Score sc =  new Score();
                sc.setSid(rs.getInt(1));
                sc.setCid(rs.getInt(2));
                sc.setScore(rs.getInt(3));
                s.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
}
