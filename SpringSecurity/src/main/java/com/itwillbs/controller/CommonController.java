package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	
	// 페이지 접근권한 없이 접근한경우 에러처리 페이지
	// /accessErr
	@RequestMapping(value = "/accessErr")
	public void accessDenied(Authentication auth,Model model) {
		logger.info(" accessDenied()실행 ");
		logger.info(" 접근권한 없는 페이지에 접근시도 ");
		
		logger.info("auth : {}",auth);
		
		model.addAttribute("auth", auth);
		
		// /views/accessErr.jsp  페이지 이동
	}
	
	
	// 커스텀 로그인페이지
	@RequestMapping(value = "/customLogin")
	public void customLoginPage() {
		logger.info(" customLoginPage() 실행 ");
		// 연결된 뷰페이지 이동
		// /views/customLogin.jsp
	}
	
	
	// 로그아웃
	@RequestMapping(value = "/customLogout")
	public void logoutGET() {
		logger.info(" logoutGET() 실행 ");
		
	}
	
	
	
	
	
	
}
