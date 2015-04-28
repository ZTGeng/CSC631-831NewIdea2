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
		
		//SpeciesTable.initialize();
	}
	
	// Use this for initialization
	void Start () {
		Application.LoadLevel("Login");

		ConnectionManager cManager = gameObject.GetComponent<ConnectionManager>();

		if (cManager) {
			cManager.SetupSocket();

			StartCoroutine(RequestHeartbeat(1f));
		}
	}
		
	
	// Update is called once per frame
	void Update () {
		
	}

	public IEnumerator RequestHeartbeat(float time) {
		yield return new WaitForSeconds(time);
		
		ConnectionManager cManager = gameObject.GetComponent<ConnectionManager>();
		
		if (cManager) {
			RequestHeartbeat request = new RequestHeartbeat();
			request.Send();
			
			cManager.Send(request);
		}
		
        //originially 1f changed to .1f
		StartCoroutine(RequestHeartbeat(.01f));
	}
	// public GameObject CreateMessageBox(string message) {
	// 	GameObject messageBox = Instantiate(Resources.Load (Constants.PREFAB_RESOURCES_PATH + "MessageBox")) as GameObject;
	// 	messageBox.GetComponent<MessageBox>().setMessage(message);
		
	// 	return messageBox;
	// }
}
