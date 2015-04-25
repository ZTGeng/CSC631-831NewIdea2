//
//package dataAccessLayer;
//
///**
// *
// * @author Keith Hendershot
// */
////Java imports
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.sql.Timestamp;
//import java.util.Scanner;
//
//
//// Other Imports
//
//
//public final class BattleDAO 
//{
//
//  private BattleDAO()
//  {
//  }
//
//
//   public static int initializeBattle(int P1_ID,int P2_ID,float P1_Biomass,float P2_Biomass,int P1_score, int P2_score) throws SQLException
//   {
//       int bat_id = -1;
//       java.util.Date date= new java.util.Date();
//       Timestamp timestamp = new Timestamp(date.getTime());
//       String query = "INSERT INTO `battle` (`p1_id`, `p2_id`, timestarted) VALUES (?, ?, ?)";
//       String query2 = "INSERT INTO `turn_table` (bat_id,turn, p1_biomass, p2_biomass"
//               + ",p1_score,p2_score) VALUES (?,?,?,?,?,?)";
//        Connection connection = null;
//        PreparedStatement pstmt;
//        PreparedStatement pstmt2;
//
//        try {
//            connection = DAO.getDataSource().getConnection();
//            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            pstmt.setInt(1, P1_ID);
//            pstmt.setInt(2, P2_ID);
//            pstmt.setTimestamp(3, timestamp);
//            pstmt.execute();
//            ResultSet rs = pstmt.getGeneratedKeys();
//
//            if (rs.next()) {
//                bat_id = rs.getInt(1);
//            }
//
//            rs.close();
//            pstmt.close();
//            pstmt2 = connection.prepareStatement(query2);
//            pstmt2.setInt(1,bat_id);
//            pstmt2.setInt(2,0);
//            pstmt2.setFloat(2,P1_Biomass);
//            pstmt2.setFloat(3,P2_Biomass);
//            pstmt2.setInt(2,P1_score);
//            pstmt2.setInt(2,P2_score);
//            pstmt2.setFloat(2,P1_Biomass);
//            pstmt2.setFloat(2,P1_Biomass);
//        } 
//        finally 
//        {
//            if (connection != null) 
//            {
//                connection.close();
//            }
//        }
//        
//       return bat_id;
//   }
//   public static void beginEndTurn(int batID,int turn) throws SQLException
//   {
//        String query = "INSERT INTO turn_table (bat_id,turn') VALUES (?,?)";
//        Connection connection = null;
//        PreparedStatement pstmt = null;
//        try {
//            connection = DAO.getDataSource().getConnection();
//            pstmt = connection.prepareStatement(query);
//            pstmt.setInt(1,batID);
//            pstmt.setInt(2, turn);
//            pstmt.execute();
//            pstmt.close();
//        }
//        finally
//        {
//                if (connection != null) 
//                {
//                connection.close();
//                }
//        }
//        
//   }
//    public static void endTurn(int batID,int turn,int PID,float P_Biomass,int pAction,String p_spec_aff_list,
//            int P_score) throws SQLException
//    {
//        String query2 = "SELECT * FROM battle WHERE bat_id = ?";
//
//        Connection connection = null;
//        PreparedStatement pstmt = null;
//        PreparedStatement pstmt2= null;
//        String p_spec_aff = "";
//        String p_bioAff ="";
//        Scanner spec = new Scanner(p_spec_aff_list).useDelimiter("[=]");
//        while(spec.hasNextInt())
//        {
//            if(spec.hasNextLine())
//            {
//                p_spec_aff += spec.nextInt() + ',';
//                p_bioAff += spec.nextInt() + ',';
//            }
//            else
//            {
//                p_spec_aff += spec.nextInt();
//                p_bioAff += spec.nextInt(); 
//            }
//        }
//        try {
//            connection = DAO.getDataSource().getConnection();
//            pstmt2 = connection.prepareStatement(query2);
//            pstmt2.setInt(1,batID);
//            ResultSet rs = pstmt2.executeQuery();
//            pstmt2.close();
//            
//            
//            if(PID == rs.getInt("p1_id"))
//            {
//                String query = "UPDATE `turn_table` SET "
//                + "`p1_biomass`,p1_action, "
//                + "p1_species_affected,`p1_score`,"
//                + "p1_biomass_affected) VALUES ("
//                + "? , ? , ? , ? , ?) WHERE bat_id = ? AND turn = ?";
//                
//                pstmt = connection.prepareStatement(query);
//                pstmt.setFloat(1,P_Biomass);
//                pstmt.setInt(2,pAction);
//                pstmt.setString(3,p_spec_aff);
//                pstmt.setInt(4,P_score);
//                pstmt.setString(5,p_bioAff);
//                pstmt.setInt(6,batID);
//                pstmt.setInt(7,turn);
//            }
//            else if(PID == rs.getInt("p2_id"))
//            {
//                String query = "UPDATE `turn_table` SET "
//                + "`p2_biomass`,p2_action, "
//                + "p2_species_affected,`p2_score`,"
//                + "p2_biomass_affected) VALUES ("
//                + "? , ? , ? , ? , ?) WHERE bat_id = ? AND turn = ?";
//                
//                pstmt = connection.prepareStatement(query);
//                pstmt.setFloat(1,P_Biomass);
//                pstmt.setInt(2,pAction);
//                pstmt.setString(3,p_spec_aff);
//                pstmt.setInt(4,P_score);
//                pstmt.setString(5,p_bioAff);
//                pstmt.setInt(6,batID);
//                pstmt.setInt(7, turn);
//            }
//            pstmt.execute();
//            pstmt.close();
//        } 
//        finally {
//            if (connection != null) {
//                connection.close();
//            }
//        }
//    }
//    public static void endBattle(int bat_id,int winner_id) throws SQLException
//    {
//       java.util.Date date= new java.util.Date();
//       Timestamp timestamp = new Timestamp(date.getTime());
//       String query = "UPDATE `battle` SET `timeended` = ? AND `winner_id` = ? WHERE `bat_id` = ?";
//       PreparedStatement pstmt = null;
//       Connection connection = null;
//
//        try {
//            connection = DAO.getDataSource().getConnection();
//            pstmt = connection.prepareStatement(query);
//            pstmt.setTimestamp(1,timestamp);
//            pstmt.setInt(2,winner_id);
//            pstmt.setInt(3,bat_id);
//            pstmt.execute();
//            pstmt.close();
//        } 
//        finally {
//            if (connection != null) {
//                connection.close();
//            }
//        }
//    }
//    /**
//     * 
//     * @param player_id
//     * @return comma separated records stored in strings 
//     * @throws SQLException 
//     */
//    public static ArrayList<String>  getBattleRecordByPID(int player_id) throws SQLException 
//    {
//        
//        ArrayList<String> BattleRecord = new ArrayList<String>();
//        String query = "SELECT * FROM `battle` WHERE (`p1_id` = ? OR `p_id` = ?) ORDER BY `bat_id` DESC";
//
//            
//        Connection connection = null;
//        PreparedStatement pstmt;
//        try 
//        {
//            connection = DAO.getDataSource().getConnection();
//            pstmt = connection.prepareStatement(query);
//            pstmt.setInt(1, player_id);
//            ResultSet rs = pstmt.executeQuery();
//            while(rs.next())
//            {
//                String battleStats = "";
//                // battle stats from battle table(bat_id,Players,time started and ended, and the winner of the battle
//                battleStats+= rs.getInt("bat_id") + "," + rs.getInt("p1_id") + "," + rs.getInt("p2_id") + "," + rs.getTimestamp("timestarted")
//                    + "," + rs.getTimestamp("timeended") + "," + rs.getInt("winner_id");
//                BattleRecord.add(battleStats);
//                int bat_id = rs.getInt(1);
//
//                while(rs.next())
//                {
//                    BattleRecord.add(readBattle(bat_id));
//
//                }
//
//            }
//            rs.close();
//            pstmt.close();
//        } 
//        finally 
//        {
//            if (connection != null) 
//            {
//                connection.close();
//            }
//        }
//
//        return BattleRecord;
//        
//    }
//
//    // returns a comma and newline seperated string of ints,floats,and Timestamps
//    // battle_id,turn,playerIDs,player's biomass,Player's Action, Player's species Affected,Player's scores
//    // and Player's biomass of affected species
//    private static String readBattle(int bat_id) throws SQLException 
//    {
//        Connection connection = null;
//        String BattleTurn= "";
//    
//        try 
//        {
//            connection = DAO.getDataSource().getConnection();    
//            PreparedStatement pstmt;
//            String query = "SELECT * FROM turn_table WHERE (bat_id = ?) OREDER BY bat_id DESC";
//            pstmt = connection.prepareStatement(query);
//            pstmt.setInt(1,bat_id);
//            ResultSet rs = pstmt.executeQuery();
//
//            while(rs.next())
//            {
//                BattleTurn += rs.getInt("bat_id") + "," + rs.getInt("turn") + "," + rs.getFloat("p1_biomass")
//                    + "," + rs.getFloat("p2_biomass") + "," + rs.getInt("p1_action_id") + "," + rs.getFloat("p2_action_id")
//                    + "," + rs.getInt("p1_species_affected") + "," + rs.getInt("")
//                    + "," + rs.getInt("p1_score") + "," + rs.getInt("p2_score")+"," + rs.getFloat("p1_biomass_affected") +"," 
//                    + rs.getFloat("p2_biomass_affected") + "\n";
//            }
//         }
//         finally
//         {
//            if (connection != null) 
//            {
//                connection.close();
//            }
//         }
//         return BattleTurn;
//        
//    }
//    String readActionID(int actionID) throws SQLException
//    {
//        String actionDescription = "";
//        String query = "SELECT description FROM `battle_action` WHERE (`battle_action_id` = ?)";
//       
//        Connection connection = null;
//        PreparedStatement pstmt;
//        try 
//        {
//            connection = DAO.getDataSource().getConnection();
//            pstmt = connection.prepareStatement(query);
//            pstmt.setInt(1, actionID);
//            ResultSet rs = pstmt.executeQuery();
//            actionDescription = rs.getString("description");
//            pstmt.close();
//            rs.close();
//        }
//        finally
//        {
//            if (connection != null) 
//            {
//                connection.close();
//            }
//         }
//        return actionDescription;
//    }
//  
//    /**
//     * 
//     * @return An arrayList of strings where each string is an item in the shop
//     * @throws SQLException 
//     */
//    ArrayList<String> readBattleShop()throws SQLException
//    {
//        ArrayList<String> battleShop= new ArrayList<String>();
//        String query = "SELECT * FROM `battle_shop`";
//        String item;
//        Connection connection = null;
//        PreparedStatement pstmt;
//        try 
//        {
//            connection = DAO.getDataSource().getConnection();
//            pstmt = connection.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();
//            while(rs.next())
//            {
//                item = "";
//                item+= rs.getInt("item_id")+",";
//                item+= rs.getInt("cost")+",";
//                item+= rs.getString("description")+",";
//                item+= rs.getString("type");
//                battleShop.add(item);
//            }
//        }
//        finally
//        {
//            if (connection != null) 
//            {
//                connection.close();
//            }
//         }
//        return battleShop;
//    }
//}
