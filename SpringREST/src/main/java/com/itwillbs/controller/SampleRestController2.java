package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
// => 주소에 따른 뷰페이지 연결
// @RestController
// => 주소에 따른 리소스(데이터) 연결
// => 스프링 4버전 이상 사용가능
// =>> 안에 작성되는 모든 메서드는 
//      @ResponseBody을 포함한다 라고 생성

@RestController
public class SampleRestController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleRestController2.class);
	
	//  @ResponseBody 생략됨
	@RequestMapping(value = "/sample1",method = RequestMethod.GET)
	public /*String*/int sample1() {
		logger.info(" /sample1 호출 ");
		
		// JSON이 지원가능한 데이터 타입을 표현가능
		// 정수, 실수, boolean, null, String, 객체, 배열
		
		//return "ITWILL";
		return 1000;
	}
	
	//  @ResponseBody 생략됨
	@RequestMapping(value = "/sample2",method = RequestMethod.GET)
	public MemberVO sample2() {
		logger.info(" /sample2 호출 ");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		
		// MemberVO -> JSON타입 객체 전환
		return vo;
	}
	
	//  @ResponseBody 생략됨
	@RequestMapping(value = "/sample3",method = RequestMethod.GET)
	public List<MemberVO> sample3() {
		logger.info(" /sample3 호출 ");
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		for(int i=0;i<5;i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("admin"+i);
			vo.setUserpw("1234"+i);
			
			memberList.add(vo);
		}
		
		// MemberVO -> JSON타입 객체 전환
		return memberList;
	}

	//  @ResponseBody 생략됨
	@RequestMapping(value = "/sample4",method = RequestMethod.GET)
	public Map<Integer,MemberVO> sample4() {
		logger.info(" /sample4 호출 ");

		Map<Integer,MemberVO> memberMap 
		     = new HashMap<Integer, MemberVO>(); 
		
		for(int i=0;i<5;i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("admin"+i);
			vo.setUserpw("1234"+i);
			
			memberMap.put(i, vo);
		}
		// MemberVO -> JSON타입 객체 전환
		return memberMap;
	}
	
	
	// http://localhost:8088/sample5
	// http://localhost:8088/sample5?no=100
	// http://localhost:8088/sample5/99999
	
	//https://www.coupang.com/vp/products/6440243339?
	
	// * REST API의 주소 : /객체/요소값/객체   주소길이 사용 권장
	//   /itwillbs/6/students 
	//   => 아이티윌에 6강의장에 있는 학생들 
	//   /itwillbs/student/10
	//   => 아이티윌에 있는 학생중에서 학생번호가 10번인 학생
	//   /itwillbs/6/student/17   (권장X => 기능 분리를 고려)
	//   => 아이티윌에 6강의장에 학생중에서 학생번호가 17번인 학생
	
	// https://learn.microsoft.com/ko-kr/azure/architecture/best-practices/api-design
	
	// 주소 : /sample/{변수명}
	// @PathVariable( 주소에 매핑된 변수이름 ) 변수 
	// => 주소줄에 데이터를 전달
	
	@RequestMapping(value = "/sample5/{num}",method = RequestMethod.GET)
	public int sample5( @PathVariable("num") int num			
	/* @RequestParam(
	 * value = "no"
	 * ,required = false
	 * ,defaultValue = "10000") int no */
			) {
		logger.info(" sample5() 실행 ");
		
		//return 1000;
		//return no;
		return num;
	}
	
	
	
	
	
	
}
