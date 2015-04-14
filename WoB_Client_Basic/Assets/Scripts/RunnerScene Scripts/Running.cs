﻿using UnityEngine;
using System.Collections;

public class Running : MonoBehaviour {

	public GameObject player1;
	public GameObject player2;
	private bool flag = true;

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
		Player2Move( new Vector2(player1.transform.position.x, player1.transform.position.y + 3) );
		HeartBeat();
		flag = true;
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
