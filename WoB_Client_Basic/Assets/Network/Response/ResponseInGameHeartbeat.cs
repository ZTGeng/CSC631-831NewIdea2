//using UnityEngine;
//
//using System;
//
//public class ResponseInGameHeartbeatEventArgs : ExtendedEventArgs {
//	public short status { get; set; }
//	public string user_id { get; set; }
//	public short player_level { get; set; }
//	public int player_money { get; set; }
//	public int players { get; set; }
//	
//	public ResponseInGameHeartbeatEventArgs() {
//		event_id = Constants.SMSG_PLAYER;
//	}
//}
//
//public class ResponseInGameHeartbeat : NetworkResponse {
//	
//	private short status;
//	private string user_id;
//	private short player_level;
//	private int player_money;
//	private int players;
//	
//	public ResponseInGameHeartbeat() {
//	}
//	
//	public override void parse() {
//		status = DataReader.ReadFloat(dataStream);
//		
//		if (status == 0) {
//			players = DataReader.ReadInt (dataStream);
//		}
//	}
//	
//	public override ExtendedEventArgs process() {
//		ResponsePlayerEventArgs args = null;
//		
//		if (status == 0) {
//			args = new ResponsePlayerEventArgs();
//			args.status = status;
//			args.players = players;
//		}
//		
//		return args;
//	}
//}