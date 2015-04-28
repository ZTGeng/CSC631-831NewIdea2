/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import core.GameServer;
import java.io.IOException;
import networking.response.ResponseKeyboard;
import utility.DataReader;
import race.Race;
import race.RaceManager;
import race.RacePlayer;
import core.NetworkManager;
import utility.Log;

/**
 *
 * @author Sbc-ComEx
 */
public class RequestKeyboard extends  GameRequest{
    
    private int keytype,key;
    private int p_id;
    private  ResponseKeyboard responsekeyboard;
    
    public RequestKeyboard() {
//        responses.add(responsekeyboard = new ResponseKeyboard());
    }
       
    public void parse() throws IOException {
        keytype = DataReader.readInt(dataInput);
        key = DataReader.readInt(dataInput);
    }
    
    public void doBusiness() throws Exception {
        
      //  System.out.println("key type:  " +  keytype + "key :  " + key);
        
        responsekeyboard = new ResponseKeyboard();
        responsekeyboard.setKeytype(keytype);
        responsekeyboard.setKey(key);
        
        RaceManager.getInstance();
        client.getPlayer().getID();
        
        //Debugging
//        Log.println(Integer.toString(RaceManager.getInstance().getRaceByPlayerID(client.getPlayer().getID()).getID()));        
//        Log.println(Integer.toString(RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID()).getOpponent(client.getPlayer()).getID()));
   
        //The playerID of the oppenet of the player who sent the request
        p_id = RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID())
                .getOpponent(client.getPlayer()).getID();
                
        //NetworkManager.addResponseForUser(p_id, responsekeyboard);
        
        GameServer.getInstance().getThreadByPlayerID(p_id).send(responsekeyboard);
    }
    
    
    
    
}
