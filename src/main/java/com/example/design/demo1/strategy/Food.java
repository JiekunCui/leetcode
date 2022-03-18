package com.example.design.demo1.strategy;

import com.example.design.demo1.RewardStrategy;
import com.example.design.demo1.service.FoodService;
import com.example.design.demo1.vo.FoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("food")
public class Food implements RewardStrategy {

    @Autowired
    private FoodService foodService;

    @Override
    public void issue(Object param) {
        FoodRequest foodRequest = new FoodRequest();
        foodRequest.setParam(param);
        foodService.sendPrize(foodRequest);
    }
}
