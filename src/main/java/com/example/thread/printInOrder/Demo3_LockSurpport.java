package com.example.thread.printInOrder;

import java.util.concurrent.locks.LockSupport;

public class Demo3_LockSurpport {
    static Thread t1,t2;
    public static void main(String[] args) {
        char[] sInt = "1234567".toCharArray();
        char[] sChar = "abcdefg".toCharArray();



        t1 = new Thread(() -> {
            for (char c : sInt) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (char c : sChar) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }

            System.out.println();
        });
        t1.start();
        t2.start();
    }

}
