package com.example.design.demo1.service;

import com.example.design.demo1.vo.WaimaiRequest;
import org.springframework.stereotype.Service;

@Service
public class WaimaiService {

    public void issueWaimai(WaimaiRequest request){
        System.out.println(request.getParam());
    }
}
