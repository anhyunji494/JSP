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
	// ����, ����� �Ѿ�� id�� pw�� ��ġ�ϴ� ����� id, pw, nick, phone ���� �ܼ�â�� ����Ͻÿ�. 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	// 1. ����̹� ���� �ε� 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. Ŀ�ؼ� ����
	String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
	String db_id = "hr";
	String db_pw = "hr";

	Connection conn = DriverManager.getConnection(db_url, db_id, db_pw);
	if (conn != null) {
		System.out.println("Connection ���� ����");
	} else {
		System.out.println("Connection ���� ����");
	}
	// 3. SQL�� �ۼ� 
	String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PW = ?";
	PreparedStatement psmt = null;
	psmt = conn.prepareStatement(sql);
	psmt.setString(1, id);
	psmt.setString(2, pw);

	ResultSet rs = null;
	rs = psmt.executeQuery();
	// rs => ù Ŀ���� �÷��� ���� 
	// rs.next(): Ŀ���� ��ĭ ������ 
	// Ŀ���� �� ĭ ���� �� �ִٸ� true ��ȯ => �α��� ���� 
	if (rs.next()) {
		String login_id = rs.getString(1);
		String login_pw = rs.getString(2);
		String login_nick = rs.getString(3);
		String login_phone = rs.getString(4);
		System.out.println("�α��� ����");
		System.out.println(login_id + "/" + login_pw + "/" + login_nick + "/" + login_phone);
	} else if (!rs.next()) {
		System.out.println("�α��� ����");
	}

	// 4. ��������
	// ��������� �׻� �����ִ� �������� 
	if (rs != null) {
		rs.close();
		System.out.println("rs ���� ����");
	}

	if (psmt != null) {
		psmt.close();
		System.out.println("psmt ���� ����");
	}

	if (conn != null) {
		conn.close();
		System.out.println("conn ���� ����");
	}
	%>
</body>
</html>