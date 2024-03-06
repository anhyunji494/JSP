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
	// ���� 1. �Է��� id, pw, nick, phone ������ �ܼ�â�� ����Ͻÿ�

	request.setCharacterEncoding("EUC-KR");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nick = request.getParameter("nick");
	String phone = request.getParameter("phone");

	// JDBC 
	// 0. �ش� ����̹� ���� �ֱ�(������Ʈ ����)
	// : ����̹� ���� �����ؼ� WEBIF ���� ���� LIB ������ �ֱ�
	// 1. ����̹� ���� �ε� 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. Ŀ�ؼ� ����
	String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
	String db_id = "hr";
	String db_pw = "hr";

	Connection conn = DriverManager.getConnection(db_url, db_id, db_pw);
	if(conn != null){
	System.out.println("Connection ���� ����");
	}else{
		System.out.println("Connection ���� ����");
	}

	// 3. SQL�� �ۼ� �� ���� 
	String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
	PreparedStatement psmt = null;
	// psmt : sql �ۼ� �� �������ִ� ��ü 
	psmt = conn.prepareStatement(sql);
	// connection ���ο��� psmt ������ ���� 
	// oracle������ �ε����� 1���� ���� 
	psmt.setString(1, id);
	psmt.setString(2, pw);
	psmt.setString(3, nick);
	psmt.setString(4, phone);
	int cnt = psmt.executeUpdate();
	// psmt�� ������ ������ ������ ��ȯ 
	// ���� ���� => ���� �̿� 
	System.out.println("��� ����");
	// 4. ��������
	// ��������� �׻� �����ִ� �������� 
	if(cnt > 0){
		System.out.println("ȸ������ ����");
		response.sendRedirect("main.jsp");
	}else{
		System.out.println("ȸ������ ����");
		response.sendRedirect("join.jsp");
	}
	
	if (psmt != null) {
		psmt.close();
		System.out.println("psmt ���� ����");}

	if (conn != null) {
		conn.close();
	System.out.println("conn ���� ����");}

	%>
</body>
</html>