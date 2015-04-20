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
public class ResponseHeartbeat extends GameResponse{
    
    private float opponentX;
    private float opponentY;
    private float opponentDistanceTraveled;
    private short gameover;
    
    public ResponseHeartbeat(){
        responseCode = Constants.SMSG_HEARTBEAT;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addFloat(opponentX);
        packet.addFloat(opponentY);
        packet.addFloat(opponentDistanceTraveled);
        packet.addShort16(gameover);

        return packet.getBytes();
    }

    /**
     * @param opponentX the opponentX to set
     */
    public void setOpponentX(float opponentX) {
        this.opponentX = opponentX;
    }

    /**
     * @param opponentY the opponentY to set
     */
    public void setOpponentY(float opponentY) {
        this.opponentY = opponentY;
    }

    /**
     * @param opponentDistanceTraveled the opponentDistanceTraveled to set
     */
    public void setOpponentDistanceTraveled(float opponentDistanceTraveled) {
        this.opponentDistanceTraveled = opponentDistanceTraveled;
    }
    
    public void setOpponentGameover(short gameover) {
        this.gameover = gameover;
    }
}
