package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/memberDelete")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String contextPath = request.getContextPath();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDAO dao = new MemberDAO();
		int n = dao.deleteMember(userId);
		if(n <= 0) {
			out.println("<script>alert('멤버 삭제 실패');</script>");
		}
		response.sendRedirect(contextPath + "/memberList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
