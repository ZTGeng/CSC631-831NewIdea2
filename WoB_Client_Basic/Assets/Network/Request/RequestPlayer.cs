using UnityEngine;

using System;

public class RequestPlayer : NetworkRequest {
	
	public RequestPlayer() {
		request_id = Constants.CMSG_PLAYER;
	}
	
	public void send(string username) {
		packet = new GamePacket(request_id);
		packet.addString(username);
	}
}