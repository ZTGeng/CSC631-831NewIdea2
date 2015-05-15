/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import core.GameServer;
import java.io.IOException;
import networking.response.ResponseRREndGame;
import race.Race;
import race.RaceManager;
import utility.DataReader;

/**
 *
 * @author markfavis
 */
public class RequestRREndGame extends GameRequest {
    
    private boolean gameCompleted;
    private String finalTime;
    private int p_id;
    private ResponseRREndGame responseRREndGame;
    
    public RequestRREndGame(){
        gameCompleted = false;
        finalTime = "";
    }

    @Override
    public void parse() throws IOException {
        gameCompleted = DataReader.readBoolean(dataInput);
        finalTime = DataReader.readString(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        int thisPlayerID = this.client.getPlayer().getID();
        // end race
        RaceManager.manager.endRace(RaceManager.manager.getRaceByPlayerID(thisPlayerID).getID(),thisPlayerID,finalTime);
    }
    
}
