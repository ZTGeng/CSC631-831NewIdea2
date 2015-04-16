package core;

// Java Imports
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

// Other Imports
import metadata.Constants;
import metadata.GameRequestTable;
import model.Player;
import networking.request.GameRequest;
import networking.response.GameResponse;
import utility.DataReader;
import utility.Log;

import model.Game;

/**
 * The GameClient class is an extension of the Thread class that represents an
 * individual client. Not only does this class holds the connection between the
 * client and server, it is also in charge of managing the connection to
 * actively receive incoming requests and send outgoing responses. This thread
 * lasts as long as the connection is alive.
 */
public class GameClient implements Runnable {

    // Client Variables
    private String session_id;
    private Socket clientSocket;
    private InputStream inputStream; // For use with incoming requests
    private OutputStream outputStream; // For use with outgoing responses
    private DataInputStream dataInputStream; // Stores incoming requests for use
    private boolean isDone;
    private Queue<GameResponse> updates; // Temporarily store responses for client
    // Other Variables
    private Player player;
    private Player opponent;
    private float x;
    private float y;
    private float distanceTraveled;
    private boolean gameover;

    /**
     * Initialize the GameClient using the client socket and creating both input
     * and output streams.
     * 
     * @param session_id holds the unique identifier of this session
     * @param clientSocket holds reference of the socket being used
     * @throws IOException 
     */
    public GameClient(String session_id, Socket clientSocket) throws IOException {
        this.session_id = session_id;
        this.clientSocket = clientSocket;

        updates = new LinkedList<GameResponse>();

        inputStream = clientSocket.getInputStream();
        outputStream = clientSocket.getOutputStream();
        dataInputStream = new DataInputStream(inputStream);
    }

    /**
     * Holds the main loop that processes incoming requests by first identifying
     * its type, then interpret the following data in each determined request
     * class. Queued up responses created from each request class will be sent
     * after the request is finished processing.
     * 
     * The loop exits whenever the isPlaying flag is set to false. One of these
     * occurrences is triggered by a timeout. A timeout occurs whenever no
     * activity is picked up from the client such as being disconnected.
     */
    @Override
    public void run() {
        long lastActivity = System.currentTimeMillis();
        short requestCode = -1;

        while (!isDone) {
            try {
                // Extract the size of the package from the data stream
                short requestLength = DataReader.readShort(dataInputStream);

                if (requestLength > 0) {
                    lastActivity = System.currentTimeMillis();
                    // Separate the remaining package from the data stream
                    byte[] buffer = new byte[requestLength];
                    inputStream.read(buffer, 0, requestLength);
                    DataInputStream dataInput = new DataInputStream(new ByteArrayInputStream(buffer));
                    // Extract the request code number
                    requestCode = DataReader.readShort(dataInput);
                    // Determine the type of request
                    GameRequest request = GameRequestTable.get(requestCode);
                    // If the request exists, process like following:
                    if (request != null) {
                        request.setGameClient(this);
                        // Pass input stream to the request object
                        request.setDataInputStream(dataInput);
                        // Parse the input stream
                        request.parse();
                        // Interpret the data
                        request.doBusiness();
                        try {
                            // Retrieve any responses created by the request object
                            for (GameResponse response : request.getResponses()) {
                                // Transform the response into bytes and pass it into the output stream
                                send(response);
                            }
                        } catch (IOException ex) {
                            Log.printf_e("Client %s connection lost", session_id);
                            isDone = true;
                        }
                    }
                } else {
                    // If there was no activity for the last moments, exit loop
                    if ((System.currentTimeMillis() - lastActivity) / 1000 >= Constants.TIMEOUT_SECONDS) {
                        isDone = true;
                    }
                }
            } catch (Exception ex) {
                Log.printf_e("Request [%d] Error:", requestCode);
                Log.println_e(ex.getMessage());
                Log.println_e("---");
                ex.printStackTrace();
            }
        }

        if (player != null) {
            removePlayerData();
        }

        // Remove this GameClient from the server
        GameServer.getInstance().deletePlayerThreadOutOfActiveThreads(session_id);

        Log.printf("Client %s has ended", session_id);
    }

    /**
     * Used whenever a player exits from the game. The most recent information
     * stored for the player will be saved into the database and any ties with
     * the server will be removed as well.
     */
    public void removePlayerData() {
        GameServer.getInstance().removeActivePlayer(player.getID());
        Log.printf("User '%s' has logged off.", player.getUsername());
    }

    public String getID() {
        return session_id;
    }

    public void end() {
        isDone = true;
    }

    public int getUserID() {
        return player != null ? player.getID() : -1;
    }

    public Player getPlayer() {
        return player;
    }

    public Player setPlayer(Player player) {
        return this.player = player;
    }
    
    public Player getOpponent() {
        return opponent;
    }

    public Player setOpponent(Player opponent) {
        return this.opponent = opponent;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
    public float setX(float x) {
        return this.x = x;
    }

    public float setY(float y) {
        return this.y = y;
    }
    
    public float getDistanceTraveled() {
        return distanceTraveled;
    }
    
    public float setDistanceTraveled(float distanceTraveled) {
        return this.distanceTraveled = distanceTraveled;
    }
    
    public boolean getGameove() {
        return gameover;
    }
    
    public boolean setGameover(boolean gameover) {
        return this.gameover = gameover;
    }
    
    public boolean addResponseForUpdate(GameResponse response) {
        return updates.add(response);
    }

    public void send(GameResponse response) throws IOException {
        outputStream.write(response.constructResponseInBytes());
    }

    /**
     * Get all pending responses for this client.
     * 
     * @return all pending responses
     */
    public Queue<GameResponse> getUpdates() {
        Queue<GameResponse> responseList = null;

        synchronized (this) {
            responseList = updates;
            updates = new LinkedList<GameResponse>();
        }

        return responseList;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    /**
     * Remove all responses for this client.
     */
    public void clearUpdateBuffer() {
        updates.clear();
    }

    public String getIP() {
        return clientSocket.getInetAddress().getHostAddress();
    }
    
    public void newSession() {
        session_id = GameServer.createUniqueID();
        updates.clear();

        player = null;
    }

    @Override
    public String toString() {
        String str = "";

        str += "-----" + "\n";
        str += getClass().getName() + "\n";
        str += "\n";

        for (Field field : getClass().getDeclaredFields()) {
            try {
                str += field.getName() + " - " + field.get(this) + "\n";
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        str += "-----";

        return str;
    }
}
