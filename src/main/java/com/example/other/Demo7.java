package com.example.other;

import java.text.ParseException;
import java.util.ServiceLoader;

import com.example.demo.service.UserService;
import com.example.leetcode.node.ListNode;

public class Demo7 {


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

    public static void main(String[] args) throws ParseException {

        Father son = new Son();
        System.out.println("gay a=" + son.a);
    }

}
