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
<<<<<<< HEAD
public class ResponseInGameHeartbeat extends GameResponse{
    
    private int opponentX;
    private int opponentY;
    private int opponentDistanceTraveled;
    
    public ResponseInGameHeartbeat(){
=======
public class ResponseInGameHeartbeat extends GameResponse {

    private short status;
    private float opponentX;
    private float opponentY;
    private float opponentDistanceTraveled;
    private boolean gameover;

    public ResponseInGameHeartbeat() {
>>>>>>> michael
        responseCode = Constants.SMSG_OPPONENTDATA;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
<<<<<<< HEAD
        packet.addInt32(opponentX);
        packet.addInt32(opponentY);
        packet.addInt32(opponentDistanceTraveled);

=======
        packet.addShort16(status);

        if (status == 0) {
            packet.addFloat(opponentX);
            packet.addFloat(opponentY);
            packet.addBoolean(gameover);
            packet.addFloat(opponentDistanceTraveled);            
        }
        
>>>>>>> michael
        return packet.getBytes();
    }

    /**
     * @param opponentX the opponentX to set
     */
<<<<<<< HEAD
    public void setOpponentX(int opponentX) {
=======
    public void setOpponentX(float opponentX) {
>>>>>>> michael
        this.opponentX = opponentX;
    }

    /**
     * @param opponentY the opponentY to set
     */
<<<<<<< HEAD
    public void setOpponentY(int opponentY) {
=======
    public void setOpponentY(float opponentY) {
>>>>>>> michael
        this.opponentY = opponentY;
    }

    /**
     * @param opponentDistanceTraveled the opponentDistanceTraveled to set
     */
<<<<<<< HEAD
    public void setOpponentDistanceTraveled(int opponentDistanceTraveled) {
        this.opponentDistanceTraveled = opponentDistanceTraveled;
    }
    
=======
    public void setOpponentDistanceTraveled(float opponentDistanceTraveled) {
        this.opponentDistanceTraveled = opponentDistanceTraveled;
    }
    
    /**
     * @param opponentDistanceTraveled the opponentDistanceTraveled to set
     */
    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    public void setStatus(short status) {
        this.status = status;
    }
>>>>>>> michael
}
