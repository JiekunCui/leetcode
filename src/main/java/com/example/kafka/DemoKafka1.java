package com.example.kafka;

public class DemoKafka1 {
    public static void main(String[] args) {
        String topic = "test";
        Producer producer = new Producer(topic);

        new Thread(){
            @Override
            public void run() {
                for (;;){
                    producer.sendMsg("aaa" + System.currentTimeMillis());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
