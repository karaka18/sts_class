<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/sample/admin.jsp</h1>
	<sec:authetication property="principal" />
	<sec:authetication property="principal.username" /> <br>
	<sec:authetication property="principal.authorities" /> <br>
	
	<%-- <c:if test="${empty sessionScope.id}"> --%>
	 
	<%-- </c:if> --%>
	
	<!-- security 표현식 p673~4 -->
	<sec:authorize access="isAnonymous()">
		<!-- 익명의 사용자인 경우(로그인 X) -->
		<a href="/customLogin">로그인</a>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<!-- 익명의 사용자인 경우(로그인 O) -->
		<a href="/customLogout">로그인</a>
	</sec:authorize>
	
	<a href="/customLogout">로그아웃</a>




</body>
</html>