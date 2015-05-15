package race;

import core.GameClient;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import model.Player;
import networking.response.ResponseRRStartGame;
import metadata.Constants;
import core.NetworkManager;
import utility.Log;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author markfavis
 */
public class Race {

//    private 
    private Map<Integer, RacePlayer> rPlayers = new HashMap<Integer, RacePlayer>();

    private int raceID;
    private int mapID;

    private short playersReadyToStart;

    public Race(List<Player> players, int raceID) {

        this.raceID = raceID;
        for (Player player : players) {
            this.rPlayers.put(Integer.valueOf(player.getID()), new RacePlayer(player.getID(), raceID));
        }
    }

    public int getID() {
        return this.raceID;
    }

    public Map<Integer, RacePlayer> getPlayers() {
        return rPlayers;
    }

    public RacePlayer getOpponent(Player racePlayer) {

        for (RacePlayer player : rPlayers.values()) {
            if (player.getID() != racePlayer.getID()) {
                return player;
            }
        }

        return null; // error
    }

    public int getOpponentID(int playerID) {

        for (RacePlayer player : rPlayers.values()) {
            if (player.getID() != playerID) {
                return player.getID();
            }
        }

        return -1; // error
    }

    // USSAGE: Called by RequestRRStartGame.
    // Sends an output to the clients of this race to start the countdown 
    // sequence to the start of a race.
    public void startRace(int player_id) {

        for (int p_id : getPlayers().keySet()) {
            if (p_id == player_id) {
                playersReadyToStart++;
            }
        }

        if (playersReadyToStart == Constants.MAX_NUMBER_OF_PLAYERS) {
            ResponseRRStartGame responseStart = new ResponseRRStartGame();
            for (int p_id : getPlayers().keySet()) {
                NetworkManager.addResponseForUser(p_id, responseStart);
            }
        }
    }

    public void setFinalTime(int playerID, float finalString) {

        RacePlayer temp = this.rPlayers.get(playerID);
        temp.setFinalTime(finalString);
        this.rPlayers.put(raceID, temp);
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }
}
