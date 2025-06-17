package com.itwillbs.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/* Advice */
public class LoggingAdvice implements MethodInterceptor{
	
	/* 보조기능 : 메세지 출력 */
	@Override
	public Object invoke(MethodInvocation inv) throws Throwable {
		
		System.out.println(" AOP 적용! ");
		System.out.println(" 출력문이 보조기능!(로깅,예외처리,트랜젝션,보안...." );
		
		System.out.println(" 주기능 이름 : "+inv.getMethod());
		System.out.println(" 주기능 실행전 출력동작 호출! ");
		
		// 주기능의 동작을 호출
		Object obj = inv.proceed();
		
		
		System.out.println(" 주기능 실행후 출력동작 호출! ");
		
		return obj;
		
		
		
		
	}
	
}
