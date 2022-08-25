package biz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

// memberUpdate에서 form이 update로 줌
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateServlet() {
        super();
    }
    
    // memberUpdate.jsp를 살펴본다면 form에서 post 방식으로 줬기 때문에 doPost로 받는다
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String id, pwd;
		MemberDAO dao = new MemberDAO();
		int n = 0;
		
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		
		n = dao.updateMember(id, pwd);
		
		if(n>0)
			response.sendRedirect("/member/memberList.jsp");
		else
			// 뒤로 감
			out.print("<script> history.back() </script>");
	}
	

}
