package webSocket;

import java.util.List;
import java.util.Vector;

import javax.websocket.Session;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Room {
	private List<Player> list;
	private OmokWebSocket omokServer;
	
	public Room(Session player, OmokWebSocket omServer) {
		list = new Vector<>();
		Player p1 = new Player(player);
		list.add(p1);
		omokServer = omServer;
	}
	
	public boolean isInRoom(Session session) {
		
		for(Player s: list) {
			if(s.isMe(session))return true;
		}
		
		return false;
	}
	
	
	public void getMessage(Session session, String message) {
		
		//메시지 파싱 (근데 room이 할일은 아님 빼야함) 
		JsonParser parser = new JsonParser();
		JsonObject jo = (JsonObject)parser.parse(message);
		
		String command = jo.get("command").getAsString();
		
		if("init".equals(command)) {
			
			String name = jo.get("name").getAsString();
			String mess = name+"님이 입장하셨습니다.\n";
			sendMessage(mess);
		
		}else if("put".equals(command)) {
			
			String name = jo.get("name").getAsString();
			String position = jo.get("position").getAsString();
			String color = jo.get("color").getAsString();
			sendMessage(name+"님의 좌표 ="+position+'\n');
			
		}else if("message".equals(command)){
			
			String name = jo.get("name").getAsString();
			String uerMess = jo.get("message").getAsString();
			String mess = name+" : "+uerMess+"\n";
			sendMessage(mess);
		}else {
			
		}
	}
	
	private void sendMessage(String message) {
		try {
		for(Player s : list) {
			s.getSession().getBasicRemote().sendText(message);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
