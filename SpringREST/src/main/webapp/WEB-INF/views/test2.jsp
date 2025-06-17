<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- jQuery CDN 추가 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<!-- bxslider 라이브러리 추가 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bxslider@4.2.17/dist/jquery.bxslider.min.css">
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/bxslider@4.2.17/dist/jquery.bxslider.min.js"></script>

	<script>
      $(document).ready(function(){
        $(".slider").bxSlider();
      });
    </script>



<script type="text/javascript">
	$(document).ready(function(){
		//alert(" 테스트 ! ");
		
		// jquery 이벤트 : 사용자가 웹(브라우저)에서 수행하는 모든 동작
		
		$('input').bind("click",function(){
			// bind() 1.7 이후에는 사용X
			// alert('클릭2');
			
		});
		
		$('input').click(function(){
			alert("클릭3");
		});
		
		$('input').on("click",function(){
			// on() 1.7 이후에는 사용O / 모든 이벤트 처리가능
			alert("클릭4");
		});
		
		$("h2").click(function(){
			//alert("h2 클릭");
			$(this).html(function(idx,oldhtml){
				return oldhtml + "+";
			});
			
			
		});
		
		
		
	});
</script>



</head>
<body>
	<h2>test2.jsp</h2>
	
	<input type="button" value="버튼1" onclick=" alert('클릭'); ">
	
	<hr>
	<div id="div1">
		<h2>head-0</h2>
		<h2>head-1</h2>
		<h2>head-2</h2>
		<h2>head-3</h2>
		<h2>head-4</h2>
	</div>
	
	<hr>
	<div id="div2">
		<img src="/resources/img/1.png" widt="50" height="50">
	</div>
	
	<script type="text/javascript">
		$(function(){
			// 이미지 태그에 마우스를 올렸을때 이미지를 변경
			$("#div2 img").click(function(){
				alert("!!");
			});
			
			$("#div2 img").mouseover(function(){
				//alert("@@");
				$(this).attr("src","/resources/img/2.png");
			});
			
			// 마우스가 이미지 밖으로 이동시 원래 이미지로 변경
			$("#div2 img").mouseout(function(){
				$(this).attr("src","/resources/img/1.png");
			})
			
			
			
		});
	</script>
	
	<hr>
	<div id="div3">
		<h2>200</h2>
		<textarea rows="5" cols="80"></textarea>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			
			// 사용자 키보드 입력시
			// textarea태그에 작성된 내용의 정보를 가져오기
			$("#div3 textarea").keyup(function(){
				// alert("@@");
				// val() : 해당 요소의 value값을 가져오기
				// alert($(this).val().length);
				var valueLen = $(this).val().length;
				var result = 200 - valueLen;
				//$("#div3 h2").html(200 - valueLen);
				$("#div3 h2").html(result);
				
				// 글자수 200자 이상일때 h2 글자색 red / 200자미만 black
				if(result <= 0){
					$("#div3 h2").css('color','red');
				}else{
					$("#div3 h2").css('color','black');
				}
				
			});
			
		});
	</script>

	<hr>
	
	<div id="div4">
		<h1> 열기, 닫기1 </h1>
		<div>
			<h1>제목1</h1>
			<p>내용1</p>
		</div>
		
		<h1> 열기, 닫기2</h1>
		<div>
			<h1>제목2</h1>
			<p>내용2</p>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('#div4 h1').click(function(){
				// alert(" 클릭! ");
				// hide() show() toggle()
				// slideToggle() fadeToggle();
				//$(this).hide();
				$(this).next().fadeToggle();
			});
		});
		
	</script>	
	
	<hr>
	
	<div class="slider">
		<div>I am a slide.</div>
		<div>I am another slide.</div>
	</div>
	
	<script>
      $(document).ready(function(){
        $(".slider").bxSlider();
      });
    </script>
	
</body>
</html>