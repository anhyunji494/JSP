<%@page import="com.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- Web Page에 Nick님을 환영니다! 를 출력해주세요 --%>
	<% 
	
	MemberDTO info = (MemberDTO)session.getAttribute("info");
	%>
	
	<%= info.getNick() %>님 환영합니다! 
	<a href = "LogoutService">로그아웃</a>
	


</body>
</html>