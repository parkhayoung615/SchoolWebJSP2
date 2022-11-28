<%@page import="vo.MoneyVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<section>
<%
	ArrayList<MoneyVO> list = (ArrayList<MoneyVO>) request.getAttribute("moneyList");
%>
	<h1>회원매출조회</h1>
	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>전화번호</td>
			<td>고객등급</td>
			<td>매출</td>
		</tr>
<%
	int n = 0;
	if(list != null) {
		for(MoneyVO data : list) {
%>
		<tr>
			<td><%= data.getCustno() %></td>
			<td><%= data.getCustname() %></td>
			<td><%= data.getGrade() %></td>
			<td><%= data.getPrice() %></td>
		</tr>
<%
		}
	}
%>
	</table>
</section>
<%@ include file="../footer.jsp" %>