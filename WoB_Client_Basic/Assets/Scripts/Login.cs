using UnityEngine;

using System;
using System.Collections;
using System.IO;
using System.Net.Sockets;

public class Login : MonoBehaviour {
	
	private GameObject mainObject;
	// Window Properties
	private float width = 280;
	private float height = 100;
	// Other
	public Texture background;
	private string user_id = "";
	private string password = "";
	private Rect windowRect;
	private bool isHidden;
	
	void Awake() {
		mainObject = GameObject.Find("MainObject");
		
		mainObject.GetComponent<MessageQueue>().AddCallback(Constants.SMSG_AUTH, ResponseLogin);
		mainObject.GetComponent<MessageQueue> ().AddCallback (Constants.SMSG_PLAYER, ResponsePlayer);
		mainObject.GetComponent<MessageQueue> ().AddCallback (Constants.SMSG_TEST, ResponseTest);
	}
	
	// Use this for initialization
	void Start() {

	}
	
	void OnGUI() {
		// Background
		GUI.DrawTexture(new Rect(0, 0, Screen.width, Screen.height), background);
		
		// Client Version Label
		GUI.Label(new Rect(Screen.width - 75, Screen.height - 30, 65, 20), "v" + Constants.CLIENT_VERSION + " Test");
		
		// Login Interface
		if (!isHidden) {
			windowRect = new Rect ((Screen.width - width) / 2, Screen.height / 2 - height, width, height);
			windowRect = GUILayout.Window((int) Constants.GUI_ID.Login, windowRect, MakeWindow, "Login");
		
			if (Event.current.type == EventType.KeyUp && Event.current.keyCode == KeyCode.Return) {
				Submit();
			}
		}

		addedGUI ();
	}

	void addedGUI(){
		if (GUI.Button (new Rect (Screen.width - 200, Screen.height - 50, 200, 50), "Go to TestScene")) {
			Application.LoadLevel ("testScene");		
		}

		if (GUI.Button (new Rect (Screen.width - 200, Screen.height - 101, 200, 50), "Go to Runner")) { 
			Application.LoadLevel ("RunnerScene");
		}
	}
	
	void MakeWindow(int id) {
		GUILayout.Label("User ID");
		GUI.SetNextControlName("username_field");
		user_id = GUI.TextField(new Rect(10, 45, windowRect.width - 20, 25), user_id, 25);

		GUILayout.Space(30);
		
		GUILayout.Label("Password");
		GUI.SetNextControlName("password_field");
		password = GUI.PasswordField(new Rect(10, 100, windowRect.width - 20, 25), password, "*"[0], 25);
		
		GUILayout.Space(75);

		if (GUI.Button(new Rect(windowRect.width / 2 - 50, 135, 100, 30), "Log In")) {
			Submit();
		}
	}
	
	public void Submit() {
		user_id = user_id.Trim();
		password = password.Trim();
		
		if (user_id.Length == 0) {
			Debug.Log("User ID Required");
			GUI.FocusControl("username_field");
		} else if (password.Length == 0) {
			Debug.Log("Password Required");
			GUI.FocusControl("password_field");
		} else {
			ConnectionManager cManager = mainObject.GetComponent<ConnectionManager>();
			
			if (cManager) {
				Debug.Log ("Connection manager found");
				cManager.send(requestLogin(user_id, password));
			}
		}
	}
	
	public RequestLogin requestLogin(string username, string password) {
		RequestLogin request = new RequestLogin();
		request.send(username, password);
		
		return request;
	}

	public RequestPlayer requestPlayer(string user_id){
		RequestPlayer request = new RequestPlayer ();
		request.send (user_id);

		return request;
	}

	public RequestTest requestTest(string operation){
		RequestTest request = new RequestTest ();
		request.send (operation);

		return request;
	}
	
	public void ResponseLogin(ExtendedEventArgs eventArgs) {
		ResponseLoginEventArgs args = eventArgs as ResponseLoginEventArgs;
		
		if (args.status == 0) {
			Constants.USER_ID = args.user_id;

			//Printing info to the console
			Debug.Log ("Username and ID\t=  " + args.username + "  " + args.user_id);
			Debug.Log ("Level\t=  " + args.player_level);
			Debug.Log ("Money\t=  " + args.player_money);	

			//Now getting player count information
			Debug.Log ("Requesting Player information");
			ConnectionManager cManager = mainObject.GetComponent<ConnectionManager>();
			cManager.send (requestPlayer(user_id));
		} else {
			Debug.Log("Login Failed");
		}
	}

	public void ResponsePlayer(ExtendedEventArgs eventArgs){
		ResponsePlayerEventArgs args = eventArgs as ResponsePlayerEventArgs;

		if (args.status == 0) {
			Debug.Log ("Players\t=" + args.players);

			ConnectionManager cManager = mainObject.GetComponent<ConnectionManager>();
			cManager.send (requestTest("+"));
			cManager.send (requestTest("*"));
		} else {
			Debug.Log ("Failed to return values");
		}
	}

	public void ResponseTest(ExtendedEventArgs EventArgs){
		ResponseTestEventArgs args = EventArgs as ResponseTestEventArgs;

		if (args.status == 0) {
			Debug.Log ("newTestVar\t=\t" + args.newTestVar);
		} else {
			Debug.Log ("Failure at operating");			
		}
	}
	
	public void Show() {
		isHidden = false;
	}
	
	public void Hide() {
		isHidden = true;
	}
	
	// Update is called once per frame
	void Update() {
	}
}
