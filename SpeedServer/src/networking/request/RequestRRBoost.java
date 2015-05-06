/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import core.GameServer;
import java.io.IOException;
import networking.response.ResponseRRBoost;
import race.RaceManager;
import utility.DataReader;

/**
 *
 * @author markfavis
 */
public class RequestRRBoost extends GameRequest {

    private int boostItemID;
    private int p_id;
    private ResponseRRBoost responseRRBoost;

    @Override
    public void parse() throws IOException {
        this.boostItemID = DataReader.readInt(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        responseRRBoost = new ResponseRRBoost();
        responseRRBoost.setBoostItemID(boostItemID);

        // inform opponent
        p_id = RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID())
                .getOpponent(client.getPlayer()).getID();

        //NetworkManager.addResponseForUser(p_id, responsekeyboard);
        GameServer.getInstance().getThreadByPlayerID(p_id).send(responseRRBoost);
    }

}
