using UnityEngine;

using System;

public class RequestHeartbeat : NetworkRequest {

	public RequestHeartbeat() {
		request_id = Constants.CMSG_HEARTBEAT;
	}
	
	public void Send() {
		packet = new GamePacket(request_id);
	}
}