package networking.request;

// Java Imports
import java.io.IOException;

// Other Imports
import networking.response.GameResponse;
import networking.response.ResponseHeartbeat;
import utility.DataReader;
import utility.Log;

/**
 * The RequestHeartbeat class is mainly used to release all pending responses
 * the client. Also used to keep the connection alive.
 */
public class RequestHeartbeat extends GameRequest {

    private float playerX;
    private float playerY;
    private float playerDistanceTraveled;
    private boolean gameover;
    private ResponseHeartbeat responseInGameHeartbeat;

    public RequestHeartbeat() {
        responses.add(responseInGameHeartbeat = new ResponseHeartbeat());
    }

    @Override
    public void parse() throws IOException {
        playerX = Float.parseFloat(DataReader.readString(dataInput).trim());
        playerY = Float.parseFloat(DataReader.readString(dataInput).trim());
        playerDistanceTraveled = Float.parseFloat(DataReader.readString(dataInput).trim());
        gameover = DataReader.readBoolean(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        client.setX(playerX);
        client.setY(playerX);
        responseInGameHeartbeat.setOpponentX(client.getOpponent().getClient().getX());
        responseInGameHeartbeat.setOpponentY(client.getOpponent().getClient().getY());
        responseInGameHeartbeat.setGameover(client.getOpponent().getClient().getGameove());
        responseInGameHeartbeat.setOpponentDistanceTraveled(client.getOpponent().getClient().getDistanceTraveled());
        
        responseInGameHeartbeat.setStatus((short) 0);
    }
}

