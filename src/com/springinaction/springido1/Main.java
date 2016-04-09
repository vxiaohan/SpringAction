package com.springinaction.springido1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/springinaction/springido1/spring-ido1.xml");
		Performer performer = (Performer) ctx.getBean("instrumentalist");
		performer.perform();
	}
}
