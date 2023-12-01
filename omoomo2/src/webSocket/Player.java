package webSocket;

import javax.websocket.Session;

public class Player {
	private Session user;
	private UserStatus status;
	public Player(Session session) {
		status = UserStatus.unready;
	}
	
	public boolean isReady() {
		return status.isReady(this.status);
	}
	public void setReady() {
		status = UserStatus.ready;
	} 
	public boolean isMe(Session session) {
		return user==session;
	}

	public Session getSession() {
		
		return user;
	}
	
}
