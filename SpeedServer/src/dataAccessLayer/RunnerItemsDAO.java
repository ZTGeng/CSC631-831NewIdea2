// @author Joseph Fernandez
// Database object for creating RunnerItems models (collectable items/boosts).

package dataAccessLayer;

// Java imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;

// Other imports
import model.RunnerItems;
import utility.Log;

public final class RunnerItemsDAO {
    private RunnerItemsDAO() {;}
    
    // Load all runner items from DB.
    // @returns: hashmap of all runner items (item ID mapped to items)
    // @throws: SQLException
    public static Map<Integer, RunnerItems> getRunnerItems() throws SQLException
    {
        Map<Integer, RunnerItems> runnerItemsMap = new HashMap<Integer, RunnerItems>(); // map of items/boosts
        
        String query = "SELECT * FROM `runner_items`";
        Connection connection = null; // DB connection
        PreparedStatement pstmt; // for SQL execution
        
        try
        {
            connection = DAO.getDataSource().getConnection(); // connect to DB
            pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(); // execute SQL
            
            int ID; // ID check for dummy entries
            RunnerItems ri;
            
            while (rs.next())
            {
                if ((ID = rs.getInt("runner_item_id")) > 0) // pull out only records with ID > 0
                {
                    // define item/boost
                    ri = new RunnerItems(ID, rs.getString("runner_item_name"), rs.getInt("health_bonus"), rs.getFloat("speed_bonus"), rs.getFloat("jump_bonus"), rs.getFloat("power_bonus"), rs.getInt("special_bonus"));
                    runnerItemsMap.put(ID, ri);
                }
            }
            
            rs.close();
            pstmt.close();
        }
        catch (Exception e)
        {
            System.err.println("Database error. Failed to load items.");
            Log.println_e("Database error. Failed to load items.");
        }
        finally // close DB connection
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        
        return runnerItemsMap;
    }
}
