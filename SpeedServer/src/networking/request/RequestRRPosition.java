/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import core.GameServer;
import java.io.IOException;
import networking.response.ResponseRRPosition;
import race.RaceManager;
import utility.DataReader;

/**
 *
 * @author markfavis
 */
public class RequestRRPosition extends GameRequest {
    
//    private int x, y;
    private float x, y;
    private int p_id;
    private ResponseRRPosition responseRRPosition;
    
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
<<<<<<< HEAD:SpeedServer/src/networking/request/RRRequestPosition.java

        rrResponsePosition = new RRResponsePosition();
        rrResponsePosition.setX(x);
        rrResponsePosition.setY(y);
=======
        
        responseRRPosition = new ResponseRRPosition();
        responseRRPosition.setX(x);
        responseRRPosition.setY(y);
>>>>>>> start:SpeedServer/src/networking/request/RequestRRPosition.java
        
//        RaceManager.getInstance();
//        client.getPlayer().getID();
        
        //Debugging
//        Log.println(Integer.toString(RaceManager.getInstance().getRaceByPlayerID(client.getPlayer().getID()).getID()));        
//        Log.println(Integer.toString(RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID()).getOpponent(client.getPlayer()).getID()));
   
        //The playerID of the oppenet of the player who sent the request
        p_id = RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID())
                .getOpponent(client.getPlayer()).getID();
                
        //NetworkManager.addResponseForUser(p_id, responsekeyboard);
        
        GameServer.getInstance().getThreadByPlayerID(p_id).send(responseRRPosition);
    }
    
}
