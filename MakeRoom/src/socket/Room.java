package socket;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

public class Room {
	private List<Session> sessionList;
	
	public Room() {
		sessionList = new ArrayList<>();
	}

	public boolean getIn(Session client) {
		if(sessionList.size()>=2) {
			return false;
		}
		sessionList.add(client);
		return true;
	}
}
