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
	- Client�� ������ ���������� �����ϱ� ���� ���
	
	Ư¡ - Session�� ������ ���� �� 1�� �߱�
		- �������� �����ϴ� ���� ������ ����(����) or 30�� �̻� �ƹ��� �ൿ�� ���� ���� �� 
		 
	������ġ : Server PC 
	�������� : Object 
	* ��� ���¾�� ���� ���� ���� 
	���� : Cookie�� ���� ��������� ���� 
	�뷮���� : Server PC�� ����Ұ� ����ϴ� �� 
	
	������ : Client�� ���� �� ������ ������ ������ �� Session�� Ȱ���Ѵ� 
	(��: �α��� ����, ��������)
	--%>

	<%
		// session�� ���̵�� ��Ҥ���ȣ�� ���� 
		//	session.setAttribute('name, value) 
		// String -> Object(UpCasti9ng)
		session.setAttribute("id", "pbk");
	
		// Session�� ����� �� �����ͼ� Ȯ�����ϱ� 
		// Object -> String(DownCasting )
		String id = (String)session.getAttribute("Id");
	 	
		// Session �����ϱ� 
//		session.removeAttribte("id"); 
//		session.invalidate();
	
	
		String name = (String)session.getAttribute("name");
		if (name == null){
			out.print("<script>alert('10�ʵ��� �ƹ��� �ൿ�� ���� �ʾ� ���� �������� �̵��մϴ�.');");
			out.print("location.href='https:www.naver.com';</script>");
			
		}else{
			out.print(name+"�� ȯ���մϴ�.");
		}
		
	 %>
</body>
</html>