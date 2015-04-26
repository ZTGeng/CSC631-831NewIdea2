using UnityEngine;

using System;
using System.Collections.Generic;

public class RequestRaceStart : NetworkRequest {
	
	public RequestRaceStart() {
		packet = new GamePacket(request_id = Constants.CMSG_RACE_INIT);
	}
	
	public void Send(int playerid) {
		packet.addInt32(playerid);
	}
}