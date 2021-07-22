<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>memberList</title>

</head>
<body>

<div class="container">
  <h3>회원 리스트</h3>
	  <div class="panel panel-default">
	    <div class="panel-heading">
	    	<form class="form-horizontal" action="">
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="email">Email:</label>
			      <div class="col-sm-10">
			        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="pwd">Password:</label>
			      <div class="col-sm-10">          
			        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <div class="checkbox">
			          <label><input type="checkbox" name="remember"> Remember me</label>
			        </div>
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <button type="submit" class="btn btn-default">Submit</button>
			      </div>
			    </div>
		  </form>
	    </div>
	    <div class="panel-body">
	    	<div class="container">  
			  <table class="table table-hover">
			    <thead>
			      <tr>
			        <th>아이디</th>
			        <th>이름</th>
			        <th>비밀번호</th>
			        <th>나이</th>
			        <th>이메일</th>
			        <th>전화번호</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			      </tr>
			      <tr>
			        <td>Mary</td>
			        <td>Moe</td>
			        <td>mary@example.com</td>
			      </tr>
			      <tr>
			        <td>July</td>
			        <td>Dooley</td>
			        <td>july@example.com</td>
			      </tr>
			    </tbody>
			  </table>
	</div>

    </div>
    <div class="panel-footer" style="text-align:right;">
	        <input type="button" value="회원가입" class="btn btn-success" onclick="register()"/>
	        <input type="button" value="취소" class='btn btn-warning' onclick="formreset()"/>
    		<input type="button" value="리스트" onclick="location.href='${ctx}/member/memberList.jsp'" class="btn btn-default"/>
    </div>
  </div>
</div>

</body>
</html>