<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	
	Session 
	- Client의 정보를 지속적으로 유지하기 위한 방법
	
	특징 - Session안 브라우저 우저 당 1개 발급
		- 브라우저를 종료하는 순간 세션은 만료(삭제) or 30분 이상 아무런 행동을 하지 않을 때 
		 
	저장위치 : Server PC 
	저장형식 : Object 
	* 모든 형태어ㅣ 파일 저장 가능 
	보안 : Cookie에 비해 상대적으로 강력 
	용량제한 : Server PC의 저장소가 허용하는 한 
	
	총정리 : Client의 정보 중 종요한 정보를 저장할 때 Session을 활용한다 
	(예: 로그인 정보, 계좌정보)
	--%>

	<%
		// session에 아이디와 비밈ㄹ번호를 저장 
		//	session.setAttribute('name, value) 
		// String -> Object(UpCasti9ng)
		session.setAttribute("id", "pbk");
	
		// Session에 저장된 값 가져와서 확ㅇ인하기 
		// Object -> String(DownCasting )
		String id = (String)session.getAttribute("Id");
	 	
		// Session 삭제하기 
//		session.removeAttribte("id"); 
//		session.invalidate();
	
	
		String name = (String)session.getAttribute("name");
		if (name == null){
			out.print("<script>alert('10초동안 아무런 행동을 하지 않아 메인 페이지로 이동합니다.');");
			out.print("location.href='https:www.naver.com';</script>");
			
		}else{
			out.print(name+"님 환영합니다.");
		}
		
	 %>
</body>
</html>