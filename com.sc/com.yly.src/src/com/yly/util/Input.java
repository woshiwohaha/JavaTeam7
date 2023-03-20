package com.yly.util;

import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);
    public int getInt(){
        int i = sc.nextInt();
        return i;
    }
    public String getString(){
        String s = sc.next();
        return s;
    }
}
