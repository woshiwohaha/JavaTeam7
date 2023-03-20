package com.yly.view;

import com.yly.po.Score;
import com.yly.po.Students;
import com.yly.server.Stuserver;
import com.yly.util.Input;

import java.util.List;

public class Stuview {
    //学生注册
    Students s = new Students();
    Stuserver se = new Stuserver();
    Input sc = new Input();
    public  void  Signup(){
        System.out.println("请输入姓名");
        s.setSname(sc.getString());
        System.out.println("请输入密码");
        s.setPassword(sc.getInt());
        System.out.println("请输入班级");
         s.setClassid(sc.getInt());

         boolean falg  = se.Signup(s);
         if (falg){
             System.out.println("注册成功");
         }
         else {
             System.out.println("注册失败");
         }
    }
    //学生成绩展示
    public void queryAll(){
        System.out.println("学号\t课号\t成绩");
        List<Score> s= se.queryAll();
        for(Score ss:s){
            System.out.println(ss.getSid()+"\t"+ss.getCid()+"\t"+ss.getScore());
        }

    }
    //学生奖励
    public void Jangli(){

        List<Score> s= se.Jangli();
        for(Score ss:s){
            System.out.println(ss.getSid()+"号学员以"+ss.getScore()+"分取得"+ss.getCid()+"号课程第一名给予奖励");
        }
    }
    //学生惩罚
    public void Chengfa(){
        List<Score> s = se.Chengfa();
        for (Score ss:s){
            System.out.println(ss.getSid()+"号学员以"+ss.getScore()+"分排名"+ss.getCid()+"号课程最后一名给予惩罚");
        }
    }


    public static void main(String[] args) {

        Stuview sv = new Stuview();
       while (true) {
           System.out.println("********************************");
           System.out.println("*******欢迎进入学籍管理模块*******");
           System.out.println("********************************");
           System.out.println("1.学生注册 2.成绩查询 3.奖励 4.惩罚 0.退出");
           Input sc = new Input();
           int i = sc.getInt();
           switch (i) {
               case 1:
                   sv.Signup();
                   break;
               case 2:
                   sv.queryAll();
                   break;
               case 3:
                   sv.Jangli();
                   break;
               case 4:
                   sv.Chengfa();
                   break;
               case 0:
                   System.exit(0);
                   break;
               default:
                   System.out.println("您输入了错误的选项");
                   break;
           }
       }
    }
}
