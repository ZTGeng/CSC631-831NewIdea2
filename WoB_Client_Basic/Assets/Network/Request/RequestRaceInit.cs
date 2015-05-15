using UnityEngine;

using System;
using System.Collections.Generic;
namespace RR{
public class RequestRaceInit : NetworkRequest {
	
	public RequestRaceInit() {
		packet = new GamePacket(request_id = Constants.CMSG_RACE_INIT);
	}
	
	public void Send(int playerid) {
		packet.addInt32(playerid);
	}
}
}