<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
div, form, fieldset {
	margin: 20px auto;
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<fieldset>
			<legend>랜덤당첨결과</legend>

			<%
			request.setCharacterEncoding("EUC-KR");
			String title = request.getParameter("title");
			String[] items = request.getParameterValues("item");
			Random ran = new Random();
			int rnum = ran.nextInt(items.length);
			
			%>
			
			<%=
			title
			%>
			<br>
			<%=
			items[rnum]%>


		</fieldset>

	</div>
</body>
</html>