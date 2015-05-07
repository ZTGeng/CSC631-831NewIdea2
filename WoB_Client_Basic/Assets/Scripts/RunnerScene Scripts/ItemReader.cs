using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class ItemReader : MonoBehaviour {

	public static Dictionary<string, string> ReadFile(string filename) {
		Dictionary<string, string> items = new Dictionary<string, string>();
		System.IO.StreamReader file;
		try {
			file = new System.IO.StreamReader(filename);
			
			try {
				int num = int.Parse(file.ReadLine());
				for (int i = 0; i < num; i++) {
					string speciesId = file.ReadLine();
					string speciesX = file.ReadLine();
					items.Add(speciesX, speciesId);
				}
			} catch {
				Debug.Log("file format error!!!!");
			}
			
			file.Close();
			
		} catch {
			Debug.Log("file read error!!!!");
		}
		
		return items;
	}
}
