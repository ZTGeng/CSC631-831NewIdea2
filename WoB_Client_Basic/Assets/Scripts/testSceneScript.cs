using UnityEngine;
using System.Collections;

public class testSceneScript : MonoBehaviour {

	// Use this for initialization
	void Start () {
		/*
		Vector3 position;

		GameObject targetTerrain = GameObject.Find ("MaasaiMara");
		position = targetTerrain.transform.position;
		GameObject.Destroy (targetTerrain);

		GameObject newTerrain = Instantiate(Resources.Load ("Prefabs/MaasaiMara")) as GameObject;
		newTerrain.transform.position = position;
		*/
	}
	
	// Update is called once per frame
	void Update () {


	}

	void OnGUI(){

		if (GUI.Button (new Rect (Screen.width - 200, Screen.height - 50, 200, 50), "Go to Login")) {
			Application.LoadLevel ("Login");		
		}

		if (GUI.Button (new Rect (Screen.width - 200, Screen.height - 101, 200, 50), "Go to Runner")) { 
			Application.LoadLevel ("RunnerScene");
		}
	}
}
