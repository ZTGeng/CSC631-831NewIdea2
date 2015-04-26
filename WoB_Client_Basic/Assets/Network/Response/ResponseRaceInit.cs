//author: Ye
using UnityEngine;

using System;

public class ResponseRaceStartEventArgs : ExtendedEventArgs {
	public short status { get; set; }
	
	public ResponseRaceStartEventArgs() {
		event_id = Constants.SMSG_RACE_INIT;
	}
}

public class ResponseRaceStart : NetworkResponse {
	
	private short status;//start a battle: 0; wait for a battle: 1
	
	public ResponseRaceStart() {
	}
	
	public override void parse() {
		status = DataReader.ReadShort(dataStream);
		//		Battle.stopSendRequest();
		if (status == 0) {
			//Debug.Log("Battle Preparation Started");
			//change to battle scene
			//when the battle is ended, change stopSendRequest to true;
		}
		else if (status ==1) {
			Debug.Log("request received by server, wait for a race");
		}
	}
	
	public override ExtendedEventArgs process() {
		ResponseRaceStartEventArgs args = null;
		
		args = new ResponseRaceStartEventArgs();
		args.status = status;
		
		if (status == 0) {
			//battle start, stop sending battle request
		} else if (status == 1) {
			//battle not start, continue sending battle request
			
		}
		return args;
	}
}
