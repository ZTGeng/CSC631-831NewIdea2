package model;
import core.GameClient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markfavis
 */
public class Game {
    
//    private 
    private short shortPlayersInGame;
    private GameClient player1;
    private GameClient player2;
    
    public Game(){
        shortPlayersInGame = 0;
    }
   
    public Game(GameClient player1, GameClient player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * @return the player1
     */
    public GameClient getPlayer1() {
        return player1;
    }

    /**
     * @return the player2
     */
    public GameClient getPlayer2() {
        return player2;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(GameClient player1) {
        this.player1 = player1;
        shortPlayersInGame++;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(GameClient player2) {
        this.player2 = player2;
        shortPlayersInGame++;
    }
    
    public short getNumberOfPlayersInGame() {
        return shortPlayersInGame;
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
//public class Game {
//    
//    private int uniqueGameInstanceID;
//    private String player1;
//    private String player2;
//    
//    public Game(){
//        
//    }
//    
//    public Game(int gameID, String player1, String player2){
//        this.uniqueGameInstanceID = gameID;
//        player1 = player1;
//        player2 = player2;
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
//     * @return the player1
//     */
//    public String getPlayer1SessionID() {
//        return player1;
//    }
//
//    /**
//     * @return the player2
//     */
//    public String getPlayer2SessionID() {
//        return player2;
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
//     * @param player1 the player1 to set
//     */
//    public void setPlayer1SessionID(String player1) {
//        this.player1 = player1;
//    }
//
//    /**
//     * @param player2 the player2 to set
//     */
//    public void setPlayer2SessionID(String player2) {
//        this.player2 = player2;
//    }
//    
//    
//}


