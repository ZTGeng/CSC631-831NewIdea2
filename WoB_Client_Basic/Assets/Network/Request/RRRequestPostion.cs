﻿using UnityEngine;
using System.Collections;

public class RRRequestPostion : NetworkRequest {
	
	public RRRequestPostion() {
		request_id = Constants.CMSG_RRPOSITION;
	}
	
<<<<<<< HEAD
	public void send(int x, int y) {

		packet = new GamePacket(request_id);
		packet.addInt32 (x);
		packet.addInt32 (y);
=======
	public void send(string x, string y) {

		packet = new GamePacket(request_id);
		packet.addString(x);
		packet.addString(y);
>>>>>>> Dong
	
	}
}

