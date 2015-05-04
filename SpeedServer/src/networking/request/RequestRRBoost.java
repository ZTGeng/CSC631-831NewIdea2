/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import java.io.IOException;
import networking.response.ResponseRRBoost;
import utility.DataReader;

/**
 *
 * @author markfavis
 */
public class RequestRRBoost extends GameRequest {

    private int boostItemID;
    private ResponseRRBoost responseRRBoost;

    @Override
    public void parse() throws IOException {
        this.boostItemID = DataReader.readInt(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        responseRRBoost = new ResponseRRBoost();
        
        // inform other opponent
    }

}
