package biz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.RentDAO;
import vo.MemberVO;
import vo.RentVO;

@WebServlet("/rentalBook")
public class RentalBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public RentalBookServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 요청 파라미터 정보(bookNo)가 있으면 도서대여 실행, 없으면 도서 대출 현황 조회
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("loginOK");
		String userId = member.getMemberId();
		
		int bookNo;
		String strBookNo = request.getParameter("bookNo");
		if(strBookNo == null) 
			bookNo = 0;
		else 
			bookNo = Integer.parseInt(strBookNo);
		
		RentDAO rentDao = new RentDAO();
		ArrayList<RentVO> rentList = null;
		RentVO rentVo = null;
		int ret = 0;
		
		BookDAO bookDao = null;
		
		if(bookNo == 0) {
			// 도서 대출현황 조회
			rentList = (ArrayList<RentVO>)rentDao.getRentalList(userId);
			if(rentList != null) {
				request.setAttribute("rent_list", rentList);
			}
			request.getRequestDispatcher("./book/rental.jsp").forward(request, response);
		} else {
			// 도서 대여
			rentVo = new RentVO();
			rentVo = rentDao.makeRentData(userId, bookNo);
			if(rentVo != null) {
				ret = rentDao.rentBook(rentVo);
				if(ret > 0) {
					bookDao = new BookDAO();
					bookDao.setRentalField(bookNo, "t");
				} else {
					out.println("<script>alert('도서 대여 등록 실패'); history.back();</script>");
				}
			} else {
				out.println("<script>alert('도서 대여 정보 생성 실패'); history.back();</script>");
			}
			
			response.sendRedirect("./rentalBook");
		}
	}

}
