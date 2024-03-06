<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
	// 문제 1. 입력한 id, pw, nick, phone 정보를 콘솔창에 출력하시오

	request.setCharacterEncoding("EUC-KR");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nick = request.getParameter("nick");
	String phone = request.getParameter("phone");

	// JDBC 
	// 0. 해당 드라이버 파일 넣기(프로젝트 내부)
	// : 드라이버 파일 복사해서 WEBIF 파일 내부 LIB 폴더에 넣기
	// 1. 드라이버 동적 로딩 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. 커넥션 연결
	String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
	String db_id = "hr";
	String db_pw = "hr";

	Connection conn = DriverManager.getConnection(db_url, db_id, db_pw);
	if(conn != null){
	System.out.println("Connection 연결 성공");
	}else{
		System.out.println("Connection 연결 실패");
	}

	// 3. SQL문 작성 및 실행 
	String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
	PreparedStatement psmt = null;
	// psmt : sql 작성 및 실행해주는 객체 
	psmt = conn.prepareStatement(sql);
	// connection 내부에서 psmt 문장을 검토 
	// oracle에서는 인덱스가 1부터 시작 
	psmt.setString(1, id);
	psmt.setString(2, pw);
	psmt.setString(3, nick);
	psmt.setString(4, phone);
	int cnt = psmt.executeUpdate();
	// psmt는 실행한 문장의 갯수를 반환 
	// 오류 점검 => 갯수 이용 
	System.out.println("등록 성공");
	// 4. 연결종료
	// 연결종료는 항상 열려있는 역순으로 
	if(cnt > 0){
		System.out.println("회원가입 성공");
		response.sendRedirect("main.jsp");
	}else{
		System.out.println("회원가입 실패");
		response.sendRedirect("join.jsp");
	}
	
	if (psmt != null) {
		psmt.close();
		System.out.println("psmt 연결 종료");}

	if (conn != null) {
		conn.close();
	System.out.println("conn 연결 종료");}

	%>
</body>
</html>