
package model;

import core.GameClient;

import core.GameServer;
import metadata.Constants;
import model.Player;
import networking.response.ResponseLogin;
import utility.DataReader;
import utility.Log;

/**
 * The Location class maintains X and Y coordinates of game objects existing in
 * the runner scene.
 */
public class Location {
    
    private float x;
    private float y;
    private GameClient client; // References GameClient instance
    private Player player;
    
    public Location setCoordinates(float x, float y){
        setX(x);
        setY(y);
        return this;
    }
    
    public float setX(float x){
        return this.x = x;
    }
    
    public float setY(float y){
        return this.x = y;
    }
    
    public Player setPlayer(Player player){
        return this.player = player;
    }
    
    public GameClient setClient(GameClient client) {
        return this.client = client;
    }
}
