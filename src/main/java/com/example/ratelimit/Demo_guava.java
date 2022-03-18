package com.example.ratelimit;

import java.util.concurrent.CountDownLatch;

import com.google.common.util.concurrent.RateLimiter;

public class Demo_guava {

    private RateLimiter limiter = RateLimiter.create(5.0);
    private CountDownLatch cdl = new CountDownLatch(20);

    public static void main(String[] args) {

        Demo_guava demo_guava = new Demo_guava();

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                demo_guava.cdl.countDown();
                demo_guava.testMethod();
            }, "T" + i).start();
        }

    }

    private void testMethod(){

        double acquire = limiter.acquire();

        System.out.println(String.format( "%s-success,%s",Thread.currentThread().getName(),System.currentTimeMillis() ) );
    }


}
