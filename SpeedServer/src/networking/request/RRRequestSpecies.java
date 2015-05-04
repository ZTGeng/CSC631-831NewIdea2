/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import core.GameServer;
import java.io.IOException;
import networking.response.RRResponseSpecies;
import race.RaceManager;
import utility.DataReader;
import race.RacePlayer;

/**
 *
 * @author Sbc-ComEx
 */
public class RRRequestSpecies extends GameRequest {
    
    private int id;
    private int p_id;
    private RRResponseSpecies rrResponseSpecies;
    
    
     public void parse() throws IOException {
        id = DataReader.readInt(dataInput);
 
    }

    @Override
    public void doBusiness() throws Exception {
        
        rrResponseSpecies = new RRResponseSpecies();
        rrResponseSpecies.setId(id);
        
//        RaceManager.getInstance();
//        client.getPlayer().getID();
        
        //Debugging
//        Log.println(Integer.toString(RaceManager.getInstance().getRaceByPlayerID(client.getPlayer().getID()).getID()));        
//        Log.println(Integer.toString(RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID()).getOpponent(client.getPlayer()).getID()));
   
        //Set the species of this Player
        RacePlayer racePlayer = (RacePlayer) client.getPlayer();
        racePlayer.setSpecies(id);
        
        //The playerID of the oppenet of the player who sent the request
        p_id = RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID())
                .getOpponent(client.getPlayer()).getID();
                
        //NetworkManager.addResponseForUser(p_id, responsekeyboard);
        
        GameServer.getInstance().getThreadByPlayerID(p_id).send(rrResponseSpecies);
    }
    
    
}
