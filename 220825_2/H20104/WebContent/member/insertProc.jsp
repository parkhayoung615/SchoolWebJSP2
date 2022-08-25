<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id, pwd;
	MemberDAO dao = new MemberDAO();
	int n = 0;
	
	id = request.getParameter("id");
	pwd = request.getParameter("pwd");
	
	n = dao.insertMember(id, pwd);
	
	if (n>0)
		response.sendRedirect("/member/memberList.jsp");
	else
		out.print("<script> history.back() </script>");
%>
</body>
</html>