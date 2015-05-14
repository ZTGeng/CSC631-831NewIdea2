using UnityEngine;
using System.Collections;
using UnityEngine.UI;
using UnityEngine.EventSystems;

namespace RR {
	public class EndGameManager : MonoBehaviour {
	
		public Canvas canvas;
		public EventSystem sys;
	
		private GameObject obj;
		// Use this for initialization
		void Start () {
			
		}
		
		// Update is called once per frame
		void Update () {
			
		}
	
		public void backButton(){
			Application.LoadLevel ("RRSelectionScene");
		}
	}
}