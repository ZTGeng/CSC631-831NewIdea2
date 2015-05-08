// @author Joseph Fernandez
// Database object for creating RunnerItems models (collectable items/boosts).

package dataAccessLayer;

// Other Imports
import model.RunnerItems;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class RunnerItemsDAO {
    private RunnerItemsDAO() {;}
    
    public static List<RunnerItems> getRunnerItems() throws SQLException
    {
        List<RunnerItems> runnerItemsList = new ArrayList<RunnerItems>(); // list of items/boosts
        
        String query = "SELECT * FROM `runner_items`";
        Connection connection = null; // DB connection
        PreparedStatement pstmt = null; // for SQL execution
        
        try
        {
            connection = DAO.getDataSource().getConnection(); // connect to DB
            pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(); // execute SQL
            
            int ID = 0; // ID check for dummy entries
            RunnerItems ri = null;
            
            while (rs.next())
            {
                if ((ID = rs.getInt("runner_item_id")) > 0) // pull out only records with ID > 0
                {
                    // define item/boost
                    ri = new RunnerItems(ID, rs.getString("runner_item_name"), rs.getInt("health_bonus"), rs.getFloat("speed_bonus"), rs.getFloat("jump_bonus"), rs.getFloat("power_bonus"), rs.getInt("special_bonus"));
                    runnerItemsList.add(ri);
                }
            }
            
            rs.close();
            pstmt.close();
        }
        catch (Exception e)
        {
            System.err.println("Error in retrieving items.");
        }
        finally // close DB connection
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        
        return runnerItemsList;
    }
}
