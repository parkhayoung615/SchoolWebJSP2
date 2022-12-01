<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 프레임워크 만들기 - 프론트 컨트롤러 도입 - v1</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css?ver=1">
</head>
<body>
	<header>
		<h3>회원관리 - controller V1</h3>
	</header>
	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath}/memberInsert.jsp">회원 등록</a></li>
			<li><a href="${pageContext.request.contextPath}/members/memberList">회원 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/projectArchitecture.jsp">프로젝트 구조</a></li>
		</ul>
	</nav>