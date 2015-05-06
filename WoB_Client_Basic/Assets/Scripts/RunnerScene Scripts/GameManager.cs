using UnityEngine;
using System.Collections;


public class GameManager : MonoBehaviour {

	public GameObject player1;
	public GameObject player2;
    public GameObject endFlag;
	public ArrayList items;
	private GameCamera cam;
    private float raceTime;
    private static float startPoint = 0f;
    private static float endPoint;

	// Use this for initialization
	void Start () {

        

        cam = GetComponent<GameCamera>();
        SpawnMap();
        SpawnPlayer();

        player2 = Instantiate(player2, new Vector3(0f, 0f, 0f), Quaternion.identity) as GameObject;
        player2.name = "Player_sprite_2(Clone)";

        raceTime = 0;
        //Debug.Log("Before!!!!!!!!!");

        items = new ArrayList();
        //repeat until none
        // item = new GO();
        // PlaItem(item, xy);
        // items.Add (items);

        GameObject.Find("GameLogic").GetComponent<Running>().RunOnce();
		GameObject.Find ("GameLogic").GetComponent<RunnerUI> ().setStartandEndPoints (startPoint, endPoint);
		GameObject.Find ("GameLogic").GetComponent<RunnerUI> ().setPlayer1 (player1);
		GameObject.Find ("GameLogic").GetComponent<RunnerUI> ().SetPlayer2 (player2);
	}
	
	private void SpawnPlayer() {
        player1 = Instantiate(player1, new Vector3(0f, 0f, 0f), Quaternion.identity) as GameObject;
        cam.SetTarget(player1.transform);

        player1.name = "Player_sprite(Clone)";
	}

    private void SpawnMap()
    {

		GameObject[] MapVars = new GameObject[10];
		MapVars [0] = Resources.Load ("Prefabs/Maps/MapVariation_blank") as GameObject;
		for (int i = 0; i < 2; i++) {
			MapVars[i+1] = Resources.Load("Prefabs/Maps/MapVariation_" + i) as GameObject;
		}

		float tempEnd = 39;
		int mapUnitLength = 5;
		for (int i = 0; i < mapUnitLength; i++)
		{
			tempEnd += 62.9f;
			if(i == 0)
				Instantiate(MapVars[0], new Vector3((float)(39 + (i * 62.9)), 0.507454f, 0), Quaternion.identity);
			else if(i == (mapUnitLength - 1))
				Instantiate(MapVars[0], new Vector3((float)(39 + (i * 62.9)), 0.507454f, 0), Quaternion.identity);
			else
				Instantiate(MapVars[Random.Range (1,3)], new Vector3((float)(39 + (i * 62.9)), 0.507454f, 0), Quaternion.identity);
		}
		
		endPoint = tempEnd - 62.9f;
		Instantiate(endFlag, new Vector3(endPoint, -0.49f, 0), Quaternion.identity);
    } 

	private void PlaceItem(GameObject itemType, Vector2 vect) {
		Instantiate (itemType, Vector3.zero, Quaternion.identity);
	}
}
