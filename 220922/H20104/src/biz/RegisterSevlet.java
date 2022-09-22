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

@WebServlet("/register")
public class RegisterSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterSevlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		boolean isExist = dao.existId(request.getParameter("memberId"));
		int result = 0;
		
		if(isExist) {
			out.print("<script>alert('이미 존재하는 ID 입니다. 다시 입력해주세요.'); history.back();</script>");
		} else {
			MemberVO data = new MemberVO();
			data.setMemberId(request.getParameter("memberId"));
			data.setMemberPwd(request.getParameter("memberPwd"));
			data.setMemberName(request.getParameter("name"));
			data.setMemberAddr(request.getParameter("addr"));
			data.setMemberAge(Integer.parseInt(request.getParameter("age")));
			
			result = dao.insertMember(data);
			if(result > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("loginOK", data);
				out.print("<script>alert('회원가입에 성공했습니다.');</script>");
			} else {
				out.print("<script>alert('회원가입에 실패했습니다.');</script>");
			}
			response.sendRedirect("./index.jsp");
		}
	}

}
