<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<section>
	<h1>홈쇼핑 회원 정보 수정</h1>
	
<%
	MemberVO member = (MemberVO)request.getAttribute("member");
%>
	<form action="<%= request.getContextPath() %>/member/memberUpdate" method="post">
		<table>
			<tr>
				<td> 회원번호(자동발생) </td>
				<td> <input type="number" value="${member.custno}" name="custno" readonly="readonly"></td>
			</tr>
			<tr>
				<td> 회원성명 </td>
				<td> <input type="text" name="custname" value="${member.custname}"></td>
			</tr>
			<tr>
				<td> 회원전화 </td>
				<td> <input type="text" name="phone" value="${member.phone}"></td>
			</tr>
			<tr>
				<td> 회원주소 </td>
				<td> <input type="text" name="addr" value="${member.address}"></td>
			</tr>
			<tr>
				<td> 가입일자 </td>
				<td> <input type="date" name="joindate" value="${member.joindate}"></td>
			</tr>
			<tr>
				<td> 고객등급[A:VIP, B:일반, C:직원] </td>
				<td> <input type="text" name="grade" value="${member.grade}"></td>
			</tr>
			<tr>
				<td> 도시코드 </td>
				<td> <input type="text" name="city" value="${member.city}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<a href="<%= request.getContextPath() %>/member/memberList"><input type="button" value="조회"></a>
				</td>
			</tr>
		</table>
	</form>
</section>

<%@ include file="../footer.jsp" %>