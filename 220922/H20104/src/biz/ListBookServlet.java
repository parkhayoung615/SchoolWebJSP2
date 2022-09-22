package biz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

@WebServlet("/listBook")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ListBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String key = request.getParameter("book_title");
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> list = dao.getBookList(key);
		
		if(list != null) {
			request.setAttribute("book_list", list);
		}
		
		request.getRequestDispatcher("./book/listBook.jsp").forward(request, response);
	}

}
