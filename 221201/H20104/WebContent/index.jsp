<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!-- 
	프론트 컨트롤러 도입 - v1
	- 프론트 컨트롤러 서블릿 하나로 클라이언트의 요청을 받음
	- 프론트 컨트롤러가 요청에 맞는 컨트롤러를 찾아서 호출
	0. HTTP 요청 : Front Controller 호출
	1. Front Controller : URL 매핑 정보에서 Controller 조회
	2. Front Controller : Controller 호출
	3. Controller : JSP 호출
	4. HTTP 응답
 -->
 
<section>
	<div class="container">
		<p align="left" class="title">회원관리 프로그램</p>
		<p align="left">
			회원정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다. <br>
			프론트 컨트롤러 서블릿 하나로 클라이언트의 요청을 받음 <br>
			프론트 컨트롤러가 요청에 맞는 컨트롤러를 찾아서 호출 <br><br>
			<b>[프로그램 작성순서]</b><br>
			1. 회원정보 테이블을 생성한다. <br>
			2. 회원등록 화면 프로그램을 작성한다. <br>
			3. 회원목록 조회 프로그램을 작성한다. <br>
			4. 회원정보 삭제 프로그램을 작성한다. <br>
		</p>
	</div>
</section>

<%@ include file="footer.jsp" %>