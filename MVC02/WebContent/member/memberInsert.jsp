<%@ page import="kr.bit.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// parameter 수집(VO)
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	
	//MemberVO vo = new MemberVO(id, pass, name, age, email, phone);
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setPass(pass);
	vo.setName(name);
	vo.setAge(age);
	vo.setEmail(email);
	vo.setPhone(phone);
	
	MemberDAO dao = new MemberDAO();
	int result = dao.memberInsert(vo);
	if(result > 0) {
		// insert 성공
		response.sendRedirect("memberList.jsp");
	}
	else {
		// insert 실패 => 예외 객체를 만들어 WAS에게 던진다.
		throw new ServletException("not insert");
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