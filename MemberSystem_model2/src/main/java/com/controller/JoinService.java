package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;
import com.model.MemberDTO;

/**
 * Servlet implementation class JoinService
 */
@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 문제 1. 입력한 id, pw, nick, phone 정보를 콘솔창에 출력하시오

		request.setCharacterEncoding("EUC-KR");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		String phone = request.getParameter("phone");

		// DAO로 한번에 묶어서 DTO로 전달
		MemberDTO dto = new MemberDTO(id, pw, nick, phone);
		// DB관련 DAO로 모두 빼기
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(dto);

		// 4. 연결종료
		// 연결종료는 항상 열려있는 역순으로
		if (cnt > 0) {
			System.out.println("회원가입 성공");
			response.sendRedirect("main.jsp");
		} else {
			System.out.println("회원가입 실패");
			response.sendRedirect("join.jsp");
		}

	}

}
