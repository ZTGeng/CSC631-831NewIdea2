using UnityEngine;
using System.Collections;

[RequireComponent(typeof(PlayerPhysics))]
public class PlayerController : MonoBehaviour {
	
	// Player Handling
	public float gravity = 20;
	public float speed = 16;
	public float acceleration = 80;
	public float jumpHeight = 12;
	
	private float currentSpeed;
	private float targetSpeed;
	private Vector2 amountToMove;

	private bool wallJumped;
	
	private PlayerPhysics playerPhysics;
	
	
	void Start () {
		playerPhysics = GetComponent<PlayerPhysics>();
	}
	
	void Update () {
		wallJumped = true;

		//Reseting speeds if collide with wall
		if (playerPhysics.movementStopped) {
			targetSpeed = 0;
			currentSpeed = 0;

			if(!playerPhysics.grounded)
				wallJumped = false;

		}

		targetSpeed = Input.GetAxisRaw("Horizontal") * speed;
		currentSpeed = IncrementTowards(currentSpeed, targetSpeed, acceleration);

		// Check if on ground then jump
		if (playerPhysics.grounded) {
			amountToMove.y = 0;
			
			// Jump
			if (Input.GetButtonDown("Jump")) {
				amountToMove.y = jumpHeight;	
			}
		}

		// Wall jump
		if (!playerPhysics.grounded && playerPhysics.movementStopped && targetSpeed != 0) {

			if(Input.GetButtonDown ("Jump")) {
				amountToMove.y = jumpHeight;
				currentSpeed = IncrementTowards ( 10 * ((targetSpeed/Mathf.Abs(targetSpeed)*-1)) , targetSpeed * -1, 100);
			} 
		}
		
		amountToMove.x = currentSpeed;
		amountToMove.y -= (gravity * Time.deltaTime);
		playerPhysics.Move(amountToMove * Time.deltaTime);
	}
	
	// Increase n towards target by speed
	private float IncrementTowards(float n, float target, float a) {
		if (n == target) {
			return n;	
		}
		else {
			float dir = Mathf.Sign(target - n); // must n be increased or decreased to get closer to target
			n += a * Time.deltaTime * dir;
			return (dir == Mathf.Sign(target-n))? n: target; // if n has now passed target then return target, otherwise return n
		}
	}
}
