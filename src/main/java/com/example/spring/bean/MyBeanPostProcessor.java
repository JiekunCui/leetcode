package com.example.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanPostProcessor implements BeanPostProcessor{

    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor.constructor----");
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessAfterInitialization----" + beanName);
        if (bean instanceof User){
            ((User)bean).setName("BeanPostProcessor.After.setName");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization----" + beanName);
        if (bean instanceof User){
            ((User)bean).setName("BeanPostProcessor.Before.setName");
        }
        return bean;
    }

}
