using UnityEngine;

using System;

public class RequestHeartbeat : NetworkRequest {

	public RequestHeartbeat() {
		request_id = Constants.CMSG_HEARTBEAT;
	}
	
	public void send(float x,float y,float playerDistanceTraveled,short gameover) {
	
	    packet = new GamePacket(request_id);
		packet.addFloat32 (x);
		packet.addFloat32 (y);
		packet.addFloat32 (playerDistanceTraveled);
		packet.addShort16 (gameover);

	}
}