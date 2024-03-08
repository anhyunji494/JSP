package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		
		// 문제, 여기로 넘어온 id와 pw가 일치하는 사람의 id, pw, nick, phone 값을 콘솔창에 출력하시오. 
		String input_id = request.getParameter("id");
		String input_pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(input_id, input_pw);
		MemberDTO info = dao.login(dto);
		// 로그인 성공 실패 여부 
		
		if(info == null){
			// 로그인 실패
			response.sendRedirect("login.jsp");
		} else {
			// 로그인 성공 
			session.setAttribute("info", info);
			response.sendRedirect("loginSuccess.jsp");
		}

	}

}
