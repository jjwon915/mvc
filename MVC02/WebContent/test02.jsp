<%@page import="kr.bit.model.MyCalc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	MyCalc my = new MyCalc();	
	int sum = my.sum(1, 300);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
		<tr>
			<td>1~300까지의 총합</td>
			<td><%=sum %></td>
		</tr>
	</table>
</body>
</html>