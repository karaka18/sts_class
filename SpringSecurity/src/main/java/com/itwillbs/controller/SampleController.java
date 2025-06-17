package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/sample/*")
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	//http://localhost:8088/sample/all
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public void doAll() {
		logger.info(" doAll() 실행");
	}
	//http://localhost:8088/sample/member
	@RequestMapping(value = "/member",method = RequestMethod.GET)
	public void doMember() {
		logger.info(" doAll() 실행");
	}
	//http://localhost:8088/sample/admin
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public void doAdmin() {
		logger.info(" doAll() 실행");
	}
}
