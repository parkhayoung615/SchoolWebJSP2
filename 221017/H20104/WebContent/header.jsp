<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 패턴</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css?ver=1">
</head>
<body>
	<header>
		<h3>회원 관리 - MVC 패턴 적용</h3>
	</header>
	
	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath}/memberInsert.jsp">회원 등록</a></li>
			<li><a href="${pageContext.request.contextPath}/memberList">회원 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/projectArchitecture.jsp">프로젝트 구조</a></li>
		</ul>
	</nav>
