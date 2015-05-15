using UnityEngine;
using System.Collections;
using UnityEngine.UI;
using UnityEngine.EventSystems;

namespace RR {
	public class EndGameManager : MonoBehaviour {
	
		public Canvas canvas;
		public EventSystem sys;
		public bool called = true;
	
		private GameObject obj;
		// Use this for initialization
		void Start () {
			
		}
		
		// Update is called once per frame
		void Update () {
			if (PlayerPrefs.GetInt ("Win") >= 0 && called) {
				Debug.Log ("Winning Time is: " + PlayerPrefs.GetString ("Winning Time"));
				if (PlayerPrefs.GetInt ("Win") == 1) {
					Debug.Log ("YOU WIN!");
				} else {
					Debug.Log ("YOU LOSE!");
					called = false;
				}
			}
		}
	
		public void backButton(){
			Application.LoadLevel ("RRSelectionScene");
		}
	}
}