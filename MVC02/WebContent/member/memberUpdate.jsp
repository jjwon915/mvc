<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<% 
	request.setCharacterEncoding("utf-8");
	// parameter 수집
	int num = Integer.parseInt(request.getParameter("num"));
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	
	MemberVO vo = new MemberVO();
	vo.setNum(num);
	vo.setAge(age);
	vo.setEmail(email);
	vo.setPhone(phone);
	
	MemberDAO dao = new MemberDAO();
	int cnt = dao.memberUpdate(vo);
	if(cnt > 0) {
		// update 성공
		response.sendRedirect("memberList.jsp");
	}
	else {
		// update 실패 => 예외 객체를 만들어 WAS에게 던진다.
		throw new ServletException("not update");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>