package networking.request;

// Java Imports
import java.io.IOException;

// Other Imports
import core.GameClient;
import core.GameServer;
import metadata.Constants;
import model.Player;
import networking.response.ResponseLogin;
import utility.DataReader;
import utility.Log;

/**
 * The RequestLogin class authenticates the user information to log in. Other
 * tasks as part of the login process lies here as well.
 * 
 * The RequestLocation class updates the current location of the user.
 */
public class RequestLocation extends GameRequest {

    // Data
    private float x;
    private float y;
    private String version;

    // Responses
//    private ResponseLocatio responseLocation;

    public RequestLocation() {
//        responses.add(responseLocation = new ResponseLocatio());
    }

    @Override
    public void parse() throws IOException {
        x = DataReader.readFloat(dataInput);
        y = DataReader.readFloat(dataInput);
    }
    
        @Override
    public void doBusiness() throws Exception {
        
    }
}