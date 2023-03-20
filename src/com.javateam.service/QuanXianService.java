package com.javateam.service;

import java.util.List;


import com.javateam.dao.QuanXianDao;
import com.javateam.po.QuanXian2;


public class QuanXianService {
	public static List<QuanXian2> queryAll() {
		// 查询
		List<QuanXian2> stus = QuanXianDao.queryAll();
		if (stus.size() != 0 && stus != null) {
			return stus;
		} else {
			return null;
		}
	}

	// 删除
	public static boolean delete(int sid) {
		QuanXianDao qx = new QuanXianDao();
		int i = 0;
		i = qx.delete(sid);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean updateOne(int i, int sid, String str, String str1) {
		if (i == 2) {
			QuanXianDao sd = new QuanXianDao();
			String str3 = str;
			switch (str3) {
			case "权限名":
				str = "q2sname";
				break;
			case "权限集合":
				str = "jihe";
				break;
			default:
				break;
			}
			int i2 = sd.updateOne(i,sid, str, str1);
			if (i2 > 0) {
				return true;
			} else {
				return false;
			}
		}else if(i==3) {
			QuanXianDao sd = new QuanXianDao();
			String str3 = str;
			switch (str3) {
			case "角色名":
				str = "jq2sname";
				break;
			case "角色权限":
				str = "jqx";
				break;
			default:
				break;
			}
			int i2 = sd.updateOne(i,sid, str, str1);
			if (i2 > 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	public static boolean addStu(QuanXian2 stu) {
		QuanXianDao sd = new QuanXianDao();
		int i = sd.addStu(stu);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
