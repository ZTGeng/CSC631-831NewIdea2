using UnityEngine;
using System.Collections;



public class RRResponseSpeciesEventArgs : ExtendedEventArgs {
	public int  id { get; set; }

	
	public RRResponseSpeciesEventArgs() {
		event_id = Constants.SMSG_RRSPECIES;
	}
}

public class RRResponseSpecies : NetworkResponse {

	private int id;




	public override void parse() {
		id = DataReader.ReadInt(dataStream);

	}

	public override ExtendedEventArgs process() {


		RRResponseSpeciesEventArgs args = new RRResponseSpeciesEventArgs ();
		args.event_id = id;


		return args;
	}


}
