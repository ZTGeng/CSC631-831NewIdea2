// DAO for Race and RacePlayer objects.
// @author: Joseph Fernandez

package dataAccessLayer;

// Java imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Other imports
import race.RacePlayer;
import utility.Log;

// List of methods (excluding constructor):
// - findRace - update DB when player is joining or creating race
// - setPlayerSpecies - write player's selected species to DB right away
// - updateRace - update data in DB of player during race
// - finishRace - update data in DB of player when finishing race
// - leaveRace - update data, remove records of race and player in DB when player leaves

public final class RaceDAO {

    private RaceDAO() {;}

    // records to DB for player finding (creating or joining) races
    // @param: playerID - ID of joining player
    // @return: (int) ID of selected race
    // @throws: SQLException
    public static int findRace(int playerID) throws SQLException
    {
        Connection connection = null;
        PreparedStatement pstmt;
        int selectedRaceID = -1, // ID of selected race
                currentNumberOfPlayers; // number of players of selected race
        
        // SQL query for finding available races
        String findRaceQuery = "SELECT * FROM `runner_racelist` WHERE `num_players` = 1 OR `num_players` = 0 LIMIT 1",
        
        // SQL query for creating new race
        createRaceQuery = "INSERT INTO `runner_racelist` VALUES (DEFAULT, DEFAULT)",
        
        // SQL query for retrieving recently created race
        newestRaceQuery = "SELECT * FROM `runner_racelist` ORDER BY `race_id` DESC LIMIT 1",
        
        // SQL query for updating number of players (after joining race)
        // parametrized to prevent SQL injection
        updateNumberOfPlayersQuery = "UPDATE `runner_racelist` SET `num_players` = ? WHERE `race_id` = ?",
        
        // SQL query for setting up detailed race info
        // parametrized to prevent SQL injection
        setupRaceQuery = "INSERT INTO `runner_raceinfo` VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try
        {
            // establish connection to DB
            // pull out records of available races (if any)
            connection = DAO.getDataSource().getConnection();
            pstmt = connection.prepareStatement(findRaceQuery);
            ResultSet rs = pstmt.executeQuery();
            
            // if no available races according to DB, create new race record in DB
            if (!rs.first())
            {
                // create new race record in DB
                pstmt = connection.prepareStatement(createRaceQuery);
                
                // in case of failure to create record
                if (pstmt.executeUpdate() != 1)
                {
                    throw new Exception("Database error. Failed to create new race record in `racelist`.");
                }
                
                // then pull out the newly created race record in DB for race creation
                pstmt = connection.prepareStatement(newestRaceQuery);
                rs = pstmt.executeQuery();
            }
            
            // in case record wasn't created...
            if (!rs.first())
            {
                throw new Exception("Database error. Created race record not found in `racelist`.");
            }
            
            // update number of players of race record (in `racelist_info`)
            selectedRaceID = rs.getInt("race_id"); // get ID of selected race
            currentNumberOfPlayers = rs.getInt("num_players"); // get number of players of selected race
            pstmt = connection.prepareStatement(updateNumberOfPlayersQuery);
            
            if (currentNumberOfPlayers == 1) // race is now full according to record
            {
                pstmt.setInt(1, 2); // ... SET `num_players` = 2
            }
            else if (currentNumberOfPlayers == 0) // race needs one more player according to record
            {
                pstmt.setInt(1, 1); // ... SET `num_players` = 1
            }
            else
            {
                throw new Exception("Database error. Newly created record of race ID " + selectedRaceID + " not found in `racelist`."); // problem in accessing DB
            }
            
            pstmt.setInt(2, selectedRaceID); // only set change to record that has ID of selected race
            
            // execute query...
            if (pstmt.executeUpdate() != 1)
            {
                // in case of failure to update record
                throw new Exception("Database error. Failed to update newly created record of race ID " + selectedRaceID + " in `racelist`.");
            }
            
            // set up record for player in selected race (in `runner_raceinfo`)
            pstmt = connection.prepareStatement(setupRaceQuery);
            pstmt.setInt(1, playerID);
            pstmt.setInt(2, selectedRaceID);
            
            // define remainined parameters - defaults
            
            // runner_id - set to 31 (Tree Mouse) as default
            // other values are invalid unless ID defined in `runner_species` and `species` - won't be able to insert records otherwise
            pstmt.setInt(3, 31);
            pstmt.setFloat(4, 0); // x_pos
            pstmt.setFloat(5, 0); // y_pos
            pstmt.setInt(6, 0); // direction
            pstmt.setBoolean(7, false); // in_air
            pstmt.setInt(8, 0); // health
            pstmt.setFloat(9, 0); // speed
            pstmt.setFloat(10, 0); // power
            pstmt.setInt(11, 0); // status
            
            // runner_item_id  set to 1 (none) as default
            // other values are invalid unless ID defined in `runner_items` - won't be able to insert records otherwise
            pstmt.setInt(12, 1);
            pstmt.setInt(13, 0); // num_items
            pstmt.setInt(14, 0); // time
            pstmt.setInt(15, 0); // score
            
            // execute query...
            if (pstmt.executeUpdate() != 1)
            {
                // in case of failure to update record
                throw new Exception("Database error. Failed to update newly created record of race ID " + selectedRaceID + " for player ID " + playerID + ".");
            }
              
            // all done with queries
            rs.close();
            pstmt.close();
        }
        
        // catch any exceptions when connecting to database
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            Log.println_e(e.getMessage());
        }
        
        // close connection
        finally
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        
        return selectedRaceID;
    }
    
    // save species that player selected to DB right away
    // @param: player - the player
    // @return: (int) ID of species
    // @throws: SQLException
    public static int setPlayerSpecies(RacePlayer player) throws SQLException
    {
        Connection connection = null;
        PreparedStatement pstmt;
        int runnerID = -1; // ID of selected species
        
        // SQL query for updating number of players (after joining race)
        // parametrized to prevent SQL injection
        String updateRacePlayerQuery = "UPDATE `runner_raceinfo` SET `runner_id` = ? WHERE `player_id` = ?";
        
        try
        {
            // get ID of selected species
            runnerID = player.getRunnerID();
            
            // establish connection to DB
            // update race record of player with ID of selected species
            connection = DAO.getDataSource().getConnection();
            pstmt = connection.prepareStatement(updateRacePlayerQuery);
            pstmt.setInt(1, runnerID);
            pstmt.setInt(2, player.getID());
            
            // in case of failure to create record
            if (pstmt.executeUpdate() != 1)
            {
                throw new Exception("Database error. Failed to write selected species of player ID " + player.getID() + " in race ID " + player.getRaceID() + ".");
            }
            
            // all done with queries
            pstmt.close();
        }
        
        // catch any exceptions when connecting to database
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            Log.println_e(e.getMessage());
        }
        
        // close connection
        finally
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        
        return runnerID;
    }
    
    // update records of players in DB during race
    // @param: player - the player
    // @return: (int) ID of player
    // @throws: SQLException
    public static int updateRace(RacePlayer player) throws SQLException
    {
        Connection connection = null;
        PreparedStatement pstmt;
        int playerID = -1; // ID of player
        
        // SQL query for updating number of players (after joining race)
        // parametrized to prevent SQL injection
        String updateRacePlayerQuery = "UPDATE `runner_raceinfo` "
                + "SET `x_pos` = ?, "
                + "`y_pos` = ?, "
                + "`direction` = ?, "
                + "`in_air` = ?, "
                + "`health` = ?, "
                + "`speed` = ?, "
                + "`power` = ?, "
                + "`status` = ?, "
                + "`runner_item_id` = ?, "
                + "`num_items` = ?, "
                + "`time` = ?, "
                + "`score` = ? "
                + "WHERE `player_id` = ?";
        
        try
        {
            // get player ID
            playerID = player.getID();
            
            // establish connection to DB
            // update record of player in DB accordingly
            connection = DAO.getDataSource().getConnection();
            pstmt = connection.prepareStatement(updateRacePlayerQuery);
            pstmt.setFloat(1, player.getX()); // x_pos
            pstmt.setFloat(2, player.getY()); // y_pos
            
            // direction (0 = no side input, 1 = left, 2 = right)
            if (player.isLeft())
            {
                pstmt.setInt(3, 1);
            }
            else if (player.isRight())
            {
                pstmt.setInt(3, 2);
            }
            else
            {
                pstmt.setInt(3, 0);
            }
            
            // in_air
            // MySQL aliases 0 = true, 1 = false
            if (player.isJump())
            {
                pstmt.setInt(4, 0);
            }
            else
            {
                pstmt.setInt(4, 1);
            }
            pstmt.setInt(5, player.getHealth()); // health
            pstmt.setFloat(6, player.getSpeed()); // speed
            pstmt.setFloat(7, player.getPower()); // power
            pstmt.setInt(8, player.getStatus()); // status
            pstmt.setInt(9, player.getItemID()); // runner_item_id
            pstmt.setInt(10, player.getNumItems()); // num_items
            pstmt.setInt(11, player.getTime()); // time
            pstmt.setInt(12, player.getScore()); // score
            pstmt.setInt(13, playerID); // player_id
            
            // in case of failure to create record
            if (pstmt.executeUpdate() != 1)
            {
                throw new Exception("Database error. Failed to update record of player ID " + playerID + " in race ID " + player.getRaceID() + ".");
            }
            
            // all done with queries
            pstmt.close();
        }
        
        // catch any exceptions when connecting to database
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            Log.println_e(e.getMessage());
        }
        
        // close connection
        finally
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        
        return playerID;
    }
    
    // update player record in DB after end of race
    // @param: player - the player,
    //         earnedLevel - level up,
    //         earnedExp - earned experience,
    //         earnedCredits - earned credits
    // @return: (int) ID of player
    // @throws: SQLException
    public static int finishRace(RacePlayer player, int earnedLevel, int earnedExp, int earnedCredits) throws SQLException
    {
        Connection connection = null;
        PreparedStatement pstmt;
        int playerID = -1, // ID of player
                level, // current level of player
                exp, // current experience of player
                credits; // current credits of player
        
        // SQL query to load player's level, experience, and credits from database
        String getPlayerDataQuery = "SELECT `level`, `experience`, `credits` FROM `player` WHERE `player_id` = ?",
        
        // SQL query to update player data in DB after race is finished
        updatePlayerDataQuery = "UPDATE `player` "
            + "SET `level` = ?, "
            + "`experience` = ?, "
            + "`credits` = ? "
            + "WHERE `player_id` = ?";
        
        try
        {
            // get player ID
            playerID = player.getID();
            
            // establish connection to DB
            // update record of player in DB accordingly
            connection = DAO.getDataSource().getConnection();
            pstmt = connection.prepareStatement(getPlayerDataQuery);
            pstmt.setInt(1, playerID);
            ResultSet rs = pstmt.executeQuery();
            
            // load player record in DB; throw exception if no records exist
            if (!rs.first())
            {
                throw new Exception("Database error. Failed to load data of player ID " + playerID + ".");
            }
            
            // get player's current level, experience, credits
            level = rs.getInt("level");
            exp = rs.getInt("experience");
            credits = rs.getInt("credits");
            
            // update player's record
            pstmt = connection.prepareStatement(updatePlayerDataQuery);
            pstmt.setInt(1, level + earnedLevel);
            pstmt.setInt(2, exp + earnedExp);
            pstmt.setInt(3, credits + earnedCredits);
            pstmt.setInt(4, playerID);
            
            // in case of failure to update record
            if (pstmt.executeUpdate() != 1)
            {
                throw new Exception("Database error. Failed to update record of player ID " + playerID + ".");
            }
            
            // all done with queries
            pstmt.close();
            rs.close();
        }
        
        // catch any exceptions when connecting to database
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            Log.println_e(e.getMessage());
        }
        
        // close connection
        finally
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        
        return playerID;
    }
    
    // records to DB for player leaving races
    // @param: playerID - ID of leaving player
    // @return: (int) ID of race that the player was in
    // @throws: SQLException
    public static int leaveRace(int playerID) throws SQLException
    {
        Connection connection = null;
        PreparedStatement pstmt;
        int raceID = -1, // ID of race that the player was in
              currentNumberOfPlayers; // number of players of selected race
        
        // SQL query for finding race where player was
        String findRaceQuery = "SELECT * FROM `runner_raceinfo` WHERE `player_id` = ? LIMIT 1",
        
        // SQL query for deleting record of the race where the player was
        deleteRaceRecordQuery = "DELETE FROM `runner_raceinfo` WHERE `player_id` = ? AND `race_id` = ?",
        
        // SQL query for getting number of players in the race that the player was in
        getNumberOfPlayersQuery = "SELECT `num_players` FROM `runner_racelist` WHERE `race_id` = ?",
        
        // SQL query for updating number of players (after joining race)
        // parametrized to prevent SQL injection
        updateNumberOfPlayersQuery = "UPDATE `runner_racelist` SET `num_players` = ? WHERE `race_id` = ?";
        
        try
        {
            // establish connection to DB
            // pull record of race where player was
            connection = DAO.getDataSource().getConnection();
            pstmt = connection.prepareStatement(findRaceQuery);
            pstmt.setInt(1, playerID);
            ResultSet rs = pstmt.executeQuery();
            
            // if no race record of player found...
            if (!rs.first())
            {
                throw new Exception("Database error. Race record of player ID " + playerID + " not found.");
            }
            
            // get ID of the race that the player was in
            raceID = rs.getInt("race_id");
            
            // delete race record of leaving player from `runner_raceinfo`
            pstmt = connection.prepareStatement(deleteRaceRecordQuery);
            pstmt.setInt(1, playerID);
            pstmt.setInt(2, raceID);
            
            // in case deletion fails...
            if (pstmt.executeUpdate() != 1)
            {
                throw new Exception("Database error. Failed to delete record of race ID " + raceID + " of player ID " + playerID + ".");
            }
            
            // get number of players (player included) in the race that the player was in
            pstmt = connection.prepareStatement(getNumberOfPlayersQuery);
            pstmt.setInt(1, raceID);
            rs = pstmt.executeQuery();
            
            // in case record doesn't exist...
            if (!rs.first())
            {
                throw new Exception("Database error. Failed to find record of race ID + " + raceID + ".");
            }
            
            currentNumberOfPlayers = rs.getInt("num_players"); // get number of players of selected race
            
            // update number of players of race record (in `racelist_info`)
            pstmt = connection.prepareStatement(updateNumberOfPlayersQuery);
            
            if (currentNumberOfPlayers == 2) // one more player in race
            {
                pstmt.setInt(1, 1); // ... SET `num_players` = 1
            }
            else if (currentNumberOfPlayers == 1) // race is now empty
            {
                pstmt.setInt(1, 0); // ... SET `num_players` = 0
            }
            else
            {
                throw new Exception("Database error. Invalid number of players in record of race ID " + raceID + "."); // problem in accessing DB
            }
            
            pstmt.setInt(2, raceID); // only set change to record that has ID of selected race
            
            // in case of failure to update record
            if (pstmt.executeUpdate() != 1)
            {
                throw new Exception("Database error. Failed to update record of race ID " + raceID + ".");
            }
              
            // all done with queries
            rs.close();
            pstmt.close();
        }
        
        // catch any exceptions when connecting to database
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            Log.println_e(e.getMessage());
        }
        
        // close connection
        finally
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        
        return raceID;
    }
}
