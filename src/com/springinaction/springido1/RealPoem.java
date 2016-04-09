package com.springinaction.springido1;

import org.springframework.stereotype.Component;

@Component
public class RealPoem implements Poem {

	@Override
	public void recite() {
		// TODO Auto-generated method stub
		System.out.println("This is a poem.");
	}

}
