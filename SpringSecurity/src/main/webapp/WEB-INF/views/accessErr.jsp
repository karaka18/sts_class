<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/views/accessErr.jsp</h1>
	
	<h2> 접근권한없는 유저가 페이지 접근시 발생 </h2>
	
	<h2> 사용자 인증정보 </h2>
	${auth }<hr>
	
	<%-- ${pageContext.request }<hr> --%>
	
	${auth.principal.username }<hr>
	${auth.principal.password }<hr>
	${auth.principal.authorities }<hr>
	
	${auth.details }<hr>
	${auth.details.remoteAddress }<hr>
		
	
	
	
</body>
</html>