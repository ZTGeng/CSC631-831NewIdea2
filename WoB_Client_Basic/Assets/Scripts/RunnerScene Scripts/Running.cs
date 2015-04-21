using UnityEngine;
using System.Collections;

public class Running : MonoBehaviour {

	public GameObject player1;
	public GameObject player2;
	private bool flag = true;
	private ConnectionManager cManager;
	private MessageQueue messageQueue;


	
	// Use this for initialization
	void Start () {
		
	   	cManager = gameObject.GetComponent<ConnectionManager>();

		NetworkRequestTable.init();
		NetworkResponseTable.init();

		if (cManager) {
			cManager.setupSocket();
			
		}

		gameObject.GetComponent<MessageQueue>().AddCallback(Constants.SMSG_AUTH, ResponseLogin);

	}

	public void RunOnce () {

		//Debug.Log("After!!!!!!!!");	  

		player1 = GameObject.Find("Player_sprite(Clone)");
		player2 = GameObject.Find("Player_sprite_2(Clone)");
//		if (player1 != null) {
//			Debug.Log("found " + player1.transform.position);
//		}

	}

	private void Player2Move(Vector2 newVect) {
		player2.transform.position = newVect;
	}

	private void HeartBeat() {
		// The Heart Beat!!
	}

	private IEnumerator Delay() {
		//
		//Debug.Log("Before!!!!!!!!!");
		flag = false;
		yield return new WaitForSeconds(0.1f);
		//Debug.Log("inside!!!!!!!!!");
//		RequestHeartbeat rh = new RequestHeartbeat ();
//		rh.send (player1.transform.position.x, player1.transform.position.y);
//		cManager.send (rh);
//		Player2Move( new Vector2(player1.transform.position.x, player1.transform.position.y + 3) );
		//HeartBeat();
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
	
	// Update is called once per frame
	void Update () {

		if (flag) {
			StartCoroutine(Delay());
		}

		//Debug.Log("this gets called");
		//Debug.Log("outside!!!!!!!!!");

	}
}
