using UnityEngine;

using System;
using System.Collections.Generic;
namespace RR{
public class RequestRRStartGame : NetworkRequest {
	
	public RequestRRStartGame() {
		packet = new GamePacket(request_id = Constants.CMSG_RRSTARTGAME);
	}
	
	public void Send(int playerid) {
		packet.addInt32(playerid);
	}
}
}