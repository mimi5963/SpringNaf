package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ControllerAdvices {
	
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IllegalArgumentException.class)
	public void illegalExHandle(IllegalArgumentException e,HttpServletResponse response) throws IOException {
		System.out.println("작동은하는디");
	
		//response.sendError(HttpStatus.NOT_FOUND,"예스");
		response.sendError(response.SC_NOT_FOUND, "ih");
		//return "index";
	}
}
