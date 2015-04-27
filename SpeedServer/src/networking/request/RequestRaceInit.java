/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package networking.request;

import race.Race;
import race.RaceManager;
import core.NetworkManager;
import java.io.IOException;
import networking.response.ResponseRaceInit;
import utility.DataReader;
import utility.Log;

/**
 *
 * @author Lowell Milliken
 */
public class RequestRaceInit extends GameRequest {

    private int player_id;
    
    @Override
    public void parse() throws IOException {
        player_id = DataReader.readInt(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        Race race = RaceManager.getInstance().createRace(player_id);
        
        Log.println("Trying to start battle: Player: " + player_id);
        
        if(race != null) {
            ResponseRaceInit response = new ResponseRaceInit();
            for(int p_id : race.getPlayers().keySet()) {
                NetworkManager.addResponseForUser(p_id, response);
            }
            
            Log.println("Battle created with players: " + race.getPlayers().keySet().toString());
        }
    }
    
}
