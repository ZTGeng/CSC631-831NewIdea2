using UnityEngine;
using System.Collections;

[RequireComponent(typeof(PlayerPhysics))]
public class PlayerController : MonoBehaviour
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
    private PlayerPhysics playerPhysics;


    void Start()
    {
        playerPhysics = GetComponent<PlayerPhysics>();
        anim = GetComponent<Animator>();
    }

    void Update()
    {

            int direction;
			anim.SetBool ("jumping", !playerPhysics.grounded);
            direction = doKeyboardInput();
			
            
			//Reseting speeds if collide with wall
            if (playerPhysics.movementStopped)
            {
                targetSpeed = 0;
                currentSpeed = 0;
            }

            targetSpeed = direction * speed;
            currentSpeed = IncrementTowards(currentSpeed, targetSpeed, acceleration);

            //Animation code
            anim.SetFloat("speed", currentSpeed);

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
                        if (currentSpeed > 0)
                        {
                            targetSpeed *= -.6f;
                            currentSpeed *= -.6f;
                        }
                        anim.SetInteger("facing", 1);
                        return -1;

                    case KeyCode.RightArrow:
                        if (currentSpeed < 0)
                        {
                            targetSpeed *= -.6f;
                            currentSpeed *= -.6f;
                        }
                        anim.SetInteger("facing", 0);
                        return 1;

                    case KeyCode.UpArrow:

                        return 0;
                        break;

                    case KeyCode.DownArrow:

                        targetSpeed = 0;
                        currentSpeed = 0;
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
