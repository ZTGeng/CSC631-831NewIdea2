/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.response;

import utility.GamePacket;

/**
 *
 * @author markfavis
 */
public class ResponseRRStartGame extends GameResponse {
    
    private int opponentStatus;
    
    /*
    status:
        0 = opponent not ready
        1 = opponent ready
        2 = opponent quit
    */
    
    public ResponseRRStartGame(){
        
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        
        packet.addInt32(opponentStatus);
        
        return packet.getBytes();
    }
    
}
