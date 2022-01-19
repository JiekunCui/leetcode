package com.example.thread.printInOrder;

public class Demo2_sync {

    private static volatile int num = 0;
    private static Object source = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (source) {
                        while (true) {
                            Thread.sleep(1000);
                            if (num % 2 == 0) {
                                System.out.println(Thread.currentThread().getName() + " " + num);
                                num++;
                                source.notify();
                            }
                            source.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (source) {
                        while (true) {
                            Thread.sleep(1000);
                            if (num % 2 == 1) {
                                System.out.println(Thread.currentThread().getName() + " " + num);
                                num++;
                                source.notify();
                            }
                            source.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
