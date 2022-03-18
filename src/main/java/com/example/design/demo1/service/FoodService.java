package com.example.design.demo1.service;

import com.example.design.demo1.vo.FoodRequest;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    public void sendPrize(FoodRequest request){
        System.out.println(request.getParam());
    }
}
