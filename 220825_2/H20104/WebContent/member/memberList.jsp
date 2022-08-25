<%@page import="java.util.ArrayList"%>
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
	<h1> 회원 목록 (member 테이블)</h1>
	<table border="1">
		<tr>
			<th> 사용자 ID </th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<!-- DB에서 데이터 가져와서 화면에 출력 -->
		<!-- dao.MemberDAO 클래스 -> getMemberList() 호출 -->
		
<%
	MemberDAO dao = new MemberDAO();
	ArrayList<String> list = dao.getMemberList();
	String updateLink = "memberUpdate.jsp?id=";
	String deleteLink = "/delete?id=";
	
	if (list.isEmpty())
		out.print("<tr><td> 회원정보가 없습니다. </td></tr>");
	else {
		for(String data : list) {
%>
	<tr>
		<td> <%= data %> </td>
		<td> <a href="<%= updateLink + data %>"> 수정 </a> </td>
		<td> <a href="<%= deleteLink + data %>"> 삭제 </a> </td>
	</tr>
<%
		}
	}
	
%>
	</table>
	<br><br>
	<a href="./index.jsp"> 처음 화면</a>
</body>
</html>