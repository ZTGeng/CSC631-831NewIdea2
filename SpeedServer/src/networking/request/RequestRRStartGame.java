/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import java.io.IOException;
import networking.response.ResponseRRStartGame;

/**
 *
 * @author markfavis
 */
public class RequestRRStartGame extends GameRequest {
    
    private ResponseRRStartGame responseRRStartGame;

    @Override
    public void parse() throws IOException {
        
    }

    @Override
    public void doBusiness() throws Exception {
        responseRRStartGame = new ResponseRRStartGame();
        // WAIT FOR OPPONENT TO SEND THE SAME PACKET
    }
    
}
