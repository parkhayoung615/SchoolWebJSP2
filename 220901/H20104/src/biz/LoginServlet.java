package biz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String id, pwd;
		boolean result = false;
		PrintWriter out = response.getWriter();
		
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		result = dao.getMemeberPwd(id, pwd);
		
		if(result) {
			MemberVO vo = new MemberVO();
			vo.setUserId(id);
			vo.setUserPwd(pwd);
			
			// MemberVO 객체 변수 생성 -> 세션에 속성 값으로 설정
			HttpSession session = request.getSession();
			session.setAttribute("loginOK", vo);
			response.sendRedirect("/login/login.jsp");
		} else {
			out.println("<script> alert('회원정보가 맞지 않습니다.'); history.back(); </script>");
		}
	}

}