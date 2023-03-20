package com.javateam.service;

import com.yly.Dao.StuDao;
import com.yly.po.Score;
import com.yly.po.Students;

import java.util.List;

public class Stuserver {
    //学生注册
    StuDao ss = new StuDao();
    public boolean  Signup(Students s){
        int i =ss.Signup(s);
        if (i>0){
            return true;
        }
        else {
            return false;
        }
    }
    //学生成绩展示
    public List<Score> queryAll(){
        List<Score> s = ss.qeryAll();
        if (s!=null){
            return s;
        }
        return null;
    }
    //学生奖励
    public  List<Score> Jangli(){
        List<Score> s = ss.Jangli();
        if (s!=null){
            return s;
        }
        return null;
    }
    //学生惩罚
    public List<Score> Chengfa(){
        List<Score> s = ss.Chengfa();
        if(s!=null){
            return s;
        }
        return null;
    }
}
