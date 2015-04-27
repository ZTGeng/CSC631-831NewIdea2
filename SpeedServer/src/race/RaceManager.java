/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

import core.GameClient;
import java.util.HashMap;
import utility.Log;
import core.GameServer;
import core.NetworkManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import model.Player;
import networking.response.ResponseRaceInit;

/**
 *
 * @author markfavis
 */
public class RaceManager {
    
    // Singleton Instance
    public static RaceManager manager;
    
    // Regerence Tables
    private Map<Integer, Race> raceList = new HashMap<Integer, Race>(); //RaceID -> race
    private Map<Integer, Race> playerRaceList = new HashMap<Integer, Race>(); //PlayerID -> race

    
    private List<Player> players = new ArrayList<Player>(); //used to create a race
    
    protected short numberOfGamesBeingPlayed;
    
    private final short MAX_NUMBER_OF_PLAYERS = 2;
    
    public static RaceManager getInstance(){
        if (manager == null) {
            manager = new RaceManager();
        }
        
        return manager;
    }

   
    public Race createRace(int player_id) {
        Race race = null;
        
        if (players.isEmpty()) {
            players.add(GameServer.getInstance().getActivePlayer(player_id));
        } else {
            if (player_id != players.get(0).getID()) {
                players.add(GameServer.getInstance().getActivePlayer(player_id));
                race = new Race(players);
                add(race);
                ResponseRaceInit response = new ResponseRaceInit();
                for(int p_id : race.getPlayers().keySet()) {
                    NetworkManager.addResponseForUser(p_id, response);
                }
                players.clear();
            }
        }
        
        return race;
    }
    
    public Race add(Race race){
        for (int id : race.getPlayers().keySet()) {
            playerRaceList.put(id, race);
        }
        return raceList.put(race.getID(), race);
    }
    
    public Race getRaceByPlayerID(int playerID) {
        return playerRaceList.get(playerID);
    }
//    //Adds a client to the correct game out of a list of raceList and makes sure there is a game for the client to be added to.
//    public void addClientToGame(GameClient client) {
//        noCurrentGames();
//        PlaceClient(client);
//        createNewGame();
//    }
//    
//    //checks to see if any raceList exisit and if not creates one;
//    void noCurrentGames() {
//        if (raceList.isEmpty()){
//            raceList.add(new Race(null, null));
//        
//            //debugging
//            Log.printf("No games set up, creating a new game.");
//        }
//    }
//    
//    //Places the client into the open game with the correct player position and sets the opponent of each client as the other client when there is enough clients in game.
//    void PlaceClient(GameClient client) {     
//        Race game = raceList.get(raceList.size()-1);
//        switch (game.getNumberOfPlayersInGame()){
//            case 0: game.setClient1(client);
//                    //debugging
//                    Log.printf("Setting first player in a Game.");
//                    break;
//            case 1: game.setClient2(client);
//                    game.setOpponentsOfGame();
//                    game.setStateOn();
//                    //debugging
//                    Log.printf("Setting second player in a Game and setting opponents.");
//                    break;
//        }
//    }    
//    
//    // Checks to see if the last game in the list is full and if so creates a new one.
//    void createNewGame() {
//        if (raceList.get(raceList.size()-1).getNumberOfPlayersInGame() == MAX_NUMBER_OF_PLAYERS){
//            raceList.add(new Race(null, null));
//        }
//    }
}

