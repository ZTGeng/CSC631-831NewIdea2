using UnityEngine;
using System.Collections;



public class RRResponsePositionEventArgs : ExtendedEventArgs {
	public float  x { get; set; }
	public float  y { get; set; }
	
	public RRResponsePositionEventArgs() {
		event_id = Constants.SMSG_RRPOSITION;
	}
}

public class RRResponsePostion : NetworkResponse {

		private float x;
		private float y;

		private GameObject g;
		private Running[] p2;

		public RRResponsePostion() { }

		public override void parse() {
			x = DataReader.ReadFloat(dataStream);
			y = DataReader.ReadFloat(dataStream);
		}



		public override ExtendedEventArgs process() {
		Debug.Log ("loationResponse");

		RRResponsePositionEventArgs args = new RRResponsePositionEventArgs ();
		g = GameObject.Find ("GameLogic");
		p2 = g.GetComponents<Running> ();
		Debug.Log ("response:    x = "+ x + "\ny = " + y );
		p2[0].player2.transform.position = new Vector3(x,y,0f);
	




			args.x = x;
			args.y = y;
			return args;

		}







}
