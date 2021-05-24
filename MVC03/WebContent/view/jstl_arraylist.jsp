<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<% 
	List<String> list = new ArrayList<String>();
	list.add("Java");
	list.add("C++");
	list.add("C");
	list.add("Python");
	list.add("HTML");
	list.add("CSS");
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="lang" items="${list}">
		${lang}<br/>
	</c:forEach>
</body>
</html>