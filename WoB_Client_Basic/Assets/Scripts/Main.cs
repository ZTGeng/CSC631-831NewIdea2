using UnityEngine;

using System.Collections;
using System.Collections.Generic;

public class Main : MonoBehaviour {

	void Awake() {
		DontDestroyOnLoad(gameObject);
		
		gameObject.AddComponent("MessageQueue");
		gameObject.AddComponent("ConnectionManager");

		NetworkRequestTable.init();
		NetworkResponseTable.init();
		
		SpeciesTable.initialize();
	}
	
	// Use this for initialization
	void Start () {
		Application.LoadLevel("Login");
	}
		
	
	// Update is called once per frame
	void Update () {
		
	}

	// public GameObject CreateMessageBox(string message) {
	// 	GameObject messageBox = Instantiate(Resources.Load (Constants.PREFAB_RESOURCES_PATH + "MessageBox")) as GameObject;
	// 	messageBox.GetComponent<MessageBox>().setMessage(message);
		
	// 	return messageBox;
	// }
}
