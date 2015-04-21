using UnityEngine;

using System;

public class RequestHeartbeat : NetworkRequest {

	public RequestHeartbeat() {
		request_id = Constants.CMSG_HEARTBEAT;
	}
	
	public void send(float x,float y,float playerDistanceTraveled,Boolean gameover) {
	
	    packet = new GamePacket(request_id);
		packet.addString (x.ToString());
		packet.addString (y.ToString());
		packet.addString (playerDistanceTraveled.ToString());
		packet.addBool (gameover);

	}
}