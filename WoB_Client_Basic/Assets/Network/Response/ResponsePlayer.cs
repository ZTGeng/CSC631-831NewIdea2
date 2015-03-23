using UnityEngine;

using System;

public class ResponsePlayerEventArgs : ExtendedEventArgs {
	public short status { get; set; }
	public string user_id { get; set; }
	public short player_level { get; set; }
	public int player_money { get; set; }
	public int players { get; set; }
	
	public ResponsePlayerEventArgs() {
		event_id = Constants.SMSG_PLAYER;
	}
}

public class ResponsePlayer : NetworkResponse {
	
	private short status;
	private string user_id;
	private short player_level;
	private int player_money;
	private int players;
	
	public ResponsePlayer() {
	}
	
	public override void parse() {
		status = DataReader.ReadShort(dataStream);
		
		if (status == 0) {
			players = DataReader.ReadInt (dataStream);
		}
	}
	
	public override ExtendedEventArgs process() {
		ResponsePlayerEventArgs args = null;
		
		if (status == 0) {
			args = new ResponsePlayerEventArgs();
			args.status = status;
			args.players = players;
		}
		
		return args;
	}
}