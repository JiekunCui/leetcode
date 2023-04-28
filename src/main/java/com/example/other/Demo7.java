package com.example.other;

import java.text.ParseException;
import java.util.ServiceLoader;

import com.example.demo.service.UserService;
import com.example.leetcode.node.ListNode;

public class Demo7 {

    static {
        System.out.println("static");
    }


    static class Father{
        public int a = 1;
        public Father(){
            a = 2;
            show();
        }

        public void show() {
            System.out.println("father a=" + a);
        }
    }

    static class Son extends Father{
        public int a = 3;
        public Son(){
            a = 4;
            show();
        }

        public void show() {
            System.out.println("Son a=" + a);
        }
    }

    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        Father son = new Son();
        ClassLoader classLoader = Father.class.getClassLoader();
        Class.forName("com.example.other.P_cloud");
        System.out.println("gay a=" + son.a);
    }

}
