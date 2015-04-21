/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.response;

// Other Imports
import metadata.Constants;
import model.Player;
import utility.GamePacket;

/**
 *
 * @author markfavis
 */
public class ResponseGameState extends GameResponse{

    private short gameState;
    
    public ResponseGameState(){
        responseCode = Constants.SMSG_GAME_STATE;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(gameState);

        return packet.getBytes();
    }
    
    public void setGameState(short gameState) {
        this.gameState = gameState;
    }
}
