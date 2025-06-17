<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.high_0{background: yellow;}
	.high_1{background: orange;}
	.high_2{background: pink;}
	.high_3{background: blue;}
	.high_4{background: purple;}
</style>

<!-- (실제 파일) jquery 라이브러리 불러오기 -->
<script src="/resources/jquery/jquery-3.7.1.min.js"></script>

<!-- jquery CDN (네트워크로 라이브러리 받아오기) -->
<!-- <script src="https://code.jquery.com/jquery-3.7.1.js" 
 integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" 
 crossorigin="anonymous"></script> -->

<script type="text/javascript">
	$(document).ready(function(){
		//alert(" 1. Jquery 실행! ");
	});

	$(function(){
		//alert(" 2. Jquery 실행! ");
	});
	
	jQuery(document).ready(function(){
		//alert(" 3. Jquery 실행! ");
	});
	
	jQuery(function(){
		//alert(" 4. Jquery 실행! ");
	});
	
	// https://flukeout.github.io/
	$(function(){
		// 선택자
		$("*").css('color','blue'); // 모든 요소
		$("h2").css('color','red'); // 해당 모든태그 요소
		$("h2#t1").css("color","orange");  //해당 아이디를 가진 요소
// 		$("#t1").css("color","orange");  //해당 아이디를 가진 요소
		$("h2.t2").css("color","green");  //해당 클래스명을 가진요소
// 		$(".t2").css("color","green");  //해당 클래스명을 가진요소

		$("input[type=text]").css("color","pink");
		$("input[type=password]").css("color","purple");
		$("input[type ^= p]").css("color","red");
		// 태그[ 속성 ^= 값 ] 시작값   태그[ 속성 $= 값 ] 끝값
		// 태그[ 속성 ~= 값 ] 포함하는 값
		
		
		//$("table").css("background","yellow");
		//$("tr").css("background","yellow");
		//$("td").css("background","yellow");
		
		$("tr:first").css("background","yellow");
		$("tr:last").css("background","yellow");
		
		$("tr:odd").css("background","red"); // 홀
		$("tr:even").css("background","blue"); // 짝
	});
	
	
	

</script>


</head>
<body>
	<h1>test1.jsp</h1>
	<h1> JQuery : 자바스크립트 라이브러리 </h1>
	
	<h2 id="t1"> 제목1 </h2>
	<h2 class="t2"> 제목2 </h2>
	
	<hr>
	
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="pw"><br>
	
	<hr>
	<table border="1">
	   <tr>
	      <td>1</td><td>1</td><td>1</td>
	   </tr>
	   <tr>
	      <td>1</td><td>1</td><td>1</td>
	   </tr>
	   <tr>
	      <td>1</td><td>1</td><td>1</td>
	   </tr>
	   <tr>
	      <td>1</td><td>1</td><td>1</td>
	   </tr>
	   <tr>
	      <td>1</td><td>1</td><td>1</td>
	   </tr>
	</table>
	
	<hr>
	
	<div id="div1">
		<h2>head-0</h2>	
		<h2>head-1</h2>	
		<h2>head-2</h2>	
	</div>
	<script type="text/javascript">
		$(function(){
			
			//div1 태그에 있는 h2 태그에 접근
			$("#div1 h2").css("color","blue");
			
			// 해당요소의 속성값을 가져오기
			var c = $("#div1 h2").css("color");
			alert(" c : "+c);
			
			// 해당요소(ALL)의 속성값을 특정값으로 변경 (글자색 초록색)
			$("#div1 h2").css("color","green");
			
			// h2의 속성(컬러)을 각각 다른색으로 변경
			var colorArr = ["red","orange","yellow"];
			
// 			for(var i=0;i<colorArr.length;i++){
// 				$("#div1 h2").css("color",colorArr[i]);				
// 			}
			$("#div1 h2").css("color",function(idx,value){
				// 해당하는 모든 요소에 순차적으로 접근해서 
				//  요소의 인덱스번호와 값을 얻을수 있음
				
				//alert(idx+"//"+value);
				
				// 리턴해서 color 속성값으로 적용
				//return "red";
				return colorArr[idx];
			});		
			
			$("#div1 h2").css("color","black");
			
			// div1 h2 태그에 배경색(backgroundColor) - 검정(black)
			//  글자색은 colorArr 배열의 값으로 설정
			
// 			$("#div1 h2").css("backgroundColor","black");
// 			$("#div1 h2").css("color",function(idx,value){
// 				return colorArr[idx];
// 			});	
			
			// 한번에 여러개의 속성값을 변경
			// 			$(요쇼).함수({
			// 				"속성1":"값1",
			// 				"속성2":"값2",
			// 				....
			// 				"속성n":"값n"
			// 			});
			
			$("#div1 h2").css({
				"backgroundColor" : "black",
				"color" : function(idx,value){
					return colorArr[idx];
				}
			});
			
		});
	</script>
	
	
	<hr>
	
	<div id="div2">
		<img src="/resources/img/1.png" width="100"> 
		<img src="/resources/img/2.png" width="100">
		<img src="/resources/img/3.png" width="100">	
	</div>
	
	<script type="text/javascript">
	  $(document).ready(function(){
		 //이미지 태그의 src 속성값 출력
		 var src = $("#div2 img").attr("src");
		//alert("src : "+src);
		
		// 이미지의 주소를 전부 3번 이미지로 변경
		$("#div2 img").attr("src","/resources/img/3.png");
		
		// 모든 이미지태그에 border 설정 5,10,15 설정
				
		//$("#div2 img").attr("border",5);
		$("#div2 img").attr("border",function(idx){
			return (idx+1)*5;
		});
		
		// 모든 이미지태그의 border 10 설정, width 50, 100, 150 설정
		$("#div2 img").attr({"border":10, "width" : function(idx){
				return (idx+1) * 50;
			}
		});
		
		
		  
	  });
	</script>
	
	<hr>
	
	
	
	<div id="div3">
		<h2>head-0</h2>
		<h2>head-1</h2>
		<h2>head-2</h2>
	</div>
	
	<script type="text/javascript">
		$(function(){
			// div3 h2 태그의 글 내용을 가져와서 출력
			
			var html = $("#div3 h2").html();
			// => 해당요소 중에서 가장 처음의 값만 가져오기
			//alert("html : " + html);
			
			var text = $("#div3 h2").text();
			// => 해당요소 중에서 모든 요소의 값을 가져오기
			//alert("text : "+text);
			
			// "아이티윌부산" 내용을 변경(html,text)
			$("#div3 h2").html("아이티윌부산h");
			$("#div3 h2").text("아이티윌부산t");
			// => 일반 텍스트는 차이없음
			
			$("#div3 h2").html("<h1>아이티윌부산h</h1>");
			// => 태그 적용되어서 화면에 표시
			
			//$("#div3 h2").text("<h1>아이티윌부산t</h1>");
			// => 문자 그대로 화면에 표시 
			
			// h2태그 뒤에 '교육센터' 메세지를 추가 
			// "아이티윌부산t"
			// "<h1>교육센터</h1>"
			
			//$("#div3 h2").text("아이티윌부산t").after("<h1>교육센터</h1>");
			
			$("#div3 h2").html(function(idx,oldhtml){
				//alert(idx+"//"+oldhtml);
				return oldhtml+"<h1>교육센터</h1>"
			});
			
			
			
		});
	</script>
	
	<div id="div4">
		
		<div>내용</div>
		<div>내용</div>
		<div>내용</div>
		
		<hr>
		
		<table border="1">
			<tr>
				<td>이름</td>
				<td>지역</td>
			</tr>
		</table>
	
	</div>

	
	<script type="text/javascript">
		$(document).ready(function(){
			// 내용을 요소의 앞/뒤에 추가(html코드 적용)
			$("#div4").append("<h1> append 추가 </h1>");
			$("#div4").prepend("<h1> prepend 추가 </h1>");
			
			// 테이블에 행을 추가
			// => table태그에 append()해야만 행을 추가할 수 있음
			$("#div4 table").append("<tr><td>홍길동</td><td>부산</td></tr>");
			
			// 2차원 배열표현
			var data = [
				{ "name":"학생1", "region":"부산" },
				{ "name":"학생2", "region":"서울" },
				{ "name":"학생3", "region":"대구" },
				{ "name":"학생4", "region":"제주" },
				{ "name":"학생5", "region":"세종" }
			];
			
			//$("#div4 table").append("<tr><td>"+data[0].name+"</td><td>"+data[0].region+"</td></tr>");
			//$("#div4 table").append("<tr><td>"+data[1].name+"</td><td>"+data[1].region+"</td></tr>");
			
			for(var i = 0;i<data.length;i++){
				$("#div4 table").append("<tr><td>"+data[i].name+"</td><td>"+data[i].region+"</td></tr>");
			}
			
			////////////////////////////////////////////////////////////////////////////
			// $.each(); $(값).each();
			$.each(data,function(idx,value){
				//alert(idx+"/"+value);
				//alert(value);
				//console.log(value);
				$("#div4 table").append("<tr><td>"+value.name+"</td><td>"+value.region+"</td></tr>");
				
				var tag = "<tr>";
					tag += "<td>"+value.name+"</td>";
					tag += "<td>"+value.region+"</td>";
					tag += "</tr>";
					
				$("#div4 table").append(tag);
				
			});
			
			
		});
	</script>
	
	<div id="div5">
		<!-- .high_0~4 -->
		<!-- <h2 class="high_0">head-0</h2>
		<h2 class="high_1">head-1</h2>
		<h2 class="high_2">head-2</h2>
		<h2 class="high_3">head-3</h2>
		<h2 class="high_4">head-4</h2> -->
		<h2>head-0</h2>
		<h2>head-1</h2>
		<h2>head-2</h2>
		<h2>head-3</h2>
		<h2>head-4</h2>
	</div>
	
	<script type="text/javascript">
		$(function(){
			//$("#div5 h2").css("background","white");
			
			/* for(var i = 0;i<5;i++){
				$("#div5 h2").addClass("high_"+i);
			} */
			
			$("#div5 h2").each(function(index){
				//$("#div5 h2").addClass("high_"+index);
				$(this).addClass("high_"+index);
				// this : 객체 자기 자신을 의미하는 레퍼런스
				// 	  * 해당 이벤트가 수행하는 요소를 의미
				
			});
			
		});
	</script>
	
	
	<hr>
	<div id="div6">
		<img src="/resources/img/1.png" width="100" height="100">
		<img src="/resources/img/2.png" width="100" height="100">
		<img src="/resources/img/3.png" width="100" height="100">
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			setInterval(console.log('Hello!'),1000);	
			setInterval(function(){
				//console.log('Hello!');
				$("#div6").append( $("#div6 img").first() );
				
			},1000);
			
			//clearInterval(tmp);

		});
	</script>

</body>
</html>