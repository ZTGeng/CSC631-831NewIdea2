// @author Joseph Fernandez
// RunnerSpecies (playable species) models created from RunnerSpeciesDAO.

package model;

// Other Imports
import java.util.List;
import java.util.ArrayList;

public class RunnerSpecies {
    private List<Integer> predatorList, // list of predators (by ID)
            preyList; // list of prey (by ID)
    private final int runnerSpeciesID, // ID of playable species; conveniently the same ID as that in universal 'species' table in DB
            speciesID, // ID of playable species in universal 'species' table
            health; // starting health of playable species
    private final float speed,
            jump, // jumping ability
            power; // "armor" ability
    private final boolean canFly;
    
    public RunnerSpecies(int runnerSpeciesID, int speciesID, int health, float speed, float jump, float power, boolean canFly)
    {
        this.runnerSpeciesID = runnerSpeciesID;
        this.speciesID = speciesID;
        this.health = health;
        this.speed = speed;
        this.jump = jump;
        this.power = power;
        this.canFly = canFly;
        predatorList = new ArrayList<Integer>();
        preyList = new ArrayList<Integer>();
    }
    
    // data retrieval and setting
    public int getRunnerID()
    {
        return runnerSpeciesID;
    }
    
    public int getSpeciesID()
    {
        return speciesID;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public float getSpeed()
    {
        return speed;
    }
    
    public float getJump()
    {
        return jump;
    }
    
    public float getPower()
    {
        return power;
    }
    
    public boolean canFly()
    {
        return canFly;
    }
    
    // add predator to list of predators
    public void addPredator(int predatorID)
    {
        predatorList.add(predatorID);
    }
    
    // add prey to list of prey
    public void addPrey(int preyID)
    {
        preyList.add(preyID);
    }
}
