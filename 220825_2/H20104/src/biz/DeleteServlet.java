package biz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public DeleteServlet() {
        super();
    }
    // delete는 페이지를 거쳐서 회원 정보가 삭제되는 것이 아니기 때문에 따로 form으로 지정하지 않았다 그래서 doGet으로 설정됨(get이 기본값)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		int n = 0;
		String id = request.getParameter("id");
		
		n = dao.deleteMember(id);
		
		// 쿼리가 간다면 (n의 숫자가 쿼리가 간 숫자)
		if(n>0)
			// memberList로 이동
			response.sendRedirect("/member/memberList.jsp");
		else
			out.print("<script> alert('회원 정보 삭제를 실패했습니다.'); </script>");
	}


}
