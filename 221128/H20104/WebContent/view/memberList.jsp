<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("memberList");
%>
	<h1>회원목록조회/수정</h1>
	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>가입일자</td>
			<td>고객등급</td>
			<td>거주지역</td>
		</tr>
<%
	if(list != null) {
		for(MemberVO member : list) {
%>
		<tr>
			<td><a href="<%= request.getContextPath() %>/member/updateForm?custno=<%= member.getCustno()%>"><%= member.getCustno()%></a></td>
			<td><%= member.getCustname() %></td>
			<td><%= member.getPhone() %></td>
			<td><%= member.getAddress() %></td>
			<td><%= member.getJoindate() %></td>
			<td><%= member.getGrade() %></td>
			<td><%= member.getCity() %></td>
		</tr>
<%
		}
	}
%>
	</table>
<%@ include file="../footer.jsp" %>