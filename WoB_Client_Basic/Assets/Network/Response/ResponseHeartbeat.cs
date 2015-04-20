using UnityEngine;
using System.Collections;


public class ResponseHeartbeatEventArgs : ExtendedEventArgs {
	public float opponentX { get; set; }
	public float opponenty { get; set; }
	public float opponentDistanceTraveled  { get; set; }
	public short opponentGameover { get; set; }


	public ResponseHeartbeatEventArgs() {
		event_id = Constants.SMSG_HEARTBEAT;
	}
}

public class ResponseHeartbeat : NetworkResponse {
	private GameObject gameObject;
	private Running running;
	private float opponentX,opponentY,opponentDistanceTraveled;
	private short opponentGameover;

	public ResponseHeartbeat() {
		gameObject = GameObject.Find("Running");
		running = gameObject.GetComponent<Running>();
	}

	public override void parse() {

		opponentX = DataReader.ReadFloat (dataStream);
		opponentY = DataReader.ReadFloat (dataStream);
		opponentDistanceTraveled = DataReader.ReadFloat (dataStream);
		opponentGameover = DataReader.ReadShort (dataStream);


	}
	public override ExtendedEventArgs process() {

		running.Player2Move(new Vector2(opponentX, opponentY));

		ResponseHeartbeatEventArgs args = new ResponseHeartbeatEventArgs ();
		args.opponentX = opponentX;
		args.opponenty = opponentY;
		args.opponentDistanceTraveled = opponentDistanceTraveled;
		args.opponentGameover = opponentGameover;
		return args;



	}



}
