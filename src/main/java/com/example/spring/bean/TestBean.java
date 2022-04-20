package com.example.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class TestBean{

    public TestBean() {
        System.out.println("TestBean.constructor----");
    }
    //
    //@Override
    //public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    //    System.out.println("TestBean.BeanFactoryAware.setBeanFactory----");
    //}
    //
    //@Override
    //public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    //    System.out.println("TestBean.BeanPostProcessor.postProcessAfterInitialization----");
    //    return bean;
    //}
    //
    //@Override
    //public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    //    System.out.println("TestBean.BeanPostProcessor.postProcessBeforeInitialization----");
    //    return bean;
    //}
    //
    //@Override
    //public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    //    System.out.println("TestBean.BeanFactoryPostProcessor.postProcessBeanFactory----");
    //}
}
