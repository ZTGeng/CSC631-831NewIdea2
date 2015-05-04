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

    private int raceID;
    private int status;
    private RacePlayer opponent;

    // For the database
    private int x;
    private int y;
    private int speed;
    private int boosts; // Number of boosts (positive speed items) a user has.
    private int species;
    
//    private int distanceTraveled;
//    private short gameover;
//    private short gameState;
    
    //Key inputs
    private boolean right;
    private boolean left;
    private boolean jump;
    private boolean boost;
    
    
    public RacePlayer(int player_id, int raceID){
        super(player_id);
        this.raceID = raceID;
        
    }

    public int getRaceID() {
        return raceID;
    }

    public void setRaceID(int raceID){
        this.raceID = raceID;
    }
//    public RacePlayer getOpponent() {
//        return opponent;
//    }
//
//    public RacePlayer setOpponent(RacePlayer opponent) {
//        return this.opponent = opponent;
//    }

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
    
//    public int getDistanceTraveled() {
//        return distanceTraveled;
//    }
//    
//    public int setDistanceTraveled(int distanceTraveled) {
//        return this.distanceTraveled = distanceTraveled;
//    }
//    
//    public short getGameover() {
//        return gameover;
//    }
//    
//    public short setGameover(short gameover) {
//        return this.gameover = gameover;
//    }
//    
//    public short getGameState() {
//        return gameState;
//    }
//    
//    public short setGameState(short gameState) {
//        return this.gameState = gameState;
//    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the right
     */
    public boolean isRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * @return the jump
     */
    public boolean isJump() {
        return jump;
    }

    /**
     * @param jump the jump to set
     */
    public void setJump(boolean jump) {
        this.jump = jump;
    }

    /**
     * @return the boost
     */
    public boolean isBoost() {
        return boost;
    }

    /**
     * @param boost the boost to set
     */
    public void setBoost(boolean boost) {
        this.boost = boost;
    }

    /**
     * @return the boosts
     */
    public int getBoosts() {
        return boosts;
    }

    /**
     * @param boosts the boosts to set
     */
    public void setBoosts(int boosts) {
        this.boosts = boosts;
    }

    /**
     * @return the opponent
     */
    public RacePlayer getOpponent() {
        return opponent;
    }

    /**
     * @param opponent the opponent to set
     */
    public void setOpponent(RacePlayer opponent) {
        this.opponent = opponent;
    }

    /**
     * @return the species
     */
    public int getSpecies() {
        return species;
    }

    /**
     * @param species the species to set
     */
    public void setSpecies(int species) {
        this.species = species;
    }
    
}
