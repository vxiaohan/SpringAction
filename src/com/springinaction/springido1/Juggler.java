package com.springinaction.springido1;

import org.springframework.stereotype.Component;

@Component
public class Juggler implements Performer{
	private int beanBags = 4;
	public Juggler(){
		
	}
	public Juggler(int beanBags){
		this.beanBags = beanBags;
	}
	public void perform(){
		System.out.println("Juggling " + beanBags + " beanBags.");
	}
}
