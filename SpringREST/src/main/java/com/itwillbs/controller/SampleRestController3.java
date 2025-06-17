package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/*")
public class SampleRestController3 {

	private static final Logger logger = LoggerFactory.getLogger(SampleRestController3.class);

	@RequestMapping(value = "/data1",method = RequestMethod.GET)
	public String restData1() {
		logger.info(" restData1() 실행 ");
		
		return "ITWILL";
	}
	
	// /rest/data2?bno=99
	
	@RequestMapping(value = "/data2",method = RequestMethod.GET)
	public String restData2(@ModelAttribute("bno") int bno) {
		logger.info(" restData2() 실행 ");
		// 전달정보 파라메터 받아서 처리(계산)
		logger.info(" bno : "+bno);
		logger.info(" bno : {} ",bno);
		// 서비스 -> DAO 호출
		
		return "ITWILL"+bno;
	}
	
	//@RequestMapping(value = "/data3",method = RequestMethod.GET)
	// GET방식일때는 파라메터 정보를 받을수 있음
	// => REST API설계 위반 (GET방식으로는 객체를 전달X)
	//    객체는 반드시 http body에 저장되어야 함
	//  =>> 객체를 전달할때는 반드시 POST방식
	
	@RequestMapping(value = "/data3",method = RequestMethod.POST)
	public  MemberVO/*String*/ restData3(@RequestBody MemberVO vo) {
		logger.info(" restData3() 실행 ");
		// 파라메터 형태로 전달된 객체를 저장
		logger.info(" vo : {}",vo);
		
		//return "ITWILL";
		return vo;
	}
	
	// http://localhost:8088/rest/err1
	@RequestMapping(value = "/err1",method = RequestMethod.GET)
	public ResponseEntity<Void> sendStatus1(){
		// 결과는 없는, 상태만 전달
		logger.info(" sendStatus1() 실행 ");
		return new ResponseEntity<Void>(HttpStatus.OK); //200
	}
	
	// http://localhost:8088/rest/err2
	@RequestMapping(value = "/err2",method = RequestMethod.GET)
	public ResponseEntity<String> sendStatus2(){
		logger.info(" sendStatus2() 실행 ");
		
		//return new ResponseEntity<String>("itwill",HttpStatus.OK); //200
		return new ResponseEntity<String>("itwill",HttpStatus.BAD_REQUEST); //400
	}
	
	// http://localhost:8088/rest/err3
	@RequestMapping(value = "/err3",method = RequestMethod.GET)
	public ResponseEntity<MemberVO> sendStatus3(){
	    // ResponseEntity<List<MemberVO>>
		// ResponseEntity<Map<Key,Value>>
		logger.info(" sendStatus3() 실행 ");
		
		// 임시 객체 생성 (나중엔 서비스 메서드 호출)
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		
		ResponseEntity<MemberVO> respEntity = null;
		
		if(vo == null) {
			respEntity = new ResponseEntity<MemberVO>(vo,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			respEntity = new ResponseEntity<MemberVO>(vo,HttpStatus.OK);
			
		}
		
		return respEntity;
		
		//return new ResponseEntity<MemberVO>(vo,HttpStatus.NOT_FOUND); //404
	}
	
	// http://localhost:8088/rest/err4
	@RequestMapping(value = "/err4",method = RequestMethod.GET)
	public ResponseEntity sendStatus4(){
		logger.info(" sendStatus4() 실행 ");
		
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.add("Content-Type", "text/html; charset=UTF-8");
		
		String msg = "<script>";
			msg += "	alert(' 출력! ');";
			//msg += " 	location.href='test'; ";
			msg += "</script>";
		
		return new ResponseEntity(msg,respHeaders,HttpStatus.METHOD_NOT_ALLOWED); //404
	}
	
	
	
}// controller
