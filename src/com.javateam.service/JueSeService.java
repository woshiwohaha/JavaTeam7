package com.javateam.service;

import java.util.List;

import com.javateam.dao.JueSeDao;
import com.javateam.po.JueSe;


public class JueSeService {
	public static boolean delete(int sid) {

		JueSeDao js = new JueSeDao();
		int i = 0;

		i = js.delete(sid);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}
	public static List<JueSe> queryAll() {
		List<JueSe> stus = JueSeDao.queryAll();
		if (stus.size() != 0 && stus != null) {
			return stus;
		} else {
			return null;
		}
	}
}
