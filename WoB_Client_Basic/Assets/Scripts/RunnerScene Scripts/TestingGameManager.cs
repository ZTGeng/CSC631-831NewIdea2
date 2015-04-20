using UnityEngine;
using System.Collections;


public class TestingGameManager : MonoBehaviour {
	
	public GameObject player1;
	public GameObject player2;
	public GameObject map;
	public GameObject endFlag;
	public GameObject item1;
	public ArrayList items;
	private GameCamera cam;
	private float raceTime;
	private static float startPoint = 0;
	private static float endPoint;
	
	// Use this for initialization
	void Start () {
		
		cam = GetComponent<GameCamera> ();
		SpawnMap();
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
		cam.SetTarget(( Instantiate (player1, new Vector3(-19f, 0f,0f), Quaternion.identity) as GameObject).transform);
	}
	
	private void SpawnMap()
	{
		GameObject[] MapVars = new GameObject[10];
		for (int i = 0; i < 1; i++) {
			MapVars[i] = Resources.Load("Prefabs/Maps/MapVariation_" + i) as GameObject;
			Debug.Log("Map Variation added to array");
		}

		float tempEnd = 20;
        int mapUnitLength = 2;
		for (int i = 0; i < mapUnitLength; i++)
		{
            tempEnd += 62.9f;
			Instantiate(MapVars[Random.Range (0,0)], new Vector3((float)(20 + (i * 62.9)), 0.507454f, 0), Quaternion.identity);
		}
		
		endPoint = tempEnd - 62.9f;
		Instantiate(endFlag, new Vector3(endPoint, 0.507454f, 0), Quaternion.identity);
	} 
	
	private void PlaceItem(GameObject itemType, Vector2 vect) {
		Instantiate (itemType, Vector3.zero, Quaternion.identity);
	}
}
