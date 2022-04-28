package com.example.demo;

import com.example.demo.event.UserModPasswordEvent;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private	ApplicationEventPublisher publisher;
	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	void testEvent(){
		UserModPasswordEvent e = new UserModPasswordEvent();
		e.setUserId(1L);
		e.setNewPwd("12345");
		e.setOldPwd("abcdef");

		userService.hashCode();

		System.out.println(Thread.currentThread().getId());
		publisher.publishEvent(e);
		System.out.println("testEvent-->end");
		//UserRegisterEvent event = new UserRegisterEvent();

	}
}
