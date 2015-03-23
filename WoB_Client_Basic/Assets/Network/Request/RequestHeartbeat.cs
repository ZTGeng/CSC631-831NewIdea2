using UnityEngine;

using System;

public class RequestHeartbeat : NetworkRequest {

	public RequestHeartbeat() {
		request_id = Constants.CMSG_HEARTBEAT;
	}
	
	public void send() {
	    packet = new GamePacket(request_id);
	}
}