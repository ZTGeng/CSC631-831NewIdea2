using UnityEngine;
using System.Collections;


public class ResponseInGameHeartbeatEventArgs : ExtendedEventArgs {
	public float opponentX { get; set; }
	public float opponenty { get; set; }
	public float opponentDistanceTraveled  { get; set; }


	public ResponseInGameHeartbeatEventArgs() {
		event_id = Constants.SMSG_IN_GAME_HEARTBEAT;
	}
}

public class ResponseInGameHeartbeat : NetworkResponse {
	private float opponentX,opponentY,opponentDistanceTraveled;

	public ResponseInGameHeartbeat() {

	}
	public override void parse() {

		opponentX = DataReader.ReadFloat (dataStream);
		opponentY = DataReader.ReadFloat (dataStream);
		opponentDistanceTraveled = DataReader.ReadFloat (dataStream);


	}
	public override ExtendedEventArgs process() {

		ResponseInGameHeartbeatEventArgs args = new ResponseInGameHeartbeatEventArgs ();
		args.opponentX = opponentX;
		args.opponenty = opponentY;
		args.opponentDistanceTraveled = opponentDistanceTraveled;
		return args;



	}



}
