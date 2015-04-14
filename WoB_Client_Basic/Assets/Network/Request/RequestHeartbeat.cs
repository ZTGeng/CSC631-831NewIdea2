using UnityEngine;

using System;

public class RequestHeartbeat : NetworkRequest {

	public RequestHeartbeat() {
		request_id = Constants.CMSG_HEARTBEAT;
	}
	
	public void send(float x,float y) {
	
	    packet = new GamePacket(request_id);
		packet.addFloat32 (x);
		packet.addFloat32 (y);

	}
}