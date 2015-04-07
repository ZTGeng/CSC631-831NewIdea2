using UnityEngine;
using System.Collections;

public class GameManager : MonoBehaviour {

	public GameObject player;
	private GameCamera cam;
    private float raceTime;

	// Use this for initialization
	void Start () {

		cam = GetComponent<GameCamera> ();
		SpawnPlayer ();
        raceTime = 0;

	}
	
	private void SpawnPlayer() {
		cam.SetTarget(( Instantiate (player, Vector3.zero, Quaternion.identity) as GameObject).transform);
	}

    void update()
    {
        Debug.Log("this gets called");
        raceTime += Time.deltaTime;
        Debug.Log(raceTime);
    }
}
