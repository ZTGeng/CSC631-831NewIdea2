﻿using UnityEngine;
using System.Collections;

[RequireComponent(typeof(TestingPlayerPhysics))]
public class TestingPlayerController : MonoBehaviour
{

    // Player Handling
    public float gravity = 20;
    public float speed = 8;
    public float acceleration = 32;
    public float jumpHeight = 12;
    
    private Animator anim;
    private float currentSpeed;
    private float targetSpeed;
    private Vector2 amountToMove;

    private bool wallJumped;

    private TestingPlayerPhysics playerPhysics;


    void Start()
    {
        playerPhysics = GetComponent<TestingPlayerPhysics>();
        anim = GetComponent<Animator>();
    }

    void Update()
    {

        int direction;
        direction = doKeyboardInput();

        wallJumped = true;

        //Reseting speeds if collide with wall
        if (playerPhysics.movementStopped)
        {
            targetSpeed = 0;
            currentSpeed = 0;

            if (!playerPhysics.grounded)
                wallJumped = false;

        }

        targetSpeed = direction * speed;
        currentSpeed = IncrementTowards(currentSpeed, targetSpeed, acceleration);

        //anim.speed = currentSpeed;

        // Check if on ground then jump
        if (playerPhysics.grounded)
        {
            amountToMove.y = 0;

            // Jump
            if (Input.GetButtonDown("Jump"))
            {
                amountToMove.y = jumpHeight;
            }
        }

        // Wall jump
        if (!playerPhysics.grounded && playerPhysics.movementStopped && targetSpeed != 0)
        {

            if (Input.GetButtonDown("Jump"))
            {
                amountToMove.y = jumpHeight;
                currentSpeed = IncrementTowards(10 * ((targetSpeed / Mathf.Abs(targetSpeed) * -1)), targetSpeed * -1, 100);
            }
        }

        amountToMove.x = currentSpeed;
        amountToMove.y -= (gravity * Time.deltaTime);
        playerPhysics.Move(amountToMove * Time.deltaTime);
    }

    // Increase n towards target by speed
    private float IncrementTowards(float n, float target, float a)
    {
        if (n == target)
        {
            return n;
        }
        else
        {
            float dir = Mathf.Sign(target - n); // must n be increased or decreased to get closer to target
            n += a * Time.deltaTime * dir;
            return (dir == Mathf.Sign(target - n)) ? n : target; // if n has now passed target then return target, otherwise return n
        }
    }

    private int doKeyboardInput()
    {

        
        
        foreach (KeyCode vKey in System.Enum.GetValues(typeof(KeyCode)))
        {
            if (Input.GetKey(vKey))
            {

                switch (vKey)
                {
                    case KeyCode.LeftArrow:
                        Debug.Log("LeftArrow pressed");
                        return -1;
                        break;
                    case KeyCode.RightArrow:
                        Debug.Log("RightArrow pressed");
                        return 1;
                        break;
                    case KeyCode.UpArrow:
                        
                        GameObject test = GameObject.Find("testingPlayer(Clone)");
                        TestingPlayerController temp = test.GetComponent<TestingPlayerController>();
                        temp.acceleration = 1000;
                        temp.speed = 500;
                        return 0;
                        break;
                    case KeyCode.DownArrow:
                        
                        GameObject test2 = GameObject.Find("testingPlayer(Clone)");
                        TestingPlayerController temp2 = test2.GetComponent<TestingPlayerController>();
                        temp2.acceleration = 32;
                        temp2.speed = 8;
                        return 0;
                        break;

                }
            }
        }

        return 0;

        // Space.. Jump logic, tell the server etc
        //if (Input.GetKeyDown(KeyCode.Space))

    }
}
