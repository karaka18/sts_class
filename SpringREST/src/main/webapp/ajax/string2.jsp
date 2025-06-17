<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>string2.jsp</h1>
	<h2> 전달받은 아이디 정보를 출력 </h2>
	<%
		System.out.println("값 : "+request.getParameter("id"));
	%>
	<h2> id : ${param.id }</h2>
	
	<c:if test="${param.id.equals('admin') }">
		<h2> 관리자 아이디 사용불가! </h2>
	</c:if>
	
	<c:if test="${!param.id.equals('admin') }">
		<h2> 아이디 사용가능! </h2>
	</c:if>
</body>
</html> --%>
${param.id}