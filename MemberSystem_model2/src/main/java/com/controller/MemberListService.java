package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.HttpJspPage;

import com.model.MemberDAO;
import com.model.MemberDTO;

/**
 * Servlet implementation class MemberListService
 */
@WebServlet("/MemberListService")
public class MemberListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.memberList ();
		
		
		// HttpSession session = request.getSession();
		// session.setAttribute("list", list);

		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("memberList.jps");
		
		response.sendRedirect("memberList.jsp");
	}

}
