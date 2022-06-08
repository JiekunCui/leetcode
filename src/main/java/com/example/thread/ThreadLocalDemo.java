package com.example.thread;

import java.util.ArrayList;

public class ThreadLocalDemo {
    static ThreadLocal<Byte[]> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        //ArrayList<Object> list = new ArrayList<>();

        while (true) {
            new Thread(){
                @Override
                public void run() {
                    Byte[] bytes = new Byte[102400];
                    threadLocal.set(bytes);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            Thread.sleep(100);
        }
    }
}
