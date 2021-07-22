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
  <script type="text/javascript">
  	function register(){
  		
  	}
  	function formreset(){
  		document.register.reset();
  	}
  </script>
<title>memberRegister</title>
</head>
<body>

<div class="container">
  <h3>회원 가입</h3>
  <div class="panel panel-default">
    <div class="panel-heading">
    	<h5>환영합니다. 회원 가입을 원하시면 아래 정보를 입력하세요.</h5></div>
    <div class="panel-body">
    	<form class="form-horizontal" id="register" name="register" action="/action_page.php">
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="name">이름:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="id">아이디:</label>
		      <div class="col-sm-10">          
		        <input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요." name="id">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="pw">비밀번호:</label>
		      <div class="col-sm-10">          
		        <input type="password" class="form-control" id="pw" placeholder="비밀번호를 입력하세요." name="pw">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="age">나이:</label>
		      <div class="col-sm-10">          
		        <input type="text" class="form-control" id="age" placeholder="나이를 입력하세요." name="age">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="email">이메일:</label>
		      <div class="col-sm-10">          
		        <input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요." name="email">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="phone">전화번호:</label>
		      <div class="col-sm-10">          
		        <input type="text" class="form-control" id="phone" placeholder="전화번호를 입력하세요." name="phone">
		      </div>
		    </div>
	  </form>
    </div>
    <div class="panel-footer">
    	<div class="form-group" style="text-align: right">        
	      
	        <input type="button" value="회원가입" class="btn btn-success" onclick="register()"/>
	        <input type="button" value="취소" class='btn btn-warning' onclick="formreset()"/>
    		<input type="button" value="리스트" onclick="location.href='${ctx}/member/memberList.jsp'" class="btn btn-default"/>
	      
	    </div>
    </div>
  </div>
</div>

</body>
</html>