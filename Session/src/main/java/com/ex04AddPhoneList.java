package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ex04AddPhoneList
 */
@WebServlet("/ex04AddPhoneList")
public class ex04AddPhoneList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원들의 연락처를 Session에 저장 후 ex04list.jsp로 이동
		// 연락처에 들어가는 정보 (이름, 나이, 번호, 주소)
		
		MemberDTO m1 = new MemberDTO("안현지", 26, "010-8310-6081", "김제시");
		MemberDTO m2 = new MemberDTO("안예진", 24, "010-2823-0049", "수완동");
		MemberDTO m3 = new MemberDTO("안성준", 18, "010-4877-0377", "영광군");
		MemberDTO m4 = new MemberDTO("안종선", 40, "010-5625-5751", "법성면");
		MemberDTO m5 = new MemberDTO("박은경", 35, "010-5918-0377", "남양주시");
		MemberDTO m6 = new MemberDTO("키키", 01, "010-0000-0000", "곡성군");
		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
		
		// servlet 에서 session을 사용하는 방법 
		// 세션 생성 
		HttpSession session = request.getSession();
		
		session.setAttribute("list", list);
		
		// ex04list.jsp페이지로 이동하기 
		
		response.sendRedirect("ex04list.jsp");
		
	}

}
