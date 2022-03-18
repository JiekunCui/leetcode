package com.example.design.demo1.service;

import com.example.design.demo1.vo.HotelRequest;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    public void payCoupon(HotelRequest request){
        System.out.println(request.getParam());
    }
}
