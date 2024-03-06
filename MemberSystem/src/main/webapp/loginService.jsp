<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	// 문제, 여기로 넘어온 id와 pw가 일치하는 사람의 id, pw, nick, phone 값을 콘솔창에 출력하시오. 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	// 1. 드라이버 동적 로딩 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. 커넥션 연결
	String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
	String db_id = "hr";
	String db_pw = "hr";

	Connection conn = DriverManager.getConnection(db_url, db_id, db_pw);
	if (conn != null) {
		System.out.println("Connection 연결 성공");
	} else {
		System.out.println("Connection 연결 실패");
	}
	// 3. SQL문 작성 
	String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PW = ?";
	PreparedStatement psmt = null;
	psmt = conn.prepareStatement(sql);
	psmt.setString(1, id);
	psmt.setString(2, pw);

	ResultSet rs = null;
	rs = psmt.executeQuery();
	// rs => 첫 커서는 컬럼에 있음 
	// rs.next(): 커서를 한칸 내려감 
	// 커서를 한 칸 내릴 수 있다면 true 반환 => 로그인 성공 
	if (rs.next()) {
		String login_id = rs.getString(1);
		String login_pw = rs.getString(2);
		String login_nick = rs.getString(3);
		String login_phone = rs.getString(4);
		System.out.println("로그인 성공");
		System.out.println(login_id + "/" + login_pw + "/" + login_nick + "/" + login_phone);
	} else if (!rs.next()) {
		System.out.println("로그인 실패");
	}

	// 4. 연결종료
	// 연결종료는 항상 열려있는 역순으로 
	if (rs != null) {
		rs.close();
		System.out.println("rs 연결 종료");
	}

	if (psmt != null) {
		psmt.close();
		System.out.println("psmt 연결 종료");
	}

	if (conn != null) {
		conn.close();
		System.out.println("conn 연결 종료");
	}
	%>
</body>
</html>