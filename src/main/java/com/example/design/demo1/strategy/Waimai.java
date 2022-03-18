package com.example.design.demo1.strategy;

import com.example.design.demo1.RewardStrategy;
import com.example.design.demo1.service.WaimaiService;
import com.example.design.demo1.vo.WaimaiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("waimai")
public class Waimai implements RewardStrategy {

    @Autowired
    private WaimaiService waimaiService;

    @Override
    public void issue(Object param) {
        WaimaiRequest waimaiRequest = new WaimaiRequest();
        waimaiRequest.setParam(param);
        waimaiService.issueWaimai(waimaiRequest);
    }
}
