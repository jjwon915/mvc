<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<% 
	// MemberVO vo = (MemberVO) request.getAttribute("vo");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Content</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="memberUpdate.do" method="post">
	<input type="hidden" name="num" value="${vo.num}"/>
		<table class="table table-bordered">
		<c:if test="${vo!=null}">
			<tr>
				<td colspan="2">${vo.name}의 회원님의 상세정보 입니다.</td>
			</tr>
			<tr>
				<td>번호</td>
				<td>${vo.num}</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${vo.id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${vo.pass}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="${vo.age}"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${vo.email}"/></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="${vo.phone}"/></td>
			</tr>
			</c:if>
			<c:if test="${vo==null}">
			<tr>
				<td>일치하는 회원이 없습니다.</td>
			</tr>
			</c:if>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" class="btn btn-warning" value="수정하기"/>
					<input type="reset" class="btn btn-primary" value="취소하기"/>
					<input type="button" class="btn btn-info" onclick="location.href='/MVC03/memberList.do'" value="돌아가기"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>