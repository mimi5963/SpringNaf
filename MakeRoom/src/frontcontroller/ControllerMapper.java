package frontcontroller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import frontcontroller.controller.Controller;
import frontcontroller.controller.EnterChatRoomController;
import frontcontroller.controller.GoHomeController;
import frontcontroller.controller.LoginController;
import frontcontroller.controller.LogoutController;
import frontcontroller.controller.RegisterController;

public class ControllerMapper {
	private static Map<String,Controller> mapper = new ConcurrentHashMap<>();
	
	public ControllerMapper() {
		mapper.put("/register.do", new RegisterController());
		mapper.put("/home.do",new GoHomeController());
		mapper.put("/login.do", new LoginController());
		mapper.put("/logout.do", new LogoutController());
		mapper.put("/enterChatRoom.do", new EnterChatRoomController());
	}
	public Controller getMappedController(String uri) {
	
		return mapper.get(uri);
	}
}
