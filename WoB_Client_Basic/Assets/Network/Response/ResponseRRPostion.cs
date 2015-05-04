using UnityEngine;
using System.Collections;



public class ResponseRRPositionEventArgs : ExtendedEventArgs {
	public int  x { get; set; }
	public int  y { get; set; }
	
	public ResponseRRPositionEventArgs() {
		event_id = Constants.SMSG_RRPOSITION;
	}
}

public class ResponseRRPostion : NetworkResponse {

		private int x;
		private int y;

		private GameObject g;
		private Running[] p2;

		public ResponseRRPostion() { }

		public override void parse() {
			x = DataReader.ReadInt(dataStream);
			y = DataReader.ReadInt(dataStream);
		}



		public override ExtendedEventArgs process() {
		Debug.Log ("loationResponse");

		ResponseRRPositionEventArgs args = new ResponseRRPositionEventArgs ();
		g = GameObject.Find ("GameLogic");
		p2 = g.GetComponents<Running> ();
		Debug.Log ("x = "+ x + "\ny = " + y );
		p2[0].player2.transform.position = new Vector3((float)x,(float)y,0f);
	




			args.x = x;
			args.y = y;
			return args;

		}







}
