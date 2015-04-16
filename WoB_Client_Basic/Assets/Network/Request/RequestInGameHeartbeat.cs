using UnityEngine;

using System;

public class RequestInGameHeartbeat : NetworkRequest {

/* The following test values are used for the purpose of compiling while 
 * fuctions that give a players current position, gameover status, and distance
 * traveled are being developed.
 * Delete these values when functions are developed and used here. */
	private float floatValue;
	private bool boolValue;

	public RequestInGameHeartbeat() {
		request_id = Constants.CMSG_IN_GAME_HEARTBEAT;
	}

	public void send() {
	    packet = new GamePacket(request_id);
		packet.addFloat32(floatValue);// get X position
		packet.addFloat32(floatValue);// get y position
		packet.addBool(boolValue);// get gameover flag
		packet.addFloat32(floatValue);// get distance traveled
	}
}