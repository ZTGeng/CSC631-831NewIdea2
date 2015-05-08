// Test connection to Smurf DB.
// @author: Joseph Fernandez

package dataAccessLayer;

public class TestDBConnection
{
    public static void main(String[] args)
    {
        try
        {
            if (DAO.getInstance() != null)
            {
                System.out.println("Successfully connected to database.");
            }
        }
        catch (Exception e)
        {
            System.err.println("Cannot connect to database.");
        }
    }
}
