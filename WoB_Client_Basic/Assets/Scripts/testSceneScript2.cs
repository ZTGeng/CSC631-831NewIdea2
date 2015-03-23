using UnityEngine;
using System.Collections;

public class testSceneScript2 : MonoBehaviour {

	Texture2D []t = new Texture2D[8];
	Ray mouseRay;
	RaycastHit hit;

	// Use this for initialization
	void Start () {
		loadTextures ();
		placeSpecies (new Vector3 (Random.Range (800.0f, 1150.0f), 140, Random.Range (750.0f, 1050.0f)), Random.Range (0, 7));
		placeSpecies (new Vector3 (Random.Range (800.0f, 1150.0f), 140, Random.Range (750.0f, 1050.0f)), Random.Range (0, 7));
		placeSpecies (new Vector3 (Random.Range (800.0f, 1150.0f), 140, Random.Range (750.0f, 1050.0f)), Random.Range (0, 7));
		placeSpecies (new Vector3 (Random.Range (800.0f, 1150.0f), 140, Random.Range (750.0f, 1050.0f)), Random.Range (0, 7));
		placeSpecies (new Vector3 (Random.Range (800.0f, 1150.0f), 140, Random.Range (750.0f, 1050.0f)), Random.Range (0, 7));
		
	}

	void placeSpecies(Vector3 pos, int texture){
		GameObject spec = GameObject.CreatePrimitive (PrimitiveType.Cube);
		Shader transparent = Shader.Find ("Transparent/Cutout/Diffuse");
		
		spec.renderer.material.mainTexture = t [texture];
		spec.transform.localScale = new Vector3 (50, .1f, 50);
		spec.transform.localRotation = Quaternion.Euler (90, 180, 0);
		spec.transform.position = pos;
		//spec.AddComponent ("Rigidbody");
		spec.renderer.material.shader = transparent; 
	}

	void loadTextures(){
		t[0] = Resources.Load ("Textures/Species/African Elephant", typeof(Texture2D)) as Texture2D;
		t[1] = Resources.Load ("Textures/Species/Aardvark", typeof(Texture2D)) as Texture2D;
		t[2] = Resources.Load ("Textures/Species/Acacia", typeof(Texture2D)) as Texture2D;
		t[3] = Resources.Load ("Textures/Species/African Clawless Otter", typeof(Texture2D)) as Texture2D;
		t[4] = Resources.Load ("Textures/Species/Baobab", typeof(Texture2D)) as Texture2D;
		t[5] = Resources.Load ("Textures/Species/African Marsh Owl", typeof(Texture2D)) as Texture2D;
		t[6] = Resources.Load ("Textures/Species/Bat-Eared Fox", typeof(Texture2D)) as Texture2D;
		t[7] = Resources.Load ("Textures/Species/Black Backed Jackal", typeof(Texture2D)) as Texture2D;
	}

	void onMouseClick(){
		mouseRay = Camera.main.ScreenPointToRay (Input.mousePosition);
		if (Physics.Raycast (mouseRay, out hit, 1000)) {
			Vector3 pos = new Vector3 (hit.point.x, hit.point.y + 20, hit.point.z);
			placeSpecies (pos, 7);
		}
	}

	// Update is called once per frame
	void Update () {

		if(Input.GetKeyDown(KeyCode.Quote))
		{
			placeSpecies (new Vector3 (Random.Range (800.0f, 1150.0f), 140, Random.Range (750.0f, 1050.0f)), 2);
		} 
		else if (Input.GetKeyDown (KeyCode.Comma))
		{
			placeSpecies (new Vector3 (Random.Range (800.0f, 1150.0f), 140, Random.Range (750.0f, 1050.0f)), 0);
		} 
		else if (Input.GetKeyDown(KeyCode.Period))
		{
			placeSpecies (new Vector3 (Random.Range (800.0f, 1150.0f), 140, Random.Range (750.0f, 1050.0f)), 4);
		}

		if (Input.GetMouseButtonDown (0)) {
			onMouseClick();
		}
	}
}
