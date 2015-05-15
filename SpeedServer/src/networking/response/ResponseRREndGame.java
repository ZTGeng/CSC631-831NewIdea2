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
public class ResponseRREndGame extends GameResponse {

    private boolean gameCompleted;
    private String finalTime;
    private String fastestPlayer;
    private String highestPoint;

    public ResponseRREndGame() {
        responseCode = Constants.SMSG_RRENDGAME;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);

        packet.addBoolean(isGameCompleted());
        packet.addString(getFinalTime());
        //packet.addString(getFastestPlayer());
        //packet.addString(getHighestPoint());

        return packet.getBytes();
    }

    /**
     * @return the fastestPlayer
     */
    public String getFastestPlayer() {
        return fastestPlayer;
    }

    /**
     * @param fastestPlayer the fastestPlayer to set
     */
    public void setFastestPlayer(String fastestPlayer) {
        this.fastestPlayer = fastestPlayer;
    }

    /**
     * @return the highestPoint
     */
    public String getHighestPoint() {
        return highestPoint;
    }

    /**
     * @param highestPoint the highestPoint to set
     */
    public void setHighestPoint(String highestPoint) {
        this.highestPoint = highestPoint;
    }

    /**
     * @return the gameCompleted
     */
    public boolean isGameCompleted() {
        return gameCompleted;
    }

    /**
     * @param gameCompleted the gameCompleted to set
     */
    public void setGameCompleted(boolean gameCompleted) {
        this.gameCompleted = gameCompleted;
    }

    /**
     * @return the finalTime
     */
    public String getFinalTime() {
        return finalTime;
    }

    /**
     * @param finalTime the finalTime to set
     */
    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
    }

}
