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
public class ResponseHeartbeat extends GameResponse {

  //  private short status;
    private float opponentX;
    private float opponentY;
    private float opponentDistanceTraveled;
    private boolean gameover;

    public ResponseHeartbeat() {
        responseCode = Constants.SMSG_OPPONENTDATA;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      //  packet.addShort16(status);

       // if (status == 0) {
            packet.addFloat(opponentX);
            packet.addFloat(opponentY);
            packet.addBoolean(gameover);
            packet.addFloat(opponentDistanceTraveled);            
      //  }
        
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
    
    /**
     * @param opponentDistanceTraveled the opponentDistanceTraveled to set
     */
    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    public void setStatus(short status) {
       // this.status = status;
    }
}
