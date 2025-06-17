package com.itwillbs.service;

import java.io.IOException;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import com.itwillbs.controller.MailController;

@Service(value = "mailService")
public class MailService {
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	
	// mail-context.xml에서 객체정보 주입
	@Inject
	private JavaMailSender mailSender;
	
	@Async
	public void sendMail(String subject, String to, String text) {
		
			logger.info(" 메일 전송 기능 실행! ");
			MimeMessage message = mailSender.createMimeMessage();
			
			try {
				MimeMessageHelper msgHelper
						= new MimeMessageHelper(message, true,"UTF-8");
											// 메세지 객체, 멀티파트, 인코딩
				
				msgHelper.setSubject(subject); // 제목
				msgHelper.setTo(to); // 받는사람(String - 이메일 주소)
				// msgHelper.setCc(cc); // 참조
				// msgHelper.setFrom(from); // 보내는 사람
				// msgHelper.setText(text); // 본문내용
				msgHelper.setText(text, true); // 본문내용 + HTML코드 적용
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logger.info(" 메일 메세지 준비 완료 ");
			
			mailSender.send(message);
			
			logger.info(" 메일 메세지 전송완료!!! ");
			
			
		
			logger.info(" 메일 전송 기능 끝! ");
		
	}
	
	
	
}
