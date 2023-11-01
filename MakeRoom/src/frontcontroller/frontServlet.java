package frontcontroller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberRepositroy;
import domain.MemberVO;
import frontcontroller.controller.Controller;


@WebServlet("*.do")
public class frontServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		MemberVO test1 = new MemberVO();
		test1.setName("hong");
		test1.setPwd("123");
		MemberVO test2 = new MemberVO();
		test2.setName("kim");
		test2.setPwd("123");
		MemberRepositroy.getInstance().saveMember(test1);
		MemberRepositroy.getInstance().saveMember(test2);
	}
	
	private ControllerMapper cm;
	public frontServlet() {
		cm = new ControllerMapper();
	}
	
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
	
		String uri = getCommand(request);
		
		Controller con = cm.getMappedController(uri);
		
		String result = con.Dohandle(request, response);
		
		
		
		if(result.contains("redirect:")) {
			String redirectPath = result.substring("redirect:".length());
			response.sendRedirect(contextPath+redirectPath);

		}else {
			String pathresult = viewResolve(result);
			RequestDispatcher rd = request.getRequestDispatcher(viewResolve(result));
			rd.forward(request, response);
		}
	}
	
	private String getCommand(HttpServletRequest request) {
		return request.getRequestURI().substring(request.getContextPath().length());
	}
	
	private String viewResolve(String path) throws UnsupportedEncodingException {
		String prefix = "/WEB-INF/member/";
		String suffix = ".jsp";
		
		return prefix+path+suffix;
	}

	
}
