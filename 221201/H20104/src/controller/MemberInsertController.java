package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberInsertController implements Controller {
	@Override

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setUserId(request.getParameter("userId"));
		vo.setUserName(request.getParameter("userName"));
		
		String contextPath = request.getContextPath();
		
		int n = dao.insertMember(vo);
		if(n > 0) {
			response.sendRedirect(contextPath + "/members/memberList"); 
		} else {
			response.sendRedirect(contextPath + "/memberInsert.jsp"); 
		}
	}

}
