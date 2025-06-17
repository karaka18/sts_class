package com.itwillbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@GetMapping(value = "/test1")
	public void test1() {	}
	
	@GetMapping(value = "/test2")
	public void test2() {	}
	
	@GetMapping(value = "/test3")
	public void test3() {	}
	
	@GetMapping(value = "/string1")
	public void string1() {	}
	
	@RequestMapping(value = "/rest1")
	public String restTest(Model model) {
		
		// REST 컨트롤러 호출 
		// /rest/data1 주소 (리소스) 호출
		
		//RestTemplate : Spring Framework제공 객체
		// => HTTP클라이언트로, Restful API를 호출하도록 도와주는 클래스
		//    (서버간의 통신을 사용하기위한 목적)
		//   HTTP요청 (GET/POST/PUT/DELETE) 가능
		
		RestTemplate restTemplate = new RestTemplate();
		
		// http://localhost:8088/rest1  (일반컨트롤러 호출)
		String result 
		 = restTemplate.getForObject("http://localhost:8088/rest/data1", String.class);
		// * 주소(URL)은 절대 주소를 사용해야함
		
		// GET방식 호출에 대한 처리
		//restTemplate.getForObject(url, responseType); (객체로 리턴)
		//restTemplate.getForEntity(url, responseType); (ResponseEntity로 리턴)
		
		// POST방식 호출에 대한 처리
		//restTemplate.postForObject(url, responseType); (객체로 리턴)
		//restTemplate.postForEntity(url, responseType); (ResponseEntity로 리턴)
		
		
		logger.info("result : {}",result);
		
		model.addAttribute("result", result);
		//return "home";
		// return "redirect:/rest/data1"; (리소스를 브라우저로 확인)
		return "home";
	}
	
	
	
	
	
	
}
