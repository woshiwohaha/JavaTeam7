package com.javateam.util;

import com.javateam.dao.QuanXianDao;
import com.javateam.po.RiZhi;
import com.javateam.service.RiZhiService;

public class RiZhiadd {
	public static void rzAdd(int i) {
		RiZhi rz = new RiZhi();
		rz.setUser_id(1);// 登陆时传入的角色值
		String action = QuanXianDao.query1(i);
		rz.setAction(action);
		RiZhiService.addStu(rz);
	}

}
