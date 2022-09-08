<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp" %>
	<h2>회원 가입 화면</h2>
	
	<form action="/register" method="post">
		<table width="500px" border="1" align="center">
			<tr>
				<td>회원 ID</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			
		</table>
	</form>