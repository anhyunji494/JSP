package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex02Request
 */
@WebServlet("/Ex02Request")
public class Ex02Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ip = request.getRemoteAddr();
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");
		out.print("<body>");
		
		if (ip.equals("59.0.236.63") ) {
			out.print("민지 님 환영합니다.");
		} else if (ip.equals("211.48.213.178") ) {
			out.print("선생님 환영합니다.");
		} else {
			out.print("손님 환영합니다.");
		}
		
		out.print("</body>");
		out.print("</html>");

	}

}
