package com.javateam.service;

import java.util.List;

import com.javateam.dao.RiZhiDao;

import com.javateam.po.RiZhi;

public class RiZhiService {
	public static List<RiZhi> queryAll() {
		// 查询
		List<RiZhi> stus = RiZhiDao.queryAll();
		if (stus.size() != 0 && stus != null) {
			return stus;
		} else {
			return null;
		}
	}
	
	public static boolean addStu(RiZhi stu) {
		int i = RiZhiDao.addStu(stu);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
