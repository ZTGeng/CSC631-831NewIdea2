using UnityEngine;
using System.Collections;


public class GameManager : MonoBehaviour {

	public GameObject player1;
	public GameObject player2;
	public GameObject item1;
	public ArrayList items;
	private GameCamera cam;
    private float raceTime;

	// Use this for initialization
	void Start () {

		cam = GetComponent<GameCamera> ();
		SpawnPlayer ();
		Instantiate (player2, Vector3.zero, Quaternion.identity);
        raceTime = 0;
		//Debug.Log("Before!!!!!!!!!");

		items = new ArrayList();
		//repeat until none
		// item = new GO();
		// PlaItem(item, xy);
		// items.Add (items);

		GameObject.Find("GameLogic").GetComponent<Running>().RunOnce();

	}
	
	private void SpawnPlayer() {
		cam.SetTarget(( Instantiate (player1, Vector3.zero, Quaternion.identity) as GameObject).transform);
	}

	private void PlaceItem(GameObject itemType, Vector2 vect) {
		Instantiate (itemType, Vector3.zero, Quaternion.identity);
	}

    void update()
    {
        Debug.Log("this gets called");
 //       raceTime += Time.deltaTime;
 //       Debug.Log(raceTime);
    }
}
