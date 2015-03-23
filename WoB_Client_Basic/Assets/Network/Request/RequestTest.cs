
using UnityEngine;

using System;

public class RequestTest : NetworkRequest {
	
	public RequestTest() {
		request_id = Constants.CMSG_TEST;
	}
	
	public void send(string operation) {
		packet = new GamePacket(request_id);
		packet.addString(operation);
	}
}