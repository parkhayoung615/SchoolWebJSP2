package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;


public class MemberListController implements Controller {
	@Override

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> memberList = dao.selectMember();
		
		request.setAttribute("memberList", memberList);
		request.getRequestDispatcher("/memberList.jsp").forward(request, response);
	}

}
