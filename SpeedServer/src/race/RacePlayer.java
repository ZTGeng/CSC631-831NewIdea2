// Info and data on players of race. Extends Player class.
// @authors: Mark Favis, Joseph Fernandez

package race;

// Other Imports
// import core.GameClient;
import model.Player;

public class RacePlayer extends Player {

    private int raceID, // race ID that player is currently in
            runnerSpeciesID, // ID of selected species
            health, // health of species
            status, // status of species (from items/boosts)
            itemID, // currently held item (0 if not holding anything)
            numItems, // number of items collected
            time, // current time of player
            score; // current score of player
    private float x, // x position of player
            y, // y position of player
            speed, // current speed of player
            power, // current power of player
            finalTime;
    private boolean right,
            left,
            jump;
    private RacePlayer opponent;
    
    // private short gameover;
    // private short gameState;
    
    public RacePlayer(int player_id, int raceID) {
        super(player_id);
        this.raceID = raceID;
    }

    // @return: raceID of race
    public int getRaceID() {
        return raceID;
    }

    // @param: raceID race ID that the player will be in
    public void setRaceID(int raceID){
        this.raceID = raceID;
    }
    
    public int getRunnerSpeciesID() {
        return runnerSpeciesID;
    }
    
    public void setRunnerSpeciesID(int runnerSpeciesID) {
        this.runnerSpeciesID = runnerSpeciesID;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getItemID() {
        return itemID;
    }
    
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    
    public int getTime() {
        return time;
    }
    
    public void setTime(int time) {
        this.time = time;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
    public float setX(float x) {
        return this.x = x;
    }

    public float setY(float y) {
        return this.y = y;
    }
    
    /*
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
    */

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    public float getPower() {
        return power;
    }
    
    public void setPower(float power) {
        this.power = power;
    }

    /**
     * @return if player is going right
     */
    public boolean isRight() {
        return right;
    }

    /**
     * @param right is player going right?
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * @return if player is going left
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * @param left is player going left?
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * @return if player jumped
     */
    public boolean isJump() {
        return jump;
    }

    /**
     * @param jump is player jumping?
     */
    public void setJump(boolean jump) {
        this.jump = jump;
    }

    /**
     * @return number of collected items
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     * @param numItems number of collected items
     */
    public void setNumItems(int numItems) {
        this.numItems = numItems;
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
    
    public float getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(float finalTime) {
        this.finalTime = finalTime;
    }
}