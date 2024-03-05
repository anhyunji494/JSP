<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title> 
<style>div, form, fieldset { margin: 20px
auto; text-align: center; }</style>
</head>
<body>
	<%
	int count = Integer.parseInt(request.getParameter("count"));
	%>
	<div>
			<fieldset>
				<legend>랜덤당첨 작성</legend>
				<form action = "ex09randomWinner.jsp" method = "post">
				주제 : <input type="text" name="title"> <br>
				<%
				for (int i = 1; i <= count; i++) {
					out.print("아이템" + i + " : ");
					out.print("<input type = 'text' name = 'item'>");
					out.print("<br>");
				}
				%>
				<input type="submit" value="시작">
				</form>
			</fieldset>
		
	</div>
</body>
</html>