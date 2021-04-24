<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int sum(int s, int e){
		int result = 0;
		for(int i = s; i <= e; i++){
			result += i;
		}
		return result;
	}
%>
<% 
	int sum = 0;
	for(int i = 1; i <= 100; i++){
		sum += i;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<td>1~100까지의 총합</td>
	<td><%=sum(10, 50) %></td>
</tr>
</table>
</body>
</html>