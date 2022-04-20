package com.example.spring.importlearn;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public MyImportBeanDefinitionRegistrar() {
        System.out.println("MyImportBeanDefinitionRegistrar.constructor----");
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        System.out.println("MyImportBeanDefinitionRegistrar.registerBeanDefinitions-0----");
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("MyImportBeanDefinitionRegistrar.registerBeanDefinitions-1----");
    }
}
