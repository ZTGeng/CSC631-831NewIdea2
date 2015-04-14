using UnityEngine;
using System.Collections;

public class ButtonLogic : MonoBehaviour {

	void Awake() {
		DontDestroyOnLoad(gameObject);
		
		gameObject.AddComponent("MessageQueue");
		gameObject.AddComponent("ConnectionManager");

	}
	
	// Use this for initialization
	void Start () {

		ConnectionManager cManager = gameObject.GetComponent<ConnectionManager>();
		
		if (cManager) {
			cManager.setupSocket();

		}
	}


	public void Ready(){
		//for now just go to the game scene
		Application.LoadLevel ("RunnerScene");
	}

}
