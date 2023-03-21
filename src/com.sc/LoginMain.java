package com.sc;

import com.javateam.po.User;
import com.javateam.service.LoginService;
import com.javateam.util.InPutUtil;

public class LoginMain {
    static LoginService ls=new LoginService();

    public static String logon() {
        System.out.println("请输入用户名：");
        String uname= InPutUtil.getString();
        System.out.println("请输入密码：");
        String password= InPutUtil.getString();
        String statue=ls.logon(uname, password);
        if(statue!=null) {
            System.out.println("登录成功！");
            return statue;
        }else {
            System.out.println("用户名和密码错误！");
            System.exit(0);
        }
        return null;
    }

    public static void login() {
        System.out.println("请输入新账号的用户名：");
        String uname=InPutUtil.getString();
        System.out.println("请输入新账号的密码：");
        String password=InPutUtil.getString();
        System.out.println("请输入新账号的身份：");
        String statue=InPutUtil.getString();
        User u=new User();
        u.setUname(uname);
        u.setPassword(password);
        u.setStatus(statue);
        boolean flag=ls.login(u);
        if(flag) {
            System.out.println("注册成功！");
        }else {
            System.out.println("注册失败！");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        boolean flag=true;
        String sta=null;
        while(flag) {
            System.out.println("************请选择你的操作***************");
            System.out.println("请选择：1、登录\t2、注册\t0、退出");
            System.out.println("****************************************");
            int i=InPutUtil.getInt();
            switch (i) {
                case 1:
                    System.out.println("登录");
                    sta=logon();
                    if(sta!=null) {
                        flag=false;
                        System.out.println("您以"+sta+"的身份登入本系统!");
                    }
                    break;
                case 2:
                    System.out.println("注册");
                    login();
                    break;
                case 0:
                    System.out.println("系统已退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("没有此选项，请重新选择：");
                    break;
            }
        }
    }

}
