<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// Controller에서 JSP로 객체를 보냈다고 생각하기 위해 아래와 같이 코드를 구현.
	String[] str = {"사과", "포도", "복숭아", "딸기", "자두"};
	request.setAttribute("str", str);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="fruit" items="${str}">
		${fruit}<br/>
	</c:forEach>

</body>
</html>