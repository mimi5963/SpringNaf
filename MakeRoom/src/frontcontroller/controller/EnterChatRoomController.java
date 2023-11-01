package frontcontroller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnterChatRoomController implements Controller {

	@Override
	public String Dohandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "client";
	}

}
