<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!-- 
	MVC 패턴 적용 (MVC 패턴2)
	- 서블릿을 컨트롤러로 사용하고, JSP를 뷰로 사용해서 MVC 패턴을 적용함
	1. HTTP 요청 : 서블릿 컨트롤러 호출
	2. 데이터 처리
	3. 데이터 전달 : Model 이용
	4. JSP 뷰 호출
	5. 데이터 참조해서 뷰 로직 수행
	6. HTTP 응답
 -->
 
<section>
	<div class="container">
		<p align="left" class="title">회원관리 프로그램</p>
		<p align="left">
			회원정보 데이터베이스를 구축하고 회원관리 기능을 수행하는 프로그램이다. <br>
			서블릿을 컨트롤러로 사용하고, JSP를 뷰로 사용해서 MVC 패턴을 적용함. <br><br>
			<b>[프로그램 작성순서]</b><br>
			1. 회원정보 테이블을 생성한다. <br>
			2. 회원등록 화면 프로그램을 작성한다. <br>
			3. 회원목록 조회 프로그램을 작성한다. <br>
			4. 회원정보 삭제 프로그램을 작성한다. <br>
		</p>
	</div>
</section>

<%@ include file="footer.jsp" %>