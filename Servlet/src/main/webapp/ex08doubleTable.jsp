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
	// exex08doubleTable.html���� ������ floor, room �����Ϳ� ���� tr td ���� 
	
	int floor = Integer.parseInt(request.getParameter("floor")) ; 
	int room = Integer.parseInt(request.getParameter("room")) ;
		
	%>
	
	<h2><%= floor %>��</h2>
	<h2><%= room %>��</h2>
	
	<table border = "1px">
		<%
		for(int i = 0; i < floor; i++){
			// �� ����� 
			out.print("<tr>");
			for (int j = 0; j < room; j ++){
				// �� �����
				out.print("<td>" + j + "</td>");
			}
			out.print("</tr>");
		}
		 %>
	
	</table>
	
	
	
	
</body>
</html>