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
	request.setCharacterEncoding("EUC-KR");
	String option = request.getParameter("url");
	String url = request.getParameter("url");
	if ( option.equals("���̹�")){
		out.print("���̹��� �̵��մϴ�.");
		response.sendRedirect(url);
	} else if (option.equals("����")){
		out.print("�������� �̵��մϴ�.");
		response.sendRedirect(url);
	} else if (option.equals("����")){
		out.print("���۷� �̵��մϴ�.");
		response.sendRedirect(url);
	} else if (option.equals("����Ʈ���簳�߿�")){
		out.print("����Ʈ���簳�߿����� �̵��մϴ�.");
		response.sendRedirect(url);
	}else {
		out.print("�ٽ� �õ����ּ���.");
	}
	 %>
</body>
</html>