package com.example.ratelimit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import com.google.common.util.concurrent.RateLimiter;

public class Demo_guava {

    private RateLimiter limiter = RateLimiter.create(5.0);
    private CountDownLatch cdl = new CountDownLatch(50);

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
        Date begin = new Date();
        double acquire = limiter.acquire();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.sss");
        System.out.println(String.format( "%s-get permit,%s,%s",Thread.currentThread().getName(),format.format(begin),format.format(new Date()) ) );
    }


}
