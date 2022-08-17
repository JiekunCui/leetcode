package com.example.kafka;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer{

    private final KafkaProducer<String, String> producer;
    private final String topic;

    public Producer(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        //props.put("acks", "all");
        props.put("retries", 1);
        //props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        this.producer = new KafkaProducer<>(props);
        this.topic = topicName;
    }

    public void sendMsg(String message) {
        try {
            Future<RecordMetadata> send =
                    producer.send(new ProducerRecord<>(topic, message));
            RecordMetadata record = send.get();
            System.out.println("sendMsg:" + record);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void close(String message) {
        try {
            producer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

}
