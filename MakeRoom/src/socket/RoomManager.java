package socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;
public class RoomManager {
	//private List<Session> list = new ArrayList<>();
	private Map<String,Room> roomMap;
    private static RoomManager crs = new RoomManager();
    private RoomManager() {
    	 roomMap = new ConcurrentHashMap<>();
    }
    public static RoomManager getRoom() {
    	return crs;
    }
    
  
    
    public boolean enterRoom(String roomName,Session client) {
    	Room enterRoom = findRoomByName(roomName);
    	if(enterRoom == null) {
    		createRoom(roomName,client);
    		return true;
    	}
    	
    	return enterRoom.getIn(client);
    	
    }
    private void createRoom(String roomName, Session client) {
		Room newRoom = new Room();
		roomMap.put(roomName, newRoom);
		newRoom.getIn(client);
		
	}
	private Room findRoomByName(String roomName) {
    	return roomMap.get(roomName);
    }
}
