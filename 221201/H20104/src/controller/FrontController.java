package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "/FrontControllerV1", urlPatterns = "/members/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Controller> controllerMap = new HashMap<>();


    public FrontController() {
    	super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	controllerMap.put("/members/memberList", new MemberListController());
    	controllerMap.put("/members/memberInsert", new MemberInsertController());
    	controllerMap.put("/members/memberDelete", new MemberDeleteController());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 컨텍스트 경로를 제외한 URI
		String contextPath = request.getContextPath();
		String path = requestURI.substring(contextPath.length());
		
		Controller controller = controllerMap.get(path);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		controller.process(request, response);
	}

}
