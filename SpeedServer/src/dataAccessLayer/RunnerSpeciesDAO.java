// @author Joseph Fernandez
// Database object for creating RunnerSpecies models (playable species).

package dataAccessLayer;

// Other Imports
import model.RunnerSpecies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class RunnerSpeciesDAO {
    private RunnerSpeciesDAO() {;}
    
    public static List<RunnerSpecies> getRunnerSpecies() throws SQLException
    {
        List<RunnerSpecies> runnerSpeciesList = new ArrayList<RunnerSpecies>(); // list of available species to play as
        Map<Integer, List<Integer>> predatorMap = ConsumeDAO.getPreyToPredatorTable(); // list of predators (from ConsumeDAO)
        Map<Integer, List<Integer>> preyMap = ConsumeDAO.getPredatorToPreyTable(); // list of prey (from ConsumeDAO)
        
        String query = "SELECT * FROM `runner_species`"; // SQL
        Connection connection = null; // DB connection
        PreparedStatement pstmt = null; // SQL execution
        
        try
        {
            connection = DAO.getDataSource().getConnection();
            pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(); // result of SQL execution
            
            int ID = 0; // for ID check in case of possible dummy entries
            RunnerSpecies rSpecies = null;
            
            while (rs.next())
            {
                if ((ID = rs.getInt("runner_id")) > 0) // ID check; don't retrieve any records with invalid ID
                {
                    // define species
                    rSpecies = new RunnerSpecies(ID, rs.getInt("species_id"), rs.getInt("health"), rs.getFloat("speed"), rs.getFloat("jump"), rs.getFloat("power"), rs.getBoolean("flight"));
                }
                
                runnerSpeciesList.add(rSpecies);
            }
            
            // all done with queries
            rs.close();
            pstmt.close();
            
            // get predators and prey of each species
            // refer to ConsumeDAO
            for (RunnerSpecies runner : runnerSpeciesList)
            {
                ID = runner.getSpeciesID();
                if (predatorMap.containsKey(ID))
                {
                    for (int predatorID : predatorMap.get(ID))
                    {
                        runner.addPredator(predatorID);
                    }
                }
                if (preyMap.containsKey(ID))
                {
                    for (int preyID : preyMap.get(ID))
                    {
                        runner.addPrey(preyID);
                    }
                }
            }            
        }
        catch (Exception e)
        {
            System.err.println("Error in retrieving species.");
        }
        finally // close connection
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        
        return runnerSpeciesList;
    }
}
