package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markfavis
 */
<<<<<<< HEAD
=======
import core.GameClient;
   
>>>>>>> michael
public class Game {
    
    private int uniqueGameInstanceID;
    private String player1SessionID;
    private String player2SessionID;
<<<<<<< HEAD
=======
    private GameClient player1;
    private GameClient player2;
    
>>>>>>> michael
    
    public Game(){
        
    }
    
    public Game(int gameID, String player1, String player2){
        this.uniqueGameInstanceID = gameID;
        player1SessionID = player1;
        player2SessionID = player2;
    }

    /**
     * @return the uniqueGameInstanceID
     */
    public int getUniqueGameInstanceID() {
        return uniqueGameInstanceID;
    }

    /**
     * @return the player1SessionID
     */
    public String getPlayer1SessionID() {
        return player1SessionID;
    }

    /**
     * @return the player2SessionID
     */
    public String getPlayer2SessionID() {
        return player2SessionID;
    }

    /**
     * @param uniqueGameInstanceID the uniqueGameInstanceID to set
     */
    public void setUniqueGameInstanceID(int uniqueGameInstanceID) {
        this.uniqueGameInstanceID = uniqueGameInstanceID;
    }

    /**
     * @param player1SessionID the player1SessionID to set
     */
    public void setPlayer1SessionID(String player1SessionID) {
        this.player1SessionID = player1SessionID;
    }
<<<<<<< HEAD
=======
    
    public void setPlayer1GameClient(GameClient client) {
        player1 = client;
    }
>>>>>>> michael

    /**
     * @param player2SessionID the player2SessionID to set
     */
    public void setPlayer2SessionID(String player2SessionID) {
        this.player2SessionID = player2SessionID;
    }
    
<<<<<<< HEAD
=======
    public void setPlayer2GameClient(GameClient client) {
        player2 = client;
        setOpponentInClients();
    }
    
    /*
    Used to set the opponents in the clients who's playerIDs match 
    player#SessionIDs only after the second Player has been set.
    */
    private void setOpponentInClients(){
        player1.setOpponent(player2.getPlayer());
        player2.setOpponent(player1.getPlayer());
    }
    
>>>>>>> michael
    
}
