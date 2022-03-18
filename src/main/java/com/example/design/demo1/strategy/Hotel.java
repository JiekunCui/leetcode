package com.example.design.demo1.strategy;

import com.example.design.demo1.RewardStrategy;
import com.example.design.demo1.service.HotelService;
import com.example.design.demo1.vo.HotelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hotel")
public class Hotel implements RewardStrategy {

    @Autowired
    private HotelService hotelService;

    @Override
    public void issue(Object param) {
        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setParam(param);
        hotelService.payCoupon(hotelRequest);
    }
}
