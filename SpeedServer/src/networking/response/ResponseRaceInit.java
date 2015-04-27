/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package networking.response;

import metadata.Constants;
import model.Player;
import utility.GamePacket;

/**
 *
 * @author Lowell Milliken
 */
public class ResponseRaceInit extends GameResponse {
 
    private short status;
    private Player player;
    
    public ResponseRaceInit(){
        responseCode = Constants.SMSG_RACE_INIT;
        status = 0;
    }
    @Override
    public byte[] constructResponseInBytes() {        
        GamePacket packet = new GamePacket(responseCode);
                
        packet.addShort16(status);        
        
        return packet.getBytes();
    }

    public void setStatus(short status) {
        this.status = status;
    }    

    public void setPlayer(Player player) {
        this.player = player;
    }
}

