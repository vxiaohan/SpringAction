package com.springinaction.springido1;

import org.springframework.stereotype.Component;

@Component
public class Harmonica implements Instrument {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing harmonica...");
	}

}
