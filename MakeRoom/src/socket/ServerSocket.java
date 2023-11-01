package socket;

import java.io.IOException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;

import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/soc/{name}")

public class ServerSocket {
	private static List<Session> sessionList = new ArrayList<>();
	private static RoomManager roomManager = RoomManager.getRoom();
	
	@OnOpen
	public void serverOpen(Session session,@PathParam("name") String name ) {
		System.out.println("server open");
		System.out.println(session.getId()+" room+name = "+name);
		sessionList.add(session);
		boolean enterResult = roomManager.enterRoom(name, session);
		if(!enterResult) {
			try {
				System.out.println("연결안됨");
				session.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	@OnMessage
	public void message(Session session, @PathParam("name") String name, String message) {
//		
		//try {
//			message = URLEncoder.encode(message,"utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
		
		System.out.println(session.getId()+" message = "+message+" name = "+name);
		sessionList.stream().filter(s -> {
			return !(s.getId().equals(session.getId()));
		}).forEach(s -> {
			try {
				s.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
	}
	//클라이언트와 연결이 끊어질 때 
	@OnClose
	public String mss(Session session){
		System.out.println(session.getId()+"와 연결이 끊김");
		return null;
	}
	

	
}
