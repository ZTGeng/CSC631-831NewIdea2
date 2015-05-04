/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import java.io.IOException;
import networking.response.ResponseRREndGame;
import utility.DataReader;

/**
 *
 * @author markfavis
 */
public class RequestRREndGame extends GameRequest {
    
    private boolean gameCompleted;
    private float finalTime;
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
        
        // GET FASTEST and HIGHEST POINT PLAYER NAMES FROM DATABASE
        // THEN SET RESPONSERRENDGAME VALUES TO IT
    }
    
}
