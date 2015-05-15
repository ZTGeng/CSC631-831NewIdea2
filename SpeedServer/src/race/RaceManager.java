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
import java.util.Random;
import networking.response.ResponseRREndGame;

/**
 *
 * @author markfavis
 */
public class RaceManager {

    // Singleton Instance
    public static RaceManager manager;

    // Regerence Tables
    private Map<Integer, Race> raceList = new HashMap<Integer, Race>(); //RaceID -> race
    public Map<Integer, Race> playerRaceList = new HashMap<Integer, Race>(); //PlayerID -> race

    private List<Player> players = new ArrayList<Player>(); //used to create a race

    public static RaceManager getInstance() {
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
                // random generator used for generating map
                Random randomGenerator = new Random();
                // create raceID randomly
                int raceID = randomGenerator.nextInt(2001);
                while (raceList.containsKey(raceID)) {
                    raceID = randomGenerator.nextInt(2001);
                    System.out.println("Race ID:" + raceID);
                }
                System.out.println("Race ID:" + raceID);
                players.add(GameServer.getInstance().getActivePlayer(player_id));
                race = new Race(players, raceID);  // fix 2nd parameter
                race.setMapID(randomGenerator.nextInt(101));
                //System.out.println("Map ID:" + race.getMapID());
                add(race);
                // Respond to Players to load the Runner scene
                ResponseRaceInit response = new ResponseRaceInit();
                for (int p_id : race.getPlayers().keySet()) {
                    NetworkManager.addResponseForUser(p_id, response);
                }
                players.clear();
            }

        }
        return race;
    }

    public void endRace(int raceID, int playerID) throws Exception {
        Race race = raceList.get(raceID);
        int opponentID = race.getOpponentID(playerID);
        Map<Integer, RacePlayer> racePlayer = race.getPlayers();
        RacePlayer thisRacePlayer = racePlayer.get(playerID);
        RacePlayer opponentRacePlayer = racePlayer.get(opponentID);

        ResponseRREndGame response = new ResponseRREndGame();
        // determine who won
        boolean playerWon = false;
        if (thisRacePlayer.getFinalTime() > opponentRacePlayer.getFinalTime()) {
            playerWon = true;
            response.setWinningTime(String.valueOf(thisRacePlayer.getFinalTime()));
        } else {
            response.setWinningTime(String.valueOf(opponentRacePlayer.getFinalTime()));
        }

        for (int p_id : race.getPlayers().keySet()) {
            if (playerID == p_id) {
                response.setWin(playerWon);
            } else {
                response.setWin(!playerWon);
            }
            GameServer.getInstance().getThreadByPlayerID(p_id).send(response);
        }
    }

    public void removePlayerFromRaceList(int player_id) {
        playerRaceList.remove(player_id);
    }

    public void destroyRace(int race_id) {
        raceList.remove(race_id);
    }

    public Race add(Race race) {
        for (int id : race.getPlayers().keySet()) {
            playerRaceList.put(id, race);
        }
        return raceList.put(race.getID(), race);
    }

    public Race getRaceByPlayerID(int playerID) {
        return playerRaceList.get(playerID);
    }
}
