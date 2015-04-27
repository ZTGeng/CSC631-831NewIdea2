/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import java.io.IOException;
import networking.response.ResponseKeyboard;
import utility.DataReader;

/**
 *
 * @author Sbc-ComEx
 */
public class RequestKeyboard extends  GameRequest{
    
    private int keytype,key;
    private  ResponseKeyboard responsekeyboard;
    public RequestKeyboard() {
        responses.add(responsekeyboard = new ResponseKeyboard());
    }
       
    public void parse() throws IOException {
        keytype = DataReader.readInt(dataInput);
        key = DataReader.readInt(dataInput);
    }
    
    public void doBusiness() throws Exception {
        
        System.out.println("key type:  " +  keytype + "key :  " + key);
        responsekeyboard.setKeytype(keytype);
        responsekeyboard.setKey(key);
   
        
    
    }
    
    
    
    
}
