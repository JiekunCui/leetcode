package com.example.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * */
public class Demo_ReentraLock {

    /**
     * 停车场一共有5个车位
     */
    private static ReentrantLock lock = new ReentrantLock(true);


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        test();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    public static void test() throws InterruptedException {
        lock.lock();
        System.out.print(Thread.currentThread().getName() + " test execute. ");
        Thread.sleep(1000);
        test1();
        lock.unlock();
    }

    public static void test1() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " test1 execute.");
        Thread.sleep(1000);
        lock.unlock();
    }


}
