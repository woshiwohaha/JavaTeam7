package com.javateam.service;

import com.javateam.dao.UserDao;
import com.javateam.po.User;

import java.util.List;

public class UserService {
    UserDao ud= new UserDao();

    public List<User> queryAll(){
        List<User> users=ud.queryAll();
        if(users.size()!=0&&users!=null){
            return users;
        }
        return null;
    }

    public boolean addUser(User u){
        int i=ud.addUser(u);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean updateUser(User u){
        int i=ud.updateUser(u);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteUser(int uid){
        int i=ud.deleteUser(uid);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
