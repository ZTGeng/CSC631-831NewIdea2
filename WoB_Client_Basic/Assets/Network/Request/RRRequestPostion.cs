using UnityEngine;
using System.Collections;

public class RRRequestPostion : NetworkRequest {
	
	public RRRequestPostion() {
		request_id = Constants.CMSG_RRPOSITION;
	}
	
	public void send(string x, string y) {

		packet = new GamePacket(request_id);
		packet.addString(x);
		packet.addString(y);
	
	}
}

