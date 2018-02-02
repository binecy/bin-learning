package com.spring.start.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

	@Pointcut("execution(public * com.spring.start..*.*.*(..))")
	public void point() {

	}

	@Around("point()")
	public Object methodAroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("start...");
		Object result = joinPoint.proceed(joinPoint.getArgs());
		System.out.println("end...");
		return result;
	}


	@Around("execution(public * com.spring.start..*.*.*(..))")
	public Object methodAroundLog2(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("start2...");
		Object result = joinPoint.proceed(joinPoint.getArgs());
		System.out.println("end2...");
		return result;
	}




}
