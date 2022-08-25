<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MEMBER 테이블 DB CURD 실습</h1>
	
	<ul>
		<li><a href="<%= request.getContextPath() %>/member/memberList.jsp">회원목록 조회</a></li>
		<li><a href="<%= request.getContextPath() %>/member/memberInsert.jsp">회원 추가</a></li>
	</ul>
</body>
</html>