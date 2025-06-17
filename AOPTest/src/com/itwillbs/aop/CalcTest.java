package com.itwillbs.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {
	
	public static void main(String[] args) {
		
		System.out.println(" 일반 계산 사용 ");
		MyCalculator cal = new MyCalculator();
		cal.add(100, 200);
		cal.mul(200, 4);
		
		System.out.println(" AOP 적용후 계산 사용 ");
		
		// AOP.xml 정보를 불러오기
		ApplicationContext CTX
		 = new ClassPathXmlApplicationContext("AOP.xml");
		
		MyCalculator cal2 = (MyCalculator)CTX.getBean("proxyCal");
		
		cal2.add(200, 400);
		
	}
}
