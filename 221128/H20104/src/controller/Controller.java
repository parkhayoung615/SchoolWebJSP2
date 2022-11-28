package controller;

import java.io.IOException;

public interface Controller {
	Myview process(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException;

}
