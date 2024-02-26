package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex03UrlMapping
 */
@WebServlet("/Ex03Url")
public class Ex03UrlMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		 url mapping : 서블릿을 웹에서 실행하기 위한 문자열을 달아준 것 
//		 장점 1) 접속 url이 짧아져 접근성이 좋아진다 2) java 파일명을 노출하지 않기 때문에 보안이 강해진다.
		
	}



}
