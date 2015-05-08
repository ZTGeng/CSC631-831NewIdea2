// DAO for Race object.
// @author: Joseph Fernandez

package dataAccessLayer;

// Java imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Other Imports
import race.Race; // import model.Race

public final class RaceDAO {

    private RaceDAO() {;}

    // create or join race for player
    public static Race startRace(int playerID) throws SQLException
    {
        Connection connection = null;
        PreparedStatement pstmt = null;
        Race race = null;
        
        // SQL query for finding available races
        String findRaceQuery = "SELECT * FROM `runner_racelist` WHERE `num_players` = 1 OR `num_players` = 0 LIMIT 1";
        
        // SQL query for creating new race
        String createRaceQuery = "INSERT INTO `runner_racelist` VALUES (DEFAULT, DEFAULT)";
        
        // SQL query for retrieving recently created race
        String newestRaceQuery = "SELECT * FROM `runner_racelist` ORDER BY `race_id` DESC LIMIT 1";
        
        // SQL query for updating number of players (after joining race)
        // parametrized to prevent SQL injection
        String updateNumberOfPlayersQuery = "UPDATE `runner_racelist` SET `num_players` = ? WHERE `race_id` = ?";
        
        try
        {
            // establish connection to DB
            connection = DAO.getDataSource().getConnection();
            pstmt = connection.prepareStatement(findRaceQuery);
            ResultSet rs = pstmt.executeQuery();
            
            // if no available races, create new race
            if (!rs.isBeforeFirst())
            {
                // create new race record in DB
                pstmt = connection.prepareStatement(createRaceQuery);
                
                // in case of failure to create record
                if (pstmt.executeUpdate() != 1)
                {
                    throw new Exception();
                }
                
                // then pull out the newly created race record in DB to create race
                pstmt = connection.prepareStatement(newestRaceQuery);
                rs = pstmt.executeQuery();
            }
            
            // in case record wasn't created...
            if (!rs.first())
            {
                throw new Exception();
            }
            
            // update number of players for race
            int newestRaceID = rs.getInt("race_id"); // get ID of selected race
            pstmt = connection.prepareStatement(updateNumberOfPlayersQuery);
            int currentNumberOfPlayers = rs.getInt("num_players"); // get number of players of selected race
            
            if (currentNumberOfPlayers == 1) // race is now full
            {
                pstmt.setInt(1, 2); // ... SET `num_players` = 2
            }
            else if (currentNumberOfPlayers == 0) // race needs one more player
            {
                pstmt.setInt(1, 1); // ... SET `num_players` = 1
            }
            else
            {
                throw new Exception(); // anomaly in DB access?
            }
            
            pstmt.setInt(2, newestRaceID); // only set change to record that has ID of selected race
            
            // in case of failure to update record
            if (pstmt.executeUpdate() != 1)
            {
                throw new Exception();
            }
            
            // all done with queries
            rs.close();
            pstmt.close();
        }
        
        // catch any exceptions when connecting to database
        catch (Exception e)
        {
            System.err.print("Error. Unable to connect to database.");
        }
        
        // close connection
        finally
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        
        return race;
    }
}
