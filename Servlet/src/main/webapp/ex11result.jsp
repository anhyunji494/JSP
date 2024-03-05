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
	if ( option.equals("네이버")){
		out.print("네이버로 이동합니다.");
		response.sendRedirect(url);
	} else if (option.equals("다음")){
		out.print("다음으로 이동합니다.");
		response.sendRedirect(url);
	} else if (option.equals("구글")){
		out.print("구글로 이동합니다.");
		response.sendRedirect(url);
	} else if (option.equals("스마트인재개발원")){
		out.print("스마트인재개발원으로 이동합니다.");
		response.sendRedirect(url);
	}else {
		out.print("다시 시도해주세요.");
	}
	 %>
</body>
</html>