<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지 입니다.</h1>
	<form action="joinService.jsp" ,method = "join">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="text" name="pw"></td>
		</tr>
		<tr>
			<td>NICK</td>
			<td><input type="text" name="nick"></td>
		</tr>
		<tr>
			<td>PHONE</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td colspan = "2">
			<input type = "submit" name ="Join">
			</td>
		</tr>


	</table>
	</form>
</body>
</html>