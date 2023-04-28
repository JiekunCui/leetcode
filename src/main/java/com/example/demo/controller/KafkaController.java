package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    private static String topic = "repli-test";

    @RequestMapping(method = RequestMethod.GET,path = "/send")
    public String send(String msg){
        kafkaTemplate.send(topic,msg==null?System.currentTimeMillis():msg);
        return "success";
    }
}
