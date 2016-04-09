package com.springinaction.springido1;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing guitar...");
	}

}
