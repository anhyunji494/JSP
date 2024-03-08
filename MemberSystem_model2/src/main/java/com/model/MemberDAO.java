package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class MemberDAO {
	// 이클립스에서 변수명 파란색은 필드
	// 상수는 변수명 기울어짐
	// 필드 초기값은 null, 숫자형은 0, 불린형은 false가 기본값 - 초기값 따로 설정할 필요 X
	// 아래 세 값은 외부 접근/초기값 변하면 위험하므로 private 필드로 선언
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	// DB에 연결하는 것 자체가 보안에 중요 => private 사용
	private void getConnection() {
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

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void close() {
		// 4. 연결종료
		// 연결종료는 항상 열려있는 역순으로
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int join(MemberDTO dto) {

		// JDBC
		// 0. 해당 드라이버 파일 넣기(프로젝트 내부)
		// : 드라이버 파일 복사해서 WEBIF 파일 내부 LIB 폴더에 넣기
		// 1. 드라이버 동적 로딩

		int cnt = 0;

		getConnection();

		try {

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

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public MemberDTO login(MemberDTO dto) {
		getConnection();

		MemberDTO info = null;

		// 1. 드라이버 동적 로딩
		try {
			// 3. SQL문 작성
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PW = ?";
			psmt = null;
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			rs = psmt.executeQuery();
			// rs => 첫 커서는 컬럼에 있음
			// rs.next(): 커서를 한칸 내려감
			// 커서를 한 칸 내릴 수 있다면 true 반환 => 로그인 성공
			if (rs.next()) {
				// 로그인이 성공했을 때 ★
				String id = rs.getString("ID");
				String pw = rs.getString("PW");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");

				info = new MemberDTO(id, pw, nick, phone);

			} else if (!rs.next()) {
				System.out.println("로그인 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return info;
	}

	public ArrayList<MemberDTO> memberList() {
		// 담아서 반환할 어레이리스트 생성
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		// DB연결 
		getConnection();
		
		
		try {
			String sql = "SELECT * FROM MEMBER WHERE NOT ID='admin'";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String id =  rs.getString("ID");
				String pw =  rs.getString("PW");
				String nick =  rs.getString("NICK");
				String phone =  rs.getString("PHONE");
				
				MemberDTO dto = new MemberDTO(id, pw, nick, phone);
				list.add(dto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			close();
		}
		
		
		return list;
	}

}
