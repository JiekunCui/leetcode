package com.example.demo.service.impl;

import com.example.demo.event.UserModPasswordEvent;
import com.example.demo.event.UserRegisterEvent;
import com.example.demo.service.UserService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Override
    @EventListener
    public void modifyPwd(UserModPasswordEvent event) {
        System.out.println(Thread.currentThread().getId() + " modify password->" + event.toString());

    }

    @Override
    @EventListener
    public void register(UserRegisterEvent event) {
        System.out.println("register->" + event.toString());
    }

    @Override
    @EventListener
    public void setPwd(UserModPasswordEvent event) {
        System.out.println(Thread.currentThread().getId() + " set password->" + event.toString());
    }
}
