using UnityEngine;
using System.Collections;

public class Running : MonoBehaviour {

	public GameObject mainObject;
	public static GameObject player1;
	public GameObject player2;
	public float time;
	private bool flag = true;
	private static bool speedUpFlag = true;
	private static bool speedDownFlag = true;
	private ConnectionManager cManager;
	private MessageQueue messageQueue;
	private short gameState;
	//public static bool player1touchitem1 = false;
	//public static string hitItem = "";

	private const float SPEED_INCREASE = 5;
	private const float SPEED_DECREASE = -5;


	static void ChangeSpeed(float boost) {
		PlayerController[] pcontroller = player1.GetComponents<PlayerController>();
		float originalSpeed = pcontroller[0].speed;
		pcontroller[0].speed = originalSpeed + boost;
	}

	public static void hitOnItem(string name) {

		if (GameManager.relationship["animal4"].ContainsKey(name)) {
			if (speedUpFlag) {
				Debug.Log(name + " is hit!!! for speed UP");
				ChangeSpeed(SPEED_INCREASE);
				speedUpFlag = false;
			}
		} else if (GameManager.relationship[name].ContainsKey("animal4")) {
			if (speedDownFlag) {
				Debug.Log(name + " is hit!!! for speed DOWN");
				ChangeSpeed(SPEED_DECREASE);
				speedDownFlag = false;
			}
		}

	}

	
	void OnGUI(){
		GUIStyle myStyle = new GUIStyle();
		myStyle.normal.textColor = Color.blue;
	
		GUI.Label (new Rect (Screen.width - 150, 0, 200, 100), "Running Time:  " +time, myStyle);
	
	}
	void Start () {
//<<<<<<< HEAD
//		mainObject = GameObject.Find("MainObject");
//
//	   	cManager = mainObject.GetComponent<ConnectionManager>();
//
//=======
		time = 0.0f;
		mainObject = GameObject.Find("MainObject");


	   	cManager = mainObject.GetComponent<ConnectionManager>();

//<<<<<<< HEAD
//>>>>>>> Dong
//	    NetworkRequestTable.init();
//	    NetworkResponseTable.init();
//=======
	    
//>>>>>>> start

//	    if (cManager) {
//		    cManager.SetupSocket();
		
//	    }

        gameObject.GetComponent<MessageQueue>().AddCallback(Constants.SMSG_AUTH, ResponseLogin);
	    gameObject.GetComponent<MessageQueue>().AddCallback(Constants.SMSG_AUTH, ResponseGameState);

	}

	public void RunOnce () {

		//Debug.Log("After!!!!!!!!");	  

		//player1 = GameObject.Find("Player_sprite(Clone)");
		player2 = GameObject.Find("Player_sprite_2(Clone)");
//		if (player1 != null) {
//			Debug.Log("found " + player1.transform.position);
//		}

	}

	public void Player2Move(Vector2 newVect) {
		player2.transform.position = newVect;
	}

	private void HeartBeat() {
		// The Heart Beat!!
	}

	private static IEnumerator SpeedUpDelay() {
		speedUpFlag = true;
		yield return new WaitForSeconds(1f);
	}

	private static IEnumerator SpeedDownDelay() {
		speedDownFlag = true;
		yield return new WaitForSeconds(1f);
	}

	private IEnumerator Delay() {
		//
		//Debug.Log("Before!!!!!!!!!");
		flag = false;
		yield return new WaitForSeconds(4f);
	//	Debug.Log("inside!!!!!!!!!");
//		if (gameState == 0){
//			RequestGameState rg = new RequestGameState ();
//			rg.send ();
//			cManager.send (rg);
//		} else {
//			RequestHeartbeat rh = new RequestHeartbeat ();
//			rh.send ((int) player1.transform.position.x, (int)player1.transform.position.y, 0, 0);
//			cManager.send (rh);
//		}
//		Player2Move( new Vector2(player1.transform.position.x, player1.transform.position.y + 3) );
		//HeartBeat();

		if (cManager) {
//<<<<<<< HEAD
			RequestRRPostion rp = new RequestRRPostion ();
//<<<<<<< HEAD
//=======
//			RequestRRPostion rp = new RequestRRPostion ();
//>>>>>>> start
//			rp.send ((int) player1.transform.position.x,(int) player1.transform.position.y);
//			cManager.Send (rp);
//			Debug.Log("send position reqeust");
////=======
			rp.send ((player1.transform.position.x).ToString(), (player1.transform.position.y).ToString());
			cManager.Send (rp);

//>>>>>>> Dong
			
		}



		flag = true;
	}

	public void ResponseLogin(ExtendedEventArgs eventArgs) {
		ResponseLoginEventArgs args = eventArgs as ResponseLoginEventArgs;
		
		if (args.status == 0) {
			Constants.USER_ID = args.user_id;
		} else {
			Debug.Log("Login Failed");
		}
	}

	public void ResponseGameState(ExtendedEventArgs eventArgs) {
		ResponseLoginEventArgs args = eventArgs as ResponseLoginEventArgs;
		
		if (args.status == 0) {
			Constants.USER_ID = args.user_id;
		} else {
			Debug.Log("Response GameState Failed"); // Don't know what comment should be made here
		}
	}
	
	// Update is called once per frame
	void Update () {
		time += Time.deltaTime;
//        Debug.Log("PLAYER 1 = " + player1.transform.position);
   //     Debug.Log("PLAYER 2 = " + player2.transform.position);

		if (flag) {
			StartCoroutine(Delay());
		}

		if (!speedUpFlag) {
			StartCoroutine(SpeedUpDelay());
		}

		if (!speedDownFlag) {
			StartCoroutine(SpeedDownDelay());
		}

		if (Input.GetKeyDown(KeyCode.LeftArrow))
		{
			if(cManager)
			{
			RequestKeyboard rk = new RequestKeyboard();
			rk.send(1,-1);
			cManager.Send (rk);
//<<<<<<< HEAD
//=======
			}
//>>>>>>> Dong

		}
		
		if (Input.GetKeyDown(KeyCode.RightArrow))
		{

			if(cManager)
			{
			RequestKeyboard rk = new RequestKeyboard();
			rk.send(1,1);
			cManager.Send (rk);
//<<<<<<< HEAD
//=======
			}
//>>>>>>> Dong

		}
		
		if (Input.GetKeyDown(KeyCode.Space))
		{


			if(cManager)
			{
			RequestKeyboard rk = new RequestKeyboard();
			rk.send(2,1);
			cManager.Send (rk);
//<<<<<<< HEAD
//=======
			}
//>>>>>>> Dong
		}




		if (Input.GetKeyUp(KeyCode.LeftArrow) && cManager)
		{
			RequestKeyboard rk = new RequestKeyboard();
			rk.send(1,0);
			cManager.Send (rk);
		}
		
		if (Input.GetKeyUp(KeyCode.RightArrow) &&cManager)
		{

			RequestKeyboard rk = new RequestKeyboard();
			rk.send(1,0);
			cManager.Send (rk);
			
		}

		if (Input.GetKeyUp(KeyCode.Space) && cManager)
		{

			RequestKeyboard rk = new RequestKeyboard();
			rk.send(2,0);
			cManager.Send (rk);
			
		}



//		if (cManager) {
//			RRRequestPostion rp = new RRRequestPostion ();
//			rp.send ((int)player2.transform.position.x,(int) player2.transform.position.y);
//			cManager.Send (rp);
//			Debug.Log("send position reqeust");
//			
//		}
	
	}

	public void SetGameStateOn(){
		gameState = 1;
	}

}
