package race;
import core.GameClient;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import model.Player;



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
    private int raceID; // needs to be a string, set up similar to the unqiue_session_ID in gameServer
    private Map<Integer, RacePlayer> rPlayers = new HashMap<Integer, RacePlayer>();
    
    
    private short shortPlayersInGame;  // number of players in a game
    private GameClient client1;
    private GameClient client2;
    private short state;
    
    
    
    public Race(List<Player> players){
        
        raceID =-1;
        for(Player player: players) {
            this.rPlayers.put(Integer.valueOf(player.getID()), new RacePlayer(player.getID(), raceID));
        }
        
//        shortPlayersInGame = 0;
//        state = 0;
    }
   
//    public Race(GameClient player1, GameClient player2){
//        this.client1 = player1;
//        this.client2 = player2;
//    }
    
    public int getID(){
        return this.raceID;
    }
    
    public Map<Integer, RacePlayer> getPlayers() {
        return rPlayers;
    }

    /**
     * @return the client1
     */
    public GameClient getClient1() {
        return client1;
    }

    /**
     * @return the client2
     */
    public GameClient getClient2() {
        return client2;
    }

    /**
     * @param client1 the client1 to set
     */
    public void setClient1(GameClient client1) {
        this.client1 = client1;
        shortPlayersInGame++;
    }

    /**
     * @param client2 the client2 to set
     */
    public void setClient2(GameClient client2) {
        this.client2 = client2;
        shortPlayersInGame++;
    }
    
    public short getNumberOfPlayersInGame() {
        return shortPlayersInGame;
    }
    
    public void setOpponentsOfGame(){
        client1.setOpponent(client2.getPlayer());
        client2.setOpponent(client1.getPlayer());
    }
    
    public void setStateOn(){
        state = 1;        
        client1.setGameState(state);
        client2.setGameState(state);
    }
    
    public void setStateOff(){
        state = 0;
        client1.setGameState(state);
        client2.setGameState(state);
    }
}
//
//package model;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author markfavis
// */
//public class Race {
//    
//    private int uniqueGameInstanceID;
//    private String client1;
//    private String client2;
//    
//    public Race(){
//        
//    }
//    
//    public Race(int gameID, String client1, String client2){
//        this.uniqueGameInstanceID = gameID;
//        client1 = client1;
//        client2 = client2;
//    }
//
//    /**
//     * @return the uniqueGameInstanceID
//     */
//    public int getUniqueGameInstanceID() {
//        return uniqueGameInstanceID;
//    }
//
//    /**
//     * @return the client1
//     */
//    public String getPlayer1SessionID() {
//        return client1;
//    }
//
//    /**
//     * @return the client2
//     */
//    public String getPlayer2SessionID() {
//        return client2;
//    }
//
//    /**
//     * @param uniqueGameInstanceID the uniqueGameInstanceID to set
//     */
//    public void setUniqueGameInstanceID(int uniqueGameInstanceID) {
//        this.uniqueGameInstanceID = uniqueGameInstanceID;
//    }
//
//    /**
//     * @param client1 the client1 to set
//     */
//    public void setPlayer1SessionID(String client1) {
//        this.client1 = client1;
//    }
//
//    /**
//     * @param client2 the client2 to set
//     */
//    public void setPlayer2SessionID(String client2) {
//        this.client2 = client2;
//    }
//    
//    
//}


