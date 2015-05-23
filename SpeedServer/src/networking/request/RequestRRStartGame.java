/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import core.GameServer;
import java.io.IOException;
import networking.response.ResponseRRStartGame;
import race.Race;
import race.RaceManager;
import race.RaceManager;
import utility.DataReader;
import utility.Log;

/**
 *
 * @author markfavis
 */
public class RequestRRStartGame extends GameRequest {

    private ResponseRRStartGame responseRRStartGame;

    @Override
    public void parse() throws IOException {
//        p_id1 = DataReader.readInt(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        Log.println("request start game from user: '" + client.getUserID() + 
            "' recieved");
        
        Log.println("The race the user belongs to is '" +  RaceManager.manager.
            getRaceByPlayerID(client.getUserID()).getID() + "'");
        
        RaceManager.manager.getRaceByPlayerID(client.getUserID()).
            startRace(client.getUserID());
        
    }
}
