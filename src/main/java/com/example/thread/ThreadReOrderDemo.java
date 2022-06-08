package com.example.thread;

/**
 * 指令重排示例
 */
public class ThreadReOrderDemo {

    static volatile int a = 0, b = 0;
    static  int y = 0, x = 0;
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            a = 0;
            b = 0;
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            };

            Thread t2 = new Thread() {
                @Override
                public void run() {
                    b = 2;
                    y = a;
                }
            };

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.print(++count );
            System.out.print("\tx=" + x);
            System.out.print("\ty=" + y);
            System.out.print("\ta=" + a);
            System.out.println("\tb=" + b);
            if (x == 0 && y == 0) {
                return;
            }
        }

    }
}
