package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
			
			if(ex instanceof IllegalArgumentException) {
				System.out.println("여기 왔냐?");
				try {
					response.sendError(response.SC_NOT_FOUND,"예외 바꾸기");
				} catch (IOException e) {
					
				}
			}
		return new ModelAndView();
	}

}
