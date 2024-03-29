package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex06BgColor
 */
@WebServlet("/Ex06BgColor")
public class Ex06BgColor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String color = request.getParameter("color");
		String first = request.getParameter("fddn");
		String last = request.getParameter("lddn");
		int first_i = Integer.parseInt(first);
		int last_i = Integer.parseInt(last);

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<center>");
		out.print("<table border = '1px solid balck' bgcolor='" + color + "'>");

		// 구구단 출력
		for (int i = first_i; i <= last_i; i++) {
			out.print("<tr>");
			for (int j = 1; j <= 9; j++) {
				out.print("<td>");
				out.print(i + "*" + j + " = " + (i * j));
				out.print("</td>");
			}
			out.print("</tr>");
			out.print("<br>");
		}

		out.print("</table>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");

	}

}
