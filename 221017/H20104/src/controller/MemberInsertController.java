package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;


@WebServlet("/memberInsert")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		vo.setUserId(request.getParameter("userId"));
		vo.setUserName(request.getParameter("userName"));
		
		String contextPath = request.getContextPath();
		
		int n = dao.insertMember(vo);
		
		if(n > 0) {
			response.sendRedirect(contextPath + "/memberList");
		} else {
			response.sendRedirect(contextPath + "/memberInsert.jsp");
		}
 	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
