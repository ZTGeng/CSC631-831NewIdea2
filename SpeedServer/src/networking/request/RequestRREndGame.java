/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import core.GameServer;
import java.io.IOException;
import networking.response.ResponseRREndGame;
import race.RaceManager;
import utility.DataReader;

/**
 *
 * @author markfavis
 */
public class RequestRREndGame extends GameRequest {
    
    private boolean gameCompleted;
    private float finalTime;
    private int p_id;
    private ResponseRREndGame responseRREndGame;
    
    public RequestRREndGame(){
        gameCompleted = false;
        finalTime = 0;
    }

    @Override
    public void parse() throws IOException {
        gameCompleted = DataReader.readBoolean(dataInput);
        finalTime = DataReader.readFloat(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        responseRREndGame = new ResponseRREndGame();
        
        responseRREndGame.setFinalTime(finalTime);
        responseRREndGame.setGameCompleted(gameCompleted);
        // GET FASTEST and HIGHEST POINT PLAYER NAMES FROM DATABASE
        // THEN SET RESPONSERRENDGAME VALUES TO IT
        
        p_id = RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID())
                .getOpponent(client.getPlayer()).getID();
                        
        GameServer.getInstance().getThreadByPlayerID(p_id).send(responseRREndGame);
    }
    
}
