<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0 auto; padding: 0;
	box-sizing: border-box;	
}

.wrapper {
	width: 100%;
	text-align: center;
}
h2 {
	margin: 20px 0;
} 

form {
	background-color: #ccc;
	padding: 10px;
	width: 300px;
}

.login_container {
	border: 3px solid #f1f1f1;
	padding: 16px;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	cursor: pointer;
	width: 100%;
}

a {
	text-decoration: none;
	color: black;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 5px;
	margin-left: 10px;
	cursor: pointer;
	width: 100px;
	border-radius: 20px;
}


</style>
</head>
<body>
	<div class="wrapper">
		<h2>YangYoung 로그인 페이지</h2>
		
<%
		String id = (String)session.getAttribute("loginOK");

		if(id != null) {
%>
			<b><%= id %></b>님 로그인 상태입니다.
			<button><a href="/logout">로그아웃</a></button>
<% 
		} else {
%>
	<form action="/login"  method="get">
		<div class="login_container">
			<label><b>User ID</b></label>
			<input type="text" placeholder="Enter UserID" name="id">
			
			<label><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="pwd">
			<input type="text" value="login">
			<a href="#">회원가입</a>
		</div>
	</form>
<% 	
		}
%>
	</div>
</body>
</html>