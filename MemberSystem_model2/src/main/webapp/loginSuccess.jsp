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
	<%-- Web Page�� Nick���� ȯ���ϴ�! �� ������ּ��� --%>
	<% 
	
	MemberDTO info = (MemberDTO)session.getAttribute("info");
	%>
	
	<%= info.getNick() %>�� ȯ���մϴ�! 
	<a href = "LogoutService">�α׾ƿ�</a>
	


</body>
</html>