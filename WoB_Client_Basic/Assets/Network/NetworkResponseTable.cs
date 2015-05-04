using UnityEngine;

using System;
using System.Collections.Generic;
using System.Reflection;

public class NetworkResponseTable {

	public static Dictionary<short, Type> responseTable { get; set; }
	
	public static void init() {
		responseTable = new Dictionary<short, Type>();
		
		add(Constants.SMSG_AUTH, "ResponseLogin");
		add(Constants.SMSG_HEARTBEAT, "ResponseHeartbeat");
		add(Constants.SMSG_GAME_STATE, "ResponseGameState");
		add(Constants.SMSG_RACE_INIT, "ResponseRaceInit");
		add(Constants.SMSG_KEYBOARD, "ResponseKeyboard");
		add(Constants.SMSG_RRPOSITION, "RRResponsePostion");
		add(Constants.SMSG_RRSPECIES, "RRResponseSpecies");


	}
	
	public static void add(short response_id, string name) {
		responseTable.Add(response_id, Type.GetType(name));
	}
	
	public static NetworkResponse get(short response_id) {
		NetworkResponse response = null;
		
		if (responseTable.ContainsKey(response_id)) {
			response = (NetworkResponse) Activator.CreateInstance(responseTable[response_id]);
			response.response_id = response_id;
		} else {
			Debug.Log("Response [" + response_id + "] Not Found");
			Debug.Log (response.ToString());
		}
		
		return response;
	}
}
