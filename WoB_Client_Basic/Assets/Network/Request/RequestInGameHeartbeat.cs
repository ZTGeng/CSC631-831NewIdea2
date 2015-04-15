using UnityEngine;

using System;

public class RequestInGameHeartbeat : NetworkRequest {

	public RequestInGameHeartbeat() {
		request_id = Constants.CMSG_IN_GAME_HEARTBEAT;


	}
	
	public void send() {
	    packet = new GamePacket(request_id);
		packet.addFloat32();// get X position
		packet.addFloat32();// get y position
		packet.addBool();// get gameover flag
		packet.addFloat32();//get distance traveled
	}
}