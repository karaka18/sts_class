package com.itwillbs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		logger.info(" CustomLoginSuccessHandler_onAuthenticationSuccess() 실행 ");
		
		logger.info(" 로그인 성공시 처리동작  ");
		// 로그인한 사용자의 정보에 따라서 페이지 이동
		
		// 접근권한 정보를 저장하는 리스트
		List<String> roleNames = new ArrayList<String>();
		
		// 로그인 성공한 사용자의 권한정보를 리스트에 저장
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
//		auth.getAuthorities().forEach(new Consumer<GrantedAuthority>() {
//			@Override
//			public void accept(GrantedAuthority authority) {
//				roleNames.add(authority.getAuthority());
//			}
//		});
		
		logger.info(" roleNames : {}",roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			logger.info(" 관리자 로그인 성공! ");
			response.sendRedirect("/sample/admin");
			return;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
			logger.info(" 일반 회원 로그인 성공! ");
			response.sendRedirect("/sample/member");
			return;
		}
		
		logger.info(" 그외 나머지(권한없는 사용자) 로그인 성공 ");
		response.sendRedirect("/sample/all");

	}

}
