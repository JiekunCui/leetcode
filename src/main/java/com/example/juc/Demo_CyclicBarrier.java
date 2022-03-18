package com.example.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 *
 * */
public class Demo_CyclicBarrier {

    /**
     * 必须6个人人一组，到期一组才能出发
     */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(6, new Runnable() {
        @Override
        public void run() {
            System.out.println("barrier action-----------------------");
        }
    });

    /**
     * 创建20个线程同时抢夺
     */
    private CountDownLatch cdl = new CountDownLatch(20);

    public static void main(String[] args) {
        Demo_CyclicBarrier demo_cyclicBarrier = new Demo_CyclicBarrier();
        for (int i = 10; i < 30; i++) {
            new Thread(() -> {
                demo_cyclicBarrier.cdl.countDown();
                demo_cyclicBarrier.park();
            }, "T" + i).start();
        }
    }

    private void park(){

        try {
            long tyrGetPermits = System.currentTimeMillis();
            cyclicBarrier.await(5, TimeUnit.SECONDS);
            long getPermits = System.currentTimeMillis();
            Thread.sleep(1000);
            System.out.println(String.format("%s-park 1s \t,%s,%s,%s", Thread.currentThread().getName(),
                                             tyrGetPermits,getPermits,System.currentTimeMillis()) );
        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            //semaphore.release();
        }

    }

}
