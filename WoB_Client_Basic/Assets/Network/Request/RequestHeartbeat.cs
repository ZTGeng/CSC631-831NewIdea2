using UnityEngine;

using System;

public class RequestHeartbeat : NetworkRequest {

	public RequestHeartbeat() {
		request_id = Constants.CMSG_HEARTBEAT;
	}
	
	public void send(int x, int y, int playerDistanceTraveled, short gameover) {
	
	    packet = new GamePacket(request_id);
		packet.addInt32 (x);
		packet.addInt32 (y);
		packet.addInt32 (playerDistanceTraveled);
		packet.addShort16 (gameover);

	}
}