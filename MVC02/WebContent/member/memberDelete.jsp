<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%
	int number = Integer.parseInt(request.getParameter("num"));

	MemberDAO dao = new MemberDAO();
	int result = dao.memberDelete(number);
	
	if(result > 0) {
		response.sendRedirect("memberList.jsp");
	} else {
		throw new ServletException("not delete");
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