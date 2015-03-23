using UnityEngine;

using System;

public class ResponseTestEventArgs : ExtendedEventArgs {
	public short status { get; set; }
	public int newTestVar { get; set; }
	
	public ResponseTestEventArgs() {
		event_id = Constants.SMSG_TEST;
	}
}

public class ResponseTest : NetworkResponse {
	
	private short status;
	private int newTestVar;
	
	public ResponseTest() {
	}
	
	public override void parse() {
		status = DataReader.ReadShort(dataStream);
		
		if (status == 0) {
			newTestVar = DataReader.ReadInt (dataStream);
		}
	}
	
	public override ExtendedEventArgs process() {
		ResponseTestEventArgs args = null;
		
		if (status == 0) {
			args = new ResponseTestEventArgs();
			args.status = status;
			args.newTestVar = newTestVar;
		}
		
		return args;
	}
}
