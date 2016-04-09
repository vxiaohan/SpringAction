package com.springinaction.springido1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class Audience {
	@Pointcut("execution(* com.springinaction.springido1.Performer.perform())")
	public void performance(){
		
	}
	@Before("performance()")
	public void takeSeats(){
		System.out.println("Take seats.");
	}
	@Before("performance()")
	public void turnOffCellphone(){
		System.out.println("Turn off cellphone.");
	}
	@AfterReturning("performance()")
	public void applaud(){
		System.out.println("Applaud..");
	}
	@AfterThrowing("performance()")
	public void demandRefund(){
		System.out.println("Refund");
	}
	
	/*
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
	*/
}
