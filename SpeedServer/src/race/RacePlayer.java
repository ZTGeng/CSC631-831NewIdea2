package race;

// Other Imports
import core.GameClient;
import model.Player;

/**
 * The Player class holds important information about the player including, most
 * importantly, the account. Such information includes the username, password,
 * email, and the player ID.
 */
public class RacePlayer extends Player {

    private RacePlayer opponent;
    private int x;
    private int y;
    private int distanceTraveled;
    private short gameover;
    private short gameState;
    
    public RacePlayer(int player_id, int raceID){
        super(player_id);
        
    }

    public RacePlayer getOpponent() {
        return opponent;
    }

    public RacePlayer setOpponent(RacePlayer opponent) {
        return this.opponent = opponent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int setX(int x) {
        return this.x = x;
    }

    public int setY(int y) {
        return this.y = y;
    }
    
    public int getDistanceTraveled() {
        return distanceTraveled;
    }
    
    public int setDistanceTraveled(int distanceTraveled) {
        return this.distanceTraveled = distanceTraveled;
    }
    
    public short getGameover() {
        return gameover;
    }
    
    public short setGameover(short gameover) {
        return this.gameover = gameover;
    }
    
    public short getGameState() {
        return gameState;
    }
    
    public short setGameState(short gameState) {
        return this.gameState = gameState;
    }
    
}
