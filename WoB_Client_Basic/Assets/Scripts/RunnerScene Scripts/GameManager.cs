using UnityEngine;
using System.Collections;


public class GameManager : MonoBehaviour {

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
	private int species1;
	public  static int species2;

	// Use this for initialization
	void Start () {
		Debug.Log ("this is specie2 : " + species2);
        

        cam = GetComponent<GameCamera>();
        SpawnMap();
        SpawnPlayer();

        player2 = Instantiate(player2, new Vector3(-19f, 0f, 0f), Quaternion.identity) as GameObject;
        player2.name = "Player_sprite_2(Clone)";

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
        player1 = Instantiate(player1, new Vector3(-19f, 0f, 0f), Quaternion.identity) as GameObject;
        cam.SetTarget(player1.transform);

        player1.name = "Player_sprite(Clone)";
	}

    private void SpawnMap()
    {

        float tempEnd = 20;
        for (int i = 0; i < 21; i++)
        {
           
          // Instantiate(map, new Vector3((float)(20 + (i * 62.9)), 0.507454f, 0), Quaternion.identity);
			//map = Instantiate(Resources.Load("Box")) as GameObject;

			map = Instantiate(Resources.Load("Prefabs/Maps/MapVariation_1"), new Vector3(tempEnd, 0.507454f, 0), Quaternion.identity) as GameObject;
			map.name = map.name + " " + i;
			//(float)(20 + (i * 62.9))
		    tempEnd += 62.9f;

        }

		Instantiate(endFlag, new Vector3(tempEnd - 62.9f + 9, 0.507454f, 0), Quaternion.identity);
    } 

	private void PlaceItem(GameObject itemType, Vector2 vect) {
		Instantiate (itemType, Vector3.zero, Quaternion.identity);
	}
}
