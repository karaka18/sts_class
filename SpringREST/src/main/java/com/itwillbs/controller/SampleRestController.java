package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleRestController {

	private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);
	
	@RequestMapping(value = "/itwill1",method = RequestMethod.GET)
	public void itwill1() {
		logger.info(" /itwill1 호출 ");
		logger.info(" /views/itwill1.jsp 페이지 연결 ");
	}
	 
	@RequestMapping(value = "/itwill2",method = RequestMethod.GET)
	public String itwill2() {
		logger.info(" /itwill2 호출 ");
		
		logger.info(" /views/itwill.jsp 페이지 연결 ");
		
		return "itwill";
	}
	
	// http://localhost:8088/itwill3
	@RequestMapping(value = "/itwill3",method = RequestMethod.GET)
	public int itwill3() {
		logger.info(" /itwill3 호출 ");
		logger.info(" /views/1000.jsp 페이지 연결 ");
		return 1000;
	}
	
	// http://localhost:8088/itwill4
	@RequestMapping(value = "/itwill4",method = RequestMethod.GET)
	public @ResponseBody double itwill4() {
		// @ResponseBody 리턴되는 데이터를 JSON형태로 전환
		//  (+jackson-databind 라이브러리 필요)
		
		logger.info(" /itwill4 호출 ");
		return 1000.00001;
	}
	
	// http://localhost:8088/itwill5
	@ResponseBody
	@RequestMapping(value = "/itwill5",method = RequestMethod.GET)
	public double itwill5() {
		// @ResponseBody 리턴되는 데이터를 JSON형태로 전환
		//  (+jackson-databind 라이브러리 필요)
		
		logger.info(" /itwill5 호출 ");
		return 1000.00001;
	}
	
}
