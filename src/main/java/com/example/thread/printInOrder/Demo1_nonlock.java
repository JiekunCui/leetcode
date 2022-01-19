package com.example.thread.printInOrder;

/**
 * 多线程交替打印
 */
public class Demo1_nonlock {

    private static volatile int num =0;
    public static void main(String[] args) {

        new Thread(new PrintInOrder(4,0)).start();
        new Thread(new PrintInOrder(4,1)).start();
        new Thread(new PrintInOrder(4,2)).start();
        new Thread(new PrintInOrder(4,3)).start();
    }


    static class PrintInOrder implements Runnable{
        private final int mod;
        private final int left;
        PrintInOrder(int mod,int left){
            this.left=left;
            this.mod=mod;
        }

        @Override
        public void run() {
            try {
                while (true){
                    Thread.sleep(100);
                    if (num%mod==left){
                        System.out.println(Thread.currentThread().getName() + " " + num);
                        num++;
                        Thread.yield();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


