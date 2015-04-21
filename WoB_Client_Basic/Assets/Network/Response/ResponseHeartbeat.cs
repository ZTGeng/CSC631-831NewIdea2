using UnityEngine;
using System.Collections;

public class ResponseHeartbeatEventArgs : ExtendedEventArgs {
	
	public float x { get; set; }
	public float y { get; set; }
	public float opponentDistanceTraveled { get; set; }
	public bool gameover { get; set; }
	
	public ResponseHeartbeatEventArgs() {
		event_id = Constants.SMSG_HEARTBEAT;
	}
	
	
}






public class ResponseHeartbeat : NetworkResponse {


	private float x ;
	private float y ;
	private float opponentDistanceTraveled;
	private bool gameover;


	public override void parse() {

		x = DataReader.ReadFloat(dataStream);
		y = DataReader.ReadFloat(dataStream);
		opponentDistanceTraveled = DataReader.ReadFloat (dataStream);
		gameover = DataReader.ReadBool (dataStream);


	}
	public override ExtendedEventArgs process() {
		ResponseHeartbeatEventArgs args = new ResponseHeartbeatEventArgs ();
		args.x = x;
		args.y = y;
		args.opponentDistanceTraveled = opponentDistanceTraveled;
		args.gameover = gameover;
		return args;
	

	}







}




