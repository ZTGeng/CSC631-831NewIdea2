/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.response;

import utility.GamePacket;
import utility.Log;

/**
 *
 * @author markfavis
 */
public class ResponseRRStartGame extends GameResponse {
    
    private short status;

//  Ignore comment below, 0 by convention is success.
    /*
    status:
        0 = opponent not ready
        1 = opponent ready
        2 = opponent quit
    */
    
    public ResponseRRStartGame(){
        short status = 0;
        Log.println("A ResponseRRStartGame has been sent out.");
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        
        packet.addShort16(status);
        
        return packet.getBytes();
    }
    
}
