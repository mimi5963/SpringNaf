package jw.bit.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통처리 (요청 공통 처리 )
		request.setCharacterEncoding("UTF-8");
		
		//요청 얻기
		String ctx = request.getContextPath();//
		String requestURL = request.getRequestURL().substring(ctx.length());
		
		//핸들러 맵핑 
		String result = new HandlerMapping().getController(requestURL).requestHandler(request, response);
		
		if(result.contains("redirect:")) {
			response.sendRedirect(result.split(":")[1]);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.getPath(result));
			rd.forward(request, response);			
		}
		
	}

}
