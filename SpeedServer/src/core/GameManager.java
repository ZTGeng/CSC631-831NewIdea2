/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import model.Game;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markfavis
 */
public class GameManager {
    
    protected List<Game> games;
//    protected HashMap 
    protected short numberOfGamesBeingPlayed;
    
    private final short MAX_NUMBER_OF_PLAYERS = 2;
    
    GameManager(){
        games = new ArrayList<Game>();
        numberOfGamesBeingPlayed = 0;
        
    }
    
    //Adds a client to the correct game out of a list of games and makes sure there is a game for the client to be added to.
    public void addClientToGame(GameClient client) {
        noCurrentGames();
        PlaceClient(client);
        createNewGame();
    }
    
    //checks to see if any games exisit and if not creates one;
    void noCurrentGames() {
        if (games.isEmpty())
            games.add(new Game(null, null));
    }
    
    //Places the client into the open game with the correct player position. index of the last index in the list of games which will always be a non full game;
    void PlaceClient(GameClient client) {        
        switch (games.get(games.size()).getNumberOfPlayersInGame()){
            case 0: games.get(games.size()).setPlayer1(client);
                    break;
            case 1: games.get(games.size()).setPlayer2(client);
                    break;
        }
    }    
    
    // Checks to see if the last game in the list is full and if so creates a new one.
    void createNewGame() {
        if (games.get(games.size()).getNumberOfPlayersInGame() == MAX_NUMBER_OF_PLAYERS){
            games.add(new Game(null, null));
        }
    }
    
}
