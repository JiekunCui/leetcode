package com.example.demo;

import com.example.demo.event.UserModPasswordEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private	ApplicationEventPublisher publisher;

	@Test
	void contextLoads() {
	}

	@Test
	void testEvent(){
		UserModPasswordEvent e = new UserModPasswordEvent();
		e.setUserId(1L);
		e.setNewPwd("12345");
		e.setOldPwd("abcdef");

		System.out.println(Thread.currentThread().getId());
		publisher.publishEvent(e);
		System.out.println("testEvent-->end");
		//UserRegisterEvent event = new UserRegisterEvent();

	}
}
