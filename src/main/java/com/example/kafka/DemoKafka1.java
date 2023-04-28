package com.example.kafka;

public class DemoKafka1 {
    public static void main(String[] args) {
        String topic = "repli-test";
        Producer producer = new Producer(topic);

        new Thread(() -> {
            int i = 10000;
            for (;;){
                producer.sendMsg("" + (i++));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
