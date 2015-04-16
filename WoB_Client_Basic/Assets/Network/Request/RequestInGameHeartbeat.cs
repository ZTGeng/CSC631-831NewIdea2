using UnityEngine;

using System;

public class RequestInGameHeartbeat : NetworkRequest {

/* The following test values are used for the purpose of compiling while 
 * fuctions that give a players current position, gameover status, and distance
 * traveled are being developed.
 * Delete these values when functions are developed and used here. */
	private float x;
	private float y;
	private bool gameover;
	private float distanceTraveled;

	public RequestInGameHeartbeat(float x, float y, bool gameover, 
	                              float distanceTraveled) {
		request_id = Constants.CMSG_IN_GAME_HEARTBEAT;
		this.x = x;
		this.y = y;
		this.gameover = gameover;
		this.distanceTraveled = distanceTraveled;
	}

	public void send() {
	    packet = new GamePacket(request_id);
		packet.addFloat32(x);// get X position
		packet.addFloat32(y);// get y position
		packet.addBool(gameover);// get gameover flag
		packet.addFloat32(distanceTraveled);// get distance traveled
	}
}