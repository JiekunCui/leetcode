package com.example.spring.config;

import com.example.spring.bean.MyBeanFactoryPostProcessor;
import com.example.spring.bean.MyBeanPostProcessor;
import com.example.spring.bean.TestBean;
import com.example.spring.bean.User;
import com.example.spring.importlearn.MyDeferredImportSelector;
import com.example.spring.importlearn.MyImportBeanDefinitionRegistrar;
import com.example.spring.importlearn.MyImportSelector;
import com.example.spring.importlearn.Normal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({Normal.class, MyImportSelector.class, MyDeferredImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@ComponentScan("com.example.spring.importlearn")
public class TestConfig {
    //@Bean
    //public MyBeanPostProcessor _myBeanPostProcessor(){
    //    return new MyBeanPostProcessor();
    //}

    //@Bean
    //public User user(){
    //    return new User();
    //}



    //@Bean
    //public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
    //    return new MyBeanFactoryPostProcessor();
    //}

    //@Bean
    //public TestBean TestBean(){
    //    return new TestBean();
    //}

}
