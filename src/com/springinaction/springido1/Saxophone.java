package com.springinaction.springido1;

import org.springframework.stereotype.Component;

@Component
public class Saxophone implements Instrument {
	public Saxophone(){
		
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("TOOT TOOT TOOT");
	}

}
