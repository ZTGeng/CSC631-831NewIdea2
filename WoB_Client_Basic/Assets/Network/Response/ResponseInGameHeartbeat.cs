using UnityEngine;

using System;

public class ResponseInGameHeartbeatEventArgs : ExtendedEventArgs {
	public short status { get; set; }
	public float opponentX { get; set; }
	public float opponentY { get; set; }
	public float opponentDistanceTraveled { get; set; }
	public bool gameover { get; set; }
	
	public ResponseInGameHeartbeatEventArgs() {
		event_id = Constants.SMSG_IN_GAME_HEARTBEAT;
	}
}

public class ResponseInGameHeartbeat : NetworkResponse {
	
	private short status;
	private float opponentX;
	private float opponentY;
	private float opponentDistanceTraveled;
	private bool gameover;

	public override void parse() {
		status = DataReader.ReadShort(dataStream);
		
		if (status == 0) {
			opponentX = DataReader.ReadFloat(dataStream);
			opponentY = DataReader.ReadFloat(dataStream);
			gameover = DataReader.ReadBool(dataStream);
			opponentDistanceTraveled = DataReader.ReadFloat(dataStream);
		}

		// Update opponents data with new functions at this point.

	}
	
	public override ExtendedEventArgs process() {
		ResponseInGameHeartbeatEventArgs args = null;
		
		if (status == 0) {
			args = new ResponseInGameHeartbeatEventArgs();
			args.status = status;
			args.opponentX = opponentX;
			args.opponentY = opponentY;
			args.opponentDistanceTraveled = opponentDistanceTraveled;
			args.gameover = gameover;
		}
		
		return args;
	}
}