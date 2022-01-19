package com.example.demo.service;

import com.example.demo.event.UserModPasswordEvent;
import com.example.demo.event.UserRegisterEvent;

public interface UserService {

    void modifyPwd(UserModPasswordEvent event);


    void register(UserRegisterEvent event);

    void setPwd(UserModPasswordEvent event);
}
