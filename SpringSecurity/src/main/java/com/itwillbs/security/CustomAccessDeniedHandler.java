package com.itwillbs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

// 접근권한 없는 사용자가 접근시 에러 처리 객체
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	private static final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		logger.info(" CustomAccessDeniedHandler_handle() 실행 ");
		
		// 예외처리
		response.sendRedirect("/accessErr");
	}
	
	
	
	
}
