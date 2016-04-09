package com.springinaction.springido1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Instrumentalist implements Performer {
	public Instrumentalist(){
		
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Playing " + song + ":");
		instrument.play();
	}
	
	private String song;
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String screamSong(){
		return song;
	}

	@Autowired
	//@Qualifier("piano")
	@Qualifier("guitar")
	private Instrument instrument;

	/*
	public void setInstrument(Instrument instrument){
		this.instrument = instrument;
	}
	*/
}
