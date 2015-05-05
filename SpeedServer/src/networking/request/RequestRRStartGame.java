/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.request;

import core.GameServer;
import java.io.IOException;
import networking.response.ResponseRRStartGame;
<<<<<<< HEAD
import race.Race;
import race.RaceManager;
=======
import race.RaceManager;
import utility.DataReader;
>>>>>>> 0aec7a549378ca3605a89244ecf630c4a87a914a

/**
 *
 * @author markfavis
 */
public class RequestRRStartGame extends GameRequest {

    private int p_id1;
    private int p_id2;

    private ResponseRRStartGame responseRRStartGame;

    @Override
    public void parse() throws IOException {
        p_id1 = DataReader.readInt(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        RaceManager.manager.getRaceByPlayerID(client.getUserID()).startRace(client.getUserID());
        // WAIT FOR OPPONENT TO SEND THE SAME PACKET

        p_id2 = RaceManager.manager.getRaceByPlayerID(client.getPlayer().getID())
                .getOpponent(client.getPlayer()).getID();

        if (RaceManager.manager.readyToRace.containsKey(p_id1)) {
            if (RaceManager.manager.readyToRace.containsKey(p_id2)) {
                // send responses to both players
                GameServer.getInstance().getThreadByPlayerID(p_id1).send(responseRRStartGame);
                GameServer.getInstance().getThreadByPlayerID(p_id2).send(responseRRStartGame);

                // remove players off the stack
                RaceManager.manager.readyToRace.remove(p_id1);
                RaceManager.manager.readyToRace.remove(p_id2);
            } else {
                RaceManager.manager.readyToRace.put(p_id1, p_id1);
            }
        }
    }
}
