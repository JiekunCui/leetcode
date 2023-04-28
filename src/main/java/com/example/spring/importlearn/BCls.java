package com.example.spring.importlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BCls implements IB{
    public BCls() {
        System.out.println("BCls constructor");
    }

    @Autowired
    private IA aCls;

    @Override
    public void method() {

    }
}
