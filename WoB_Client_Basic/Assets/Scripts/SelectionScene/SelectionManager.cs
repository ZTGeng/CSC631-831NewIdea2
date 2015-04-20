using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class SelectionManager : MonoBehaviour {

	private GameObject gObj;
	private GameObject[] speciesButtons;

	// Use this for initialization
	void Start () {
		//Canvas Initialization
		gObj = new GameObject ();
		gObj.name = "SelectionCanvas";
		Canvas canvas = gObj.AddComponent<Canvas> ();
		canvas.renderMode = RenderMode.ScreenSpaceOverlay;
		CanvasScaler cs = gObj.AddComponent<CanvasScaler> ();
		cs.uiScaleMode = CanvasScaler.ScaleMode.ScaleWithScreenSize;
		GraphicRaycaster gRay = gObj.AddComponent<GraphicRaycaster> ();

		//Initialize Buttons
		initButtons ();




	}

	private void initButtons(){
		speciesButtons = new GameObject[5];

		/*
		 * Species buttons
		 */
		for (int i = 0; i < 2; i++) {

			speciesButtons [i] = new GameObject ();

			// Naming button and setting as child of canvas
			speciesButtons [i].name = "Species" + i;
			speciesButtons [i].transform.parent = gObj.transform;

			//Placing the Button on the canvas
			RectTransform RectTrans = speciesButtons [i].AddComponent<RectTransform> ();
			RectTrans.anchoredPosition = new Vector2 (0f, 0f);
			RectTrans.sizeDelta = new Vector2 (100, 100);
			RectTrans.localPosition = new Vector3 (-140f * (Mathf.Pow(-1f, i)), 0f, 0f);
			RectTrans.localScale = new Vector3 (3f, 3f, 1f);

			//Setting a transition (ColorTint) on mouseClick
			Button s = speciesButtons [i].AddComponent<Button> ();
			s.transition = Selectable.Transition.ColorTint;

			//Setting the button image
			Image image = speciesButtons [i].AddComponent<Image> ();
			Sprite temp = Resources.Load <Sprite> ("Prefabs/UI/speciesButton");
			image.preserveAspect = true;

			if (temp != null){
				image.sprite = temp;
				s.targetGraphic = image;
			}else 
				Debug.LogError ("Sprite is null");


		}

		/*
		 * BACK BUTTON
		 */
		GameObject bBack = new GameObject ();
		bBack.name = "backButton";
		bBack.transform.parent = gObj.transform;

		RectTransform RT = bBack.AddComponent<RectTransform> ();
		RT.anchoredPosition = new Vector2 (0f, 0f);
		RT.sizeDelta = new Vector2 (25, 25);
		RT.localPosition = new Vector3 (-325f, 0f, 0f);
		RT.localScale = new Vector3 (3f, 3f, 1f);

		Button But = bBack.AddComponent<Button> ();
		But.transition = Selectable.Transition.ColorTint;

		Image img = bBack.AddComponent<Image> ();
		Sprite t = Resources.Load <Sprite> ("Prefabs/UI/backButton");
		img.sprite = t;
		But.targetGraphic = img;
		img.preserveAspect = true;

		/*
		 * NEXT BUTTON
		 */
		GameObject bNext = new GameObject ();
		bNext.name = "forwardButton";
		bNext.transform.parent = gObj.transform;

		RectTransform RT2 = bNext.AddComponent<RectTransform> ();
		RT2.anchoredPosition = new Vector2 (0f, 0f);
		RT2.sizeDelta = new Vector2 (25, 25);
		RT2.localPosition = new Vector3 (325f, 0f, 0f);
		RT2.localScale = new Vector3 (3f, 3f, 1f);

		Button But2 = bNext.AddComponent<Button> ();
		But2.transition = Selectable.Transition.ColorTint;

		Image img2 = bNext.AddComponent<Image> ();
		Sprite t2 = Resources.Load <Sprite> ("Prefabs/UI/forwardButton");
		img2.sprite = t2;
		But2.targetGraphic = img2;
		img2.preserveAspect = true;
		
	}
	
	
	// Update is called once per frame
	void Update () {
	
	}

	void next(){
	
	}

	void previous(){
	
	}
}
