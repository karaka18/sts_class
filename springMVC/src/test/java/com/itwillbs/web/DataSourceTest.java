package com.itwillbs.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *  디비연결정보를 저장한(root-context.xml) 객체(빈)를
 *  사용해서 디비 연결을 테스트 
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
// => 스프링 JUnit을 사용해서 테스트 하겠습니다.
//@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
//		)
// => 프로젝트의 설정정보를 저장(테스트에서 필요한 정보를 가져오기)

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	
	// 디비연결정보가 필요함 => 해당 객체를 의존하고있다.
	// Test객체 <-의존 관계->  디비연결정보 객체
	// => 객체 직접생성(x) 객체를 주입(O)
	
	// new DataSource();(X)
	
	// @Inject, @Autowired를 사용하면 필요한 객체가 있는곳
	// root-context.xml에서 해당하는 객체를 자동으로 연결
	
	//@Inject
	@Autowired
	private DataSource ds;
	
	@Test
	public void dsTest() throws Exception{
		System.out.println(" 객체가 있는지 (주입되었는지) 확인 ");
		System.out.println(ds);		
	}
	
	@Test
	public void dbConnectTest() throws Exception{
		
		Connection conn = ds.getConnection();
		
		System.out.println(" 연결 성공! ");
		
		System.out.println(conn);
		
	}
	
	
	
	

	
	
}
