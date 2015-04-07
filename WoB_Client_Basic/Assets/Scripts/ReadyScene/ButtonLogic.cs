using UnityEngine;
using System.Collections;

public class ButtonLogic : MonoBehaviour {

	// Use this for initialization
	void Start () {
	
	}

	// Update is called once per frame
	void Update () {
	
	}

	public void Ready(){
		//for now just go to the game scene
		Application.LoadLevel ("RunnerScene");
	}
}
