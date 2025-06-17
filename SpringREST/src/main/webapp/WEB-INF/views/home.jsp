<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	JQuery 연습하기!  (home.jsp)
</h1>

  
  <input type="button" value="REST호출(회원정보 전달)">

<!-- jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//alert(" jQuery 준비 완료! ");
		
		$("input").click(function(){
			//alert(" 클릭! ");
			// 비동기방식 ajax 사용해서 페이지 호출
			
// 			$.ajax({
// 				url:"/rest/data1",
// 				type:"get",
// 				success : function(data){
// 					alert(" ajax 성공! ");
// 					alert(data);
// 				}
// 			});ajax
			
			//  /rest/data2?bno=99
// 			$.ajax({
// 				url : "/rest/data2",
// 				type : "GET",
// 				data : { "bno" : 99 },
// 				success : function(data){
// 					alert("data2 성공!");
// 					$("body").append("<h1>"+data+"</h1>");
					
// 				},
// 				error : function(){
// 					alert("에러 발생!");
// 				}
// 			}); //ajax

			// MemberVO 객체 데이터를 전송
			// => JSON 객체로 표현
			var member = {
				//"userid":$('요소').val();,
				"userid":"admin",
				"userpw":"1234",
				"username":"관리자",
				"useremail":"admin@admin.com"
			};
			
			$.ajax({
				url : "/rest/data3",
				// type : "GET", (X - RESTful API 설계 위반)
				type: "POST", 
				contentType : "application/json",
				// 객체는 http body에 저장되어야함
				//data : member,
				//data : JSON.stringify(member), 객체 JSON문자열로 변경
				data : JSON.stringify(member),
				success : function( data ){
					alert(" data3 성공! ");
					alert(data);
					// $("body").append(data);
					// => JSON객체는 한번에 출력불가능
					console.log(data);
					$("body").append("<hr>");
					$("body").append(data.userid);
					$("body").append("<hr>");
					$("body").append(data.userpw);
					$("body").append("<hr>");
					$("body").append(data.username);
					$("body").append("<hr>");
					$("body").append(data.useremail);
					$("body").append("<hr>");
					
				}
				
			});
			
		});// click
		
	}); // jquery

</script>

  <hr>
  <h2>result : ${result }</h2>
	


</body>
</html>
