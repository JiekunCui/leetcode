package com.example.spring;

import com.example.spring.config.TestConfig;
import com.example.spring.importlearn.ACls;
import com.example.spring.importlearn.IA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                TestConfig.class);
        //Object user = applicationContext.getBean("user");
        //Object user1 = applicationContext.getBean("user");
        IA bean = applicationContext.getBean(IA.class);
        System.out.println(bean.getClass());
    }
}
