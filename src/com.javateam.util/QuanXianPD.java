package com.javateam.util;



import com.javateam.dao.QuanXianDao;


public class QuanXianPD{
	
	public static boolean panduan(int suoxvquanxian) {
		String str = new String();
		int shenfenid=3;
		str = QuanXianDao.query(shenfenid);
		int c=0;
		String i2=suoxvquanxian+"";
		System.out.println("权限集合");
		String[] strlist = str.split(",");
		for(String s : strlist){
			System.out.println(s);
			if(s.equals(i2)) {c++;}
		}
		System.out.println(c);
		boolean a= c>0? true : false;
		if (a) {
			
		} else {
			System.out.println("无权限");
		}
		return a;
	}
}
