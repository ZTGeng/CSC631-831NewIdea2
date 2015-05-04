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
public class ResponseRRBoost extends GameResponse {
    
    public ResponseRRBoost(){
        
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        
        // nothing to response
        
        return packet.getBytes();
    }

    
}
