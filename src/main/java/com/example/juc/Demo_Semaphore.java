package com.example.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 *
 * */
public class Demo_Semaphore {

    /**
     * 停车场一共有5个车位
     */
    private Semaphore semaphore = new Semaphore(5);

    /**
     * 创建20个线程同时抢夺
     */
    private CountDownLatch cdl = new CountDownLatch(20);

    public static void main(String[] args) {
        Demo_Semaphore demo_semaphore = new Demo_Semaphore();
        for (int i = 10; i < 30; i++) {
            new Thread(() -> {
                demo_semaphore.cdl.countDown();
                demo_semaphore.park();
            }, "T" + i).start();
        }
    }

    private void park(){

        try {
            long tyrGetPermits = System.currentTimeMillis();
            semaphore.acquire();
            long getPermits = System.currentTimeMillis();
            Thread.sleep(1000);
            System.out.println(String.format("%s-park 1s \t,%s,%s,%s", Thread.currentThread().getName(),
                                             tyrGetPermits,getPermits,System.currentTimeMillis()) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

}
