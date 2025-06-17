package com.itwillbs.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
public class MemberTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
	@Inject
	private DataSource ds;
	@Inject
	private PasswordEncoder pwEncoder;
	
	//디비 연결해서 계정 정보 생성
	//@Test
	public void insertMemberTest() throws Exception {
		
		String sql = "insert into tbl_member(userid,userpw,username,useremail) values(?,?,?,?)";
		
		for(int i=0;i<100;i++) {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(2, pwEncoder.encode("pw"+i));
			
			if(i < 80) {
				pstmt.setString(1, "user"+i);
				pstmt.setString(3, "일반사용자"+i);
				pstmt.setString(4, "user"+i+"@itwill.com");
			}else if(i < 90) {
				pstmt.setString(1, "manager"+i);
				pstmt.setString(3, "매니저"+i);
				pstmt.setString(4, "manager"+i+"@itwill.com");
			}else {
				pstmt.setString(1, "admin"+i);
				pstmt.setString(3, "관리자"+i);
				pstmt.setString(4, "admin"+i+"@itwill.com");
			}
			
			pstmt.executeUpdate();
			logger.info(" sql 실행완료! ");
			
			
		}// for
		
		
		
	}
	
}
