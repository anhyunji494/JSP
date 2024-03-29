package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex04Lunch
 */
@WebServlet("/Ex04Lunch")
public class Ex04Lunch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
//		한식 리스트
		String[] klist = {"풍남옥", "그냥집밥", "해 뜨는 집", "좋은 국밥", "신신식당", "설농탕"};
//		중식 리스트
		String[] clist = {"1515", "황금성", "만리화", "열도지", "아리산"};
		String[] jlist = {"쿠로시로", "마시따라멘", "바른초밥", "공초밥", "카레마왕", "카레카레"};
		
//		lunch로 선택한 음식 종류에 따라서 해당 음식 메뉴를 랜덤으로 한가지 추천해주세요.
//		예) 중식 선택 -> clist 중 랜덤으로 한 가지를 추출해서 보여준다. 
		
		Random ran = new Random();
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		String lunch = request.getParameter("lunch"); // 웹에서는 모든 데이터가 문자열로 변환되어 전달된다. 
		PrintWriter out = response.getWriter();
		String menu = null; 
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>");
		if(lunch.equals("한식")) {
			menu = klist[ran.nextInt(klist.length)];
			out.print(menu);
		}else if(lunch.equals("중식")) {
			menu = clist[ran.nextInt(clist.length)];
			out.print(menu);
		}else {
			menu = jlist[ran.nextInt(jlist.length)];
			out.print(menu);
		}
		
		out.print("</h1>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
