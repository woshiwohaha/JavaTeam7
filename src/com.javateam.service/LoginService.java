package com.javateam.service;

import com.javateam.dao.LoginDao;
import com.javateam.po.User;

public class LoginService {
    LoginDao ld=new LoginDao();

    public String logon(String uname,String password) {
        User u=ld.logon(uname,password);
        if(u!=null) {
            String statue=u.getStatus();
            return statue;
        }
        return null;
    }

    public boolean login(User u) {
        int i=ld.login(u);
        if(i!=0) {
            return true;
        }
        return false;
    }
}
