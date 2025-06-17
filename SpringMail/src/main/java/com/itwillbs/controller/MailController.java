package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.service.MailService;

// http://localhost:8088/controller/sendMail

@Controller
@EnableAsync
public class MailController {
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	// 메일 서비스객체를 주입
	@Inject
	private MailService mailService;
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
	public String sendMail(HttpServletResponse response) throws Exception{
		logger.info(" sendMail() 실행 ");
		
		String subject = " 테스트 메일 제목입니다. ";
		String to = "hhsky1114@gmail.com";
		// String text = "테스트 내용 메세지!!";
		StringBuffer sb = new StringBuffer();
		// String : abc -> toUpperCase() -> String : abc
//		str += "<html>";
//		str += "</html>";
		// StringBuffer : abc -> toUpperCase() -> StringBuffer : ABC
		sb.append("<html>");
		sb.append("<head></head>");
		sb.append(" <body>");
		sb.append(" <h1> 안녕하세요! 아이티윌 메일 입니다! </h1>");
		sb.append(" <a href='https://www.itwillbs.co.kr'>");
		sb.append(" 	<img src='https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg'>");
		sb.append(" </a>");
		sb.append("</body>");
		sb.append("</html>");
		
		
		
		
		
		
		mailService.sendMail(subject, to, sb.toString());
		
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().append("<h1> 메일 테스트 완료! </h1>");
		
		
		logger.info(" sendMail() 끝 ");
		
		return "redirect:/sendResult";
	}
}
