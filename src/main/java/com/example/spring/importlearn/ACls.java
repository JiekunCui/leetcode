package com.example.spring.importlearn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ACls implements IA {

    public ACls() {
        System.out.println("ACls constructor");
    }

    @Autowired
    private IB bCls;

    @Override
    public void method() {

    }
}
