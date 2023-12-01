package webSocket;

public enum UserStatus {
	ready,unready;

	boolean isReady(UserStatus status) {
		
		return status == ready;
	}
}
