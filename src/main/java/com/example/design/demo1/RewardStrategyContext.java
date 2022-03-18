package com.example.design.demo1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class RewardStrategyContext{

    private static Map<String,RewardStrategy> stretegyMap = new HashMap<>();

    public RewardStrategyContext(ApplicationContext ac) throws BeansException {
        stretegyMap = ac.getBeansOfType(RewardStrategy.class);
    }

    public RewardStrategy getStrategy(String rewardType){
        return stretegyMap.get(rewardType);
    }
}
