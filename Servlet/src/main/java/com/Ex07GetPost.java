package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex07GetPost
 */
@WebServlet("/Ex07GetPost")
public class Ex07GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		Get 방식 = QuesryString 방식 
//		전송하려고 하는 url 뒤에 name과 value 형태로 보내는 방식 
//		url?name=value&name2=value2 
//		특징 :
//		1. 데이터 전송 용량의 한계가 있다. (1024byte) => 주소가 무한대로 늘어날 수 없기 때문 
//		2. url로 데이터가 노출되기 때문에 보안에 취약함 
		
//		Post 방식
//		전송하려고 하는 데이터를 패킷의 바디 안에 저장해서 보내는 방식 
//		특징
//		1. 보안에 강력 (상대적) 
//		2. 많은 양의 데이터를 보낼 수 있음 
//		3. 단, 주소 공유가 불가 -> 유일한 단점 
		
		String text = request.getParameter("text");
		System.out.println(text);
		
		

	}
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
