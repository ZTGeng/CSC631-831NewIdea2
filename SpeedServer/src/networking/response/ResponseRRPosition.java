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
public class ResponseRRPosition extends GameResponse {
    
    private float x, y;
    
    public ResponseRRPosition(){
        responseCode = Constants.SMSG_RRPOSITION;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);

        packet.addFloat(x);
        packet.addFloat(y);
        return packet.getBytes();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
}
