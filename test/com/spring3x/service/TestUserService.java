package com.spring3x.service;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring3x.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestUserService {
	@Autowired
	private UserService userService;
	@Test
	public void hasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "1111");
		assertTrue(b1);
		assertTrue(!b2);
	}
	@Test
	public void findUserByUserName(){
		User user = userService.findUserByUserName("admin");
	}
	@Test
	public void loginSuccess(){
		User user = userService.findUserByUserName("admin");
		System.out.println(user.getUserName());
		user.setLastIp("127.0.0.1");
		Date lastVisit = new Date(System.currentTimeMillis());
		user.setLastVisit(lastVisit);
		userService.loginSuccess(user);
		
	}
}
