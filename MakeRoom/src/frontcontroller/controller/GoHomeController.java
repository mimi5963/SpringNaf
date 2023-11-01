package frontcontroller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoHomeController implements Controller{

	

	@Override
	public String Dohandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				System.out.println("home컨트롤러");
				return "home";
	
	}

}
