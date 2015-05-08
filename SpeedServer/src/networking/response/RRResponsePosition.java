/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.response;
import metadata.Constants;
import utility.GamePacket;

/**
 *
 * @author markfavis
 */
public class RRResponsePosition extends GameResponse {
    
    private int x, y;
    
    public RRResponsePosition(){
        responseCode = Constants.SMSG_RRPOSITION;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(x);
        packet.addInt32(y);
        return packet.getBytes();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
