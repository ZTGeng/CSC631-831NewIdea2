﻿using UnityEngine;
using System.Collections;


[RequireComponent(typeof(BoxCollider))]
public class PlayerPhysics : MonoBehaviour
{
	
	public LayerMask collisionMask;
	public LayerMask collectableMask;
	public LayerMask endFlagMask;
	public LayerMask collectableMask2;
	
	private BoxCollider collider;
	private Vector3 s;
	private Vector3 c;
	
	private float skin = .0005f;
	
	[HideInInspector]
	public bool grounded;
	[HideInInspector]
	public bool movementStopped;
	
	Ray ray;
	RaycastHit hit;


	
	void Start()
	{
		collider = GetComponent<BoxCollider>();
		s = collider.size;
		c = collider.center;
	}
	
	public void Move(Vector2 moveAmount)
	{
		
		float deltaY = moveAmount.y;
		float deltaX = moveAmount.x;
		Vector2 p = transform.position;
		
		// Check collisions above and below
		deltaY = verticleCollisions(deltaY, deltaX, p);
		
		// Check collisions left and right
		deltaX = horizontalCollisions(deltaY, deltaX, p);
		
		if (!grounded && !movementStopped)
		{
			Vector3 playerDir = new Vector3(deltaX, deltaY);
			Vector3 o = new Vector3(p.x + c.x + s.x / 2 * Mathf.Sign(deltaX), p.y + c.y + s.y / 2 * Mathf.Sign(deltaY));
			ray = new Ray(o, playerDir.normalized);
			
			if (Physics.Raycast(ray, Mathf.Sqrt(deltaX * deltaX + deltaY * deltaY), collisionMask))
			{
				grounded = true;
				deltaY = 0;
			}
		}
		
		
		Vector2 finalTransform = new Vector2(deltaX, deltaY);
		
		transform.Translate(finalTransform);
	}
	
	public float verticleCollisions(float deltaY, float deltaX, Vector2 p)
	{
		// Check collisions above and below
		grounded = false;
		
		for (int i = 0; i < 3; i++)
		{
			float dir = Mathf.Sign(deltaY);
			float x = (p.x + c.x - s.x / 2) + s.x / 2 * i; // Left, centre and then rightmost point of collider
			float y = p.y + c.y + s.y / 2 * dir; // Bottom of collider
			
			ray = new Ray(new Vector2(x, y), new Vector2(0, dir));
			Debug.DrawRay(ray.origin, ray.direction);
			if (Physics.Raycast(ray, out hit, Mathf.Abs(deltaY) + skin, collisionMask))
			{
				// Get Distance between player and ground
				float dst = Vector3.Distance(ray.origin, hit.point);
				
				// Stop player's downwards movement after coming within skin width of a collider
				if (dst > skin)
				{
					deltaY = dst * dir - skin * dir;
				}
				else
				{
					deltaY = 0;
				}
				
				grounded = true;
				
				break;
				
			}
			else if (Physics.Raycast(ray, out hit, Mathf.Abs(deltaY) + skin, collectableMask))
			{
				//Logic for collectable collisions
				//Running.player1touchitem1 = true;
				//Running.hitItem = hit.collider.gameObject.name;
				Running.hitOnItem(hit.collider.gameObject.name);
				GameObject.Destroy(hit.collider.gameObject);
				
			}
			
			else if (Physics.Raycast(ray, out hit, Mathf.Abs(deltaY) + skin, endFlagMask))
			{
				
				//Logic for reaching endFlag
				
			}
		}
		
		return deltaY;
	}
	
	public float horizontalCollisions(float deltaY, float deltaX, Vector2 p)
	{
		
		// Check collisions left and right
		movementStopped = false;
		
		for (int i = 0; i < 3; i++)
		{
			float dir = Mathf.Sign(deltaX);
			float x = p.x + c.x + s.x / 2 * dir;
			float y = p.y + c.y - s.y / 2 + s.y / 2 * i;
			
			ray = new Ray(new Vector2(x, y), new Vector2(dir, 0));
			Debug.DrawRay(ray.origin, ray.direction);
			
			if (Physics.Raycast(ray, out hit, Mathf.Abs(deltaX) + skin, collisionMask))
			{
				// Get Distance between player and ground
				float dst = Vector3.Distance(ray.origin, hit.point);
				
				// Stop player's downwards movement after coming within skin width of a collider
				if (dst > skin)
				{
					deltaX = dst * dir - skin * dir;
				}
				else
				{
					deltaX = 0;
				}
				
				movementStopped = true;
				break;
				
			}
			else if (Physics.Raycast(ray, out hit, Mathf.Abs(deltaX) + skin, collectableMask))
			{
				
				//Running.player1touchitem1 = true;
				//Running.hitItem = hit.collider.gameObject.name;
				Running.hitOnItem(hit.collider.gameObject.name);
				GameObject.Destroy(hit.collider.gameObject);
				
			}
			
			else if (Physics.Raycast(ray, out hit, Mathf.Abs(deltaX) + skin, endFlagMask))
			{
				
				//Logic for reaching endFlag
				doPlayerFinish();
				
			}
		}
		
		return deltaX;
	}
	
	private void doPlayerFinish()
	{
		
		Debug.Log(this + " has finished the race");
		Application.LoadLevel("EndScene");
		
		
	}
}