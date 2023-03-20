package com.javateam.util;

import java.util.Scanner;

public class InPutUtil {
	static Scanner scan = new Scanner(System.in);
	public static int getInt() {
		int b=scan.nextInt();
		return b;
		}
	public static String getString() {
		String s=scan.next();
		return s;
		}
	
}
