/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import core.GameServer;
import java.io.IOException;
import networking.response.RRResponsePosition;
import race.RaceManager;
import utility.DataReader;

/**
 *
 * @author markfavis
 */
public class RRRequestPosition extends GameRequest {
    
//    private int x, y;
    private float x, y;
    private int p_id;
    private RRResponsePosition rrResponsePosition;
    
    @Override
    public void parse() throws IOException {

//        x = DataReader.readInt(dataInput);
//        y = DataReader.readInt(dataInput);

        x = Float.parseFloat(DataReader.readString(dataInput));
        y = Float.parseFloat(DataReader.readString(dataInput));
    }

    @Override
    public void doBusiness() throws Exception {

        System.out.println("X:  " +  x + "Y :  " + y);

        rrResponsePosition = new RRResponsePosition();
        rrResponsePosition.setX(x);
        rrResponsePosition.setY(y);
        
//        RaceManager.getInstance();
//        client.getPlayer().getID();
        
        //Debugging
//        Log.println(Integer.toString(RaceManager.getInstance().getRaceByPlayerID(client.getPlayer().getID()).getID()));        
//        Log.println(Integer.toString(RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID()).getOpponent(client.getPlayer()).getID()));
   
        //The playerID of the oppenet of the player who sent the request
        p_id = RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID())
                .getOpponent(client.getPlayer()).getID();
                
        //NetworkManager.addResponseForUser(p_id, responsekeyboard);
        
        GameServer.getInstance().getThreadByPlayerID(p_id).send(rrResponsePosition);
    }
    
}
