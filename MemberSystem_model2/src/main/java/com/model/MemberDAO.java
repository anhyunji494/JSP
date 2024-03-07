package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {

	public int join(MemberDTO dto) {

		// JDBC
		// 0. 해당 드라이버 파일 넣기(프로젝트 내부)
		// : 드라이버 파일 복사해서 WEBIF 파일 내부 LIB 폴더에 넣기
		// 1. 드라이버 동적 로딩
		Connection conn = null;
		PreparedStatement psmt = null;
		int cnt = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 커넥션 연결
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			if (conn != null) {
				System.out.println("Connection 연결 성공");
			} else {
				System.out.println("Connection 연결 실패");
			}

			// 3. SQL문 작성 및 실행
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
			psmt = null;
			// psmt : sql 작성 및 실행해주는 객체
			psmt = conn.prepareStatement(sql);
			// connection 내부에서 psmt 문장을 검토
			// oracle에서는 인덱스가 1부터 시작
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getNick());
			psmt.setString(4, dto.getPhone());
			cnt = psmt.executeUpdate();
			// psmt는 실행한 문장의 갯수를 반환
			// 오류 점검 => 갯수 이용
			System.out.println("등록 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

}
