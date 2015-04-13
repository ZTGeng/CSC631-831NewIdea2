using UnityEngine;

using System;

public class RequestLocation : NetworkRequest {

	public RequestLocation() {
		request_id = Constants.CMSG_LOCATION;
	}
	
	public void send(float x, float y) {
		Debug.Log ("sending location packet");
	    packet = new GamePacket(request_id);
		packet.addFloat32(x);
		packet.addFloat32(y);
	}
}