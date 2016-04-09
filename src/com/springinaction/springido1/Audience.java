package com.springinaction.springido1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Audience {
	public void takeSeats(){
		System.out.println("Take seats.");
	}
	public void turnOffCellphone(){
		System.out.println("Turn off cellphone.");
	}
	public void applaud(){
		System.out.println("Applaud..");
	}
	public void demandRefund(){
		System.out.println("Refund");
	}
	public void watchPerformance(ProceedingJoinPoint joinpoint){
		try{
			takeSeats();
			turnOffCellphone();
			
			long startTime = System.currentTimeMillis();
			joinpoint.proceed();
			long endTime = System.currentTimeMillis();
			System.out.println("Performance time: " + (((double)endTime-(double)startTime)/1000) +"s.");
			this.applaud();
			this.demandRefund();
		}catch(Throwable t){
			System.out.println("Performace fail..");
		}
	}
}
