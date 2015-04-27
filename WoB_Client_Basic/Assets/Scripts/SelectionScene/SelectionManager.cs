﻿using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class SelectionManager : MonoBehaviour {

	private GameObject gObj;
	private GameObject[] speciesButtons;
	private GameObject[] buttonImages;
    private GameObject submit;
    private int spot1, spot2;

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

        //Button stored by position
        spot1 = 0;
        spot2 = 1;

		//Initialize Buttons
		initButtons ();
	}

	private void initButtons(){

        initSpeciesButtons();
        setButtonActive(spot1);
        setButtonActive(spot2);

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

        But.onClick.AddListener(() => previous());

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

        But2.onClick.AddListener(() => next());

        /*
         * Submit Button
         */
        submit = new GameObject();
        submit.name = "forwardButton";
        submit.transform.parent = gObj.transform;

        RectTransform RT3 = submit.AddComponent<RectTransform>();
        RT3.anchoredPosition = new Vector2(0f, 0f);
        RT3.sizeDelta = new Vector2(100, 25);
        RT3.localPosition = new Vector3(0f, -225f, 0f);
        RT3.localScale = new Vector3(3f, 3f, 1f);

        Button But3 = submit.AddComponent<Button>();
        But3.transition = Selectable.Transition.ColorTint;

        Image img3 = submit.AddComponent<Image>();
        Sprite t3 = Resources.Load<Sprite>("Prefabs/UI/playButton");
        img3.sprite = t3;
        But3.targetGraphic = img3;
        img3.preserveAspect = true;

        But3.onClick.AddListener(() => goToRunnerScene());

        submit.SetActive(false);

	}

    void initSpeciesButtons()
    {
        speciesButtons = new GameObject[5];
		buttonImages = new GameObject[5];

        /*
         * Species buttons
         */
        for (int i = 0; i < 5; i++)
        {
            speciesButtons[i] = new GameObject();
			buttonImages[i] = new GameObject();

            // Naming button and setting as child of canvas
            speciesButtons[i].name = "Species " + i;
			buttonImages[i].name = "Avatar " + i;
            speciesButtons[i].transform.parent = gObj.transform;
			buttonImages[i].transform.parent = speciesButtons[i].transform;

            //Species button :: Placing the Button on the canvas
            RectTransform RectTrans = speciesButtons[i].AddComponent<RectTransform>();
            RectTrans.anchoredPosition = new Vector2(0f, 0f);
            RectTrans.sizeDelta = new Vector2(100, 100);
            RectTrans.localScale = new Vector3(3f, 3f, 1f);

			//Button Image :: Placing the image inside the  button
			RectTransform rT = buttonImages[i].AddComponent<RectTransform>();
			rT.anchoredPosition = new Vector2(0f, 0f);
			rT.sizeDelta = new Vector2(37, 30);
			rT.localScale = new Vector3(1f, 1f, 1f);
			
			//Setting a transition (ColorTint) on mouseClick
            Button s = speciesButtons[i].AddComponent<Button>();
            s.transition = Selectable.Transition.ColorTint;

            //Species Button :: Setting the button image
            Image image = speciesButtons[i].AddComponent<Image>();
            Sprite temp = Resources.Load<Sprite>("Prefabs/UI/speciesButton");
            image.preserveAspect = true;

			//Species Button :: Setting the button image
			Image img = buttonImages[i].AddComponent<Image>();
			Sprite t = Resources.Load<Sprite>("Art/Avatars/avatar" + i);
			img.preserveAspect = true;
			
			if (temp != null && t != null)
            {
                image.sprite = temp;
                s.targetGraphic = image;

				img.sprite = t;

            }
            else
                Debug.LogError("Sprite is null");
			
			switch(i){
                case 0:
                    s.onClick.AddListener(() => selectSpecies(speciesButtons[0]));
                    break;
                case 1:
                    s.onClick.AddListener(() => selectSpecies(speciesButtons[1]));
                    break;
                case 2:
                    s.onClick.AddListener(() => selectSpecies(speciesButtons[2]));
                    break;
                case 3:
                    s.onClick.AddListener(() => selectSpecies(speciesButtons[3]));
                    break;
                case 4:
                    s.onClick.AddListener(() => selectSpecies(speciesButtons[4]));
                    break;
            }

            speciesButtons[i].SetActive(false);
        }
    }

    void setButtonActive(int num)
    {

        if (num == 5)
        {

            submit.SetActive(true);

            return;
        }

        //Placing the Button on the canvas
        //Drawing one the proper coordinates
        RectTransform RectTrans = speciesButtons[num].GetComponent<RectTransform>();
        if (num == spot1)
            RectTrans.localPosition = new Vector3(-140f, 0f, 0f);
        else
            RectTrans.localPosition = new Vector3(140f, 0f, 0f);

        speciesButtons[num].SetActive(true);
    }

    void setButtonInactive(int num)
    {
        if (num == 5)
            submit.SetActive(false);
        else
            speciesButtons[num].SetActive(false);
    }

	void next(){
        
        int temp1, temp2;
        temp1 = spot1;
        temp2 = spot2;

        Debug.Log("Next has been called");
        
        if (spot2 == 4)
        {
            spot2 = 0;
            spot1 = 4;
        }
        else if (spot1 == 4)
        {
            spot1 = 0;
            spot2 = 1;
        }
        else
        {
            spot1 += 1;
            spot2 += 1;
        }

        //Set the correct buttons to active
        setButtonInactive(temp1);
        setButtonInactive(temp2);
        setButtonActive(spot1);
        setButtonActive(spot2);
	}

	void previous(){

        int temp1, temp2;
        temp1 = spot1;
        temp2 = spot2;

        Debug.Log("Previous has been called");

        if (spot2 == 0)
        {
            spot2 = 4;
            spot1 = 3;
        }
        else if (spot1 == 0)
        {
            spot1 = 4;
            spot2 = 0;
        }
        else
        {
            spot1 -= 1;
            spot2 -= 1;
        }

        //Set the correct buttons to active
        setButtonInactive(temp1);
        setButtonInactive(temp2);
        setButtonActive(spot1);
        setButtonActive(spot2);
	}

    void selectSpecies(GameObject species)
    {
        Debug.Log(species);
		setButtonActive(5);

		//Pass selected species information to the game manager
		//lets the game manager know which species to initialize
    }

    void goToRunnerScene()
    {
        Application.LoadLevel("RunnerScene");
    }
}
