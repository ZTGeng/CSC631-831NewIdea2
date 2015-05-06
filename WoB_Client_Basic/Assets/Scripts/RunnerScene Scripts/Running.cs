﻿using UnityEngine;
using System.Collections;

public class Running : MonoBehaviour {

	public GameObject mainObject;
	public GameObject player1;
	public GameObject player2;
	private bool flag = true;
	private ConnectionManager cManager;
	private MessageQueue messageQueue;
	private short gameState;

	
	// Use this for initialization
	void Start () {
		mainObject = GameObject.Find("MainObject");

	   	cManager = mainObject.GetComponent<ConnectionManager>();

	    

//	    if (cManager) {
//		    cManager.SetupSocket();
		
//	    }

        gameObject.GetComponent<MessageQueue>().AddCallback(Constants.SMSG_AUTH, ResponseLogin);
	    gameObject.GetComponent<MessageQueue>().AddCallback(Constants.SMSG_AUTH, ResponseGameState);

	}

	public void RunOnce () {

		//Debug.Log("After!!!!!!!!");	  

		player1 = GameObject.Find("Player_sprite(Clone)");
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
			RequestRRPostion rp = new RequestRRPostion ();
			rp.send ((int) player1.transform.position.x,(int) player1.transform.position.y);
			cManager.Send (rp);
			Debug.Log("send position reqeust");
			
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

//        Debug.Log("PLAYER 1 = " + player1.transform.position);
   //     Debug.Log("PLAYER 2 = " + player2.transform.position);

		if (flag) {
		StartCoroutine(Delay());
		}


		//Debug.Log("this gets called");
		//Debug.Log("outside!!!!!!!!!");
		if (Input.GetKeyDown(KeyCode.LeftArrow))
		{
			RequestKeyboard rk = new RequestKeyboard();
			rk.send(1,-1);
			cManager.Send (rk);

		}
		
		if (Input.GetKeyDown(KeyCode.RightArrow))
		{

			RequestKeyboard rk = new RequestKeyboard();
			rk.send(1,1);
			cManager.Send (rk);

		}
		
		if (Input.GetKeyDown(KeyCode.Space))
		{

			Debug.Log("space  down");

			RequestKeyboard rk = new RequestKeyboard();
			rk.send(2,1);
			cManager.Send (rk);
		}




		if (Input.GetKeyUp(KeyCode.LeftArrow))
		{
			RequestKeyboard rk = new RequestKeyboard();
			rk.send(1,0);
			cManager.Send (rk);
		}
		
		if (Input.GetKeyUp(KeyCode.RightArrow))
		{

			RequestKeyboard rk = new RequestKeyboard();
			rk.send(1,0);
			cManager.Send (rk);
			
		}

		if (Input.GetKeyUp(KeyCode.Space))
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
