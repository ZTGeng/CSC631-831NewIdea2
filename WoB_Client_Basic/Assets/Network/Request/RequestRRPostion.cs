using UnityEngine;
using System.Collections;

public class RequestRRPostion : NetworkRequest {
	
	public RequestRRPostion() {
		request_id = Constants.CMSG_RRPOSITION;
	}
	
	public void send(int x, int y) {

		packet = new GamePacket(request_id);
		packet.addInt32 (x);
		packet.addInt32 (y);
	
	}
}

