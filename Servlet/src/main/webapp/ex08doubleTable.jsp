<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	// exex08doubleTable.html에서 전달한 floor, room 데이터에 따라 tr td 생성 
	
	int floor = Integer.parseInt(request.getParameter("floor")) ; 
	int room = Integer.parseInt(request.getParameter("room")) ;
		
	%>
	
	<h2><%= floor %>층</h2>
	<h2><%= room %>방</h2>
	
	<table border = "1px">
		<%
		for(int i = 0; i < floor; i++){
			// 층 만들기 
			out.print("<tr>");
			for (int j = 0; j < room; j ++){
				// 방 만들기
				out.print("<td>" + j + "</td>");
			}
			out.print("</tr>");
		}
		 %>
	
	</table>
	
	
	
	
</body>
</html>