<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		border: 1px solid black;
	}

</style>

<!-- jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

</head>
<body>
	<h1>test3.jsp</h1>
	
	<h1>호출주소 :  http://localhost:8088/test3 </h1>
	<h2> Ajax(Asynchronous JavaScript And Xml) : 
	     비동기방식의 자바스크립트와 XML
	</h2>
	<!-- 
	   동기 방식 : 사용자의 요청을 서버가 처리후 결과를 가지고 페이지 실행
	   비동기 방식 : 사용자 요청의 결과 상관없이 별도로 페이지 실행
	 -->
	
	<div id="div1"></div>
	
	<input type="text" id="id">
	
	<div id="div2"></div>
	<div id="div3">
		<h2>아이디 : </h2>
	</div>
	
	
	<script type="text/javascript">
		// 비동기 동작을 처리하는 메서드 $.ajax()
		
		$(function(){
			
			//$.each(요소,function); $(요소).each(function);
// 			$.ajax({
// 				url : 전송페이지(액션페이지),
// 				type : 전송방식(GET/POST),
// 				data : 전송할 데이터(액션페이지로 보낼 데이터),
//                      { 이름:값,이름:값,.... }
// 				dataType : 요청한 데이터타입 (결과, html/xml/json/text),
// 				success : function(data){ // 성공결과를 받아옴
// 					전송 성공시 실행할 코드
// 				},
// 				error : function(data){ // 실패결과를 받아옴
// 					전송 실패시 실행할 코드					
// 				}
// 			});		

		
		// 비동기방식으로 string1.jsp 페이지 호출
		$.ajax({
			//url : "/views/string1.jsp",
			//url : "/string1",
			url : "/ajax/string1.jsp",
			success : function(data){
				//alert(" 성공! ");
				//alert(data);
				$("#div1").append(data);
			},
			error : function(){
				alert(" 실패! ");
			}
		}); //ajax
		
		
		// 키보드 입력이 있을때 마다
		$("#id").keyup(function(){
			// 비동기 방식 제어 
			// string2.jsp 페이지에 정보를 전달+결과를 가져오기
			$.ajax({
				url : "/ajax/string2.jsp",
				type : "get",
				//data : {id:"admin"},
				data : {id:$(this).val()},
				success : function(data){
					//alert("2 성공!");
					//$("#div2").append(data);
					$("#div2").html(data);
					$("#div3 h2").append(data);
					
					
				},
				error : function(){
					alert("2 실패!");
				}
			});//ajax
			
		});//keyup
		}); //jquery
	
	</script>
	
	<hr>
	<h2> XML(eXtensible Markup Language) : 확장가능한 마크업 언어 </h2>
	<h2> HTML과 유사하게 생김(태그로 구성), 설명가능한 모든 정보를 저장 </h2>
	<h2> 모든 플랫폼에서 동작가능 (주로 데이터 송수신, (2000년초반)데이터 표준포멧)</h2>
	<student> 아이티윌 </student>
	
	<div id="div4"></div>
	
	<script type="text/javascript">
		$(function(){
			
			$.ajax({
				url : "/ajax/xml1.jsp",
				success : function(data){
					//alert(" xml 접근 완료! ");
					//alert(data);
					console.log(data);
					// xml데이터를 div4에 출력
					// $("#div4").append(data); 그냥사용X
					
					// xml데이터를 가공
					$(data).find('person').each(function(){
						//$(this).find('name'); //<name>학생1</name>
						var name = $(this).find('name').text(); //학생1
						//alert(" name : "+name);
						var gender = $(this).find('gender').text();
						var hobby = $(this).find('hobby').text(); 
						
						$("#div4").append(name+"/"+gender+"/"+hobby+"<hr>");
					});
					
				}				
			});//ajax
			
			
// 			$.ajax({
// 				url : "https://news-ex.jtbc.co.kr/v1/get/rss/section/70",
// 				success : function(){
// 					alert(" rss 성공! ");
// 				}
// 			}); //ajax
			
			
		});	//jquery
	</script>
	
	
	<h2> JSON (JavaScript Object Notation): 자바스크립트 객체 표현식 </h2>
	<h2> 최근 가장 많이 사용하는 데이터 포멧 </h2>
	
	<!-- 
	   장점 : HTML/XML보다 간결함 (단순텍스트 key-value쌍), 
	          다른 도메인에서 요청 가능,
	          대부분의 언어에서 json파서를 포함
	          
	   단점 : 자바스크립트 기반의 문법 사용(엄격함),
	          자바스크립트 문법에 대한 이해필요,
	          자바스크립트 코드를 포함가능(해킹가능성)
	          
	          
	   문법(규칙) : 
	     1) JSON 객체는  { } 중괄호
	     2) JSON 배열은  [ ] 대괄호
	     3) 데이터는  key:value 형태로 저장
	       - 속성(key)은 "" 묶어서 표시
	       - 값(value)은 데이터 타입에 따라서 변경
	       - 속성을 여러개 사용할경우 , 사용해서 구분
	     
	    - 사용가능한 데이터 타입
	      정수형(2진수(01010),8진수(000011),16진수(0x0010101) 사용X)
	      실수형(고정 소수점) 3.123  -15.65
	      실수형(부동 소수점) 1e4  2.5e12  2.7E-5
	      boolean 
	      Null
	      문자열 : "" 표시해야함(0개 이상의 유니코드로 구성)
	      배열 
	      객체 
	 -->
	<div id="div5"></div>
	<script type="text/javascript">
		$(document).ready(function(){
			
			// ajax로  json1.jsp 페이지에 다녀오기
			$.ajax({
				url : "/ajax/json1.jsp",
				success : function(data){
					alert("json 성공!");
					//alert(data);
					console.log(data);
					//$("#div5").append(data);
					//=> XML,JSON데이터는 원본데이터 그대로 HTML에 사용불가능
					$(data).each(function(key,value){
						 //$("#div5").append(key+"//"+value);
						 $("#div5").append(value.name+"//"+value.age+"//"+value.gender);
					});					
					
				}
				
			});
		});		
	</script>
	
	<hr>
	
	<div id="div6">
	
		<table border="1">
			<tr>
				<td>name</td>
				<td>age</td>
				<td>addr</td>
			</tr>		
		</table>
	
	</div>
	
	<script type="text/javascript">
		$(function(){
// 			$.ajax({
// 				url : "/ajax/json2.json", 
// 				success : function(data){
// 					alert("json2 성공");
// 				}								
// 			});	
			$.getJSON("/ajax/json2.json",function(data){
				$(data).each(function(idx,item){
						//console.log(item);
						// 테이블에 json 데이터를 출력
						
						var tag = "<tr>";
						tag += "<td>"+item.name+"</td>";
						tag += "<td>"+item.age+"</td>";
						tag += "<td>"+item.addr+"</td>";
						tag += "</tr>";
						
						$("#div6 table").append(tag);
				});				
			});
			
			
			
		});
	</script>
	
	
	
	
	
	
	
	
</body>
</html>