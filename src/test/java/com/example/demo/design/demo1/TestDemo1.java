package com.example.demo.design.demo1;

import com.example.design.demo1.RewardStrategyContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDemo1 {

    @Autowired
    private RewardStrategyContext context;

    @Test
    public void test(){
        //RewardStrategyContext context = new RewardStrategyContext(applicationContext);
        context.getStrategy("food").issue("food reward....");
        context.getStrategy("hotel").issue("hotel reward....");
        context.getStrategy("waimai").issue("waimai reward....");
    }
}
