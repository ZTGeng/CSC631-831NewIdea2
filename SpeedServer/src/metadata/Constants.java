package metadata;

/**
 * The Constants class stores important variables as constants for later use.
 */
public class Constants {

    // Request (1xx) + Response (2xx)
    public final static short CMSG_AUTH = 101;
    public final static short SMSG_AUTH = 201;
    public final static short CMSG_HEARTBEAT = 102;
    public final static short SMSG_HEARTBEAT = 202;

    // Organism Type
    public static final short ORGANISM_TYPE_ANIMAL = 0;
    public static final short ORGANISM_TYPE_PLANT = 1;
    // Parameter Type
    public static final short PARAMETER_K = 0;	//Plants Carrying capacity >0
    public static final short PARAMETER_R = 1;	//Plants Growth rate 0-1
    public static final short PARAMETER_X = 2;	//Plants Metabolic rate 0-1
    public static final short PARAMETER_X_A = 3;	//Animals
    public static final short PARAMETER_E = 4; //Animals assimilationEfficiency
    public static final short PARAMETER_D = 5; //Animals predatorInterference
    public static final short PARAMETER_Q = 6; //Animals functionalResponseControl
    public static final short PARAMETER_A = 7; //Animals relativeHalfSaturationDensity
    // Other
    public static final float BIOMASS_SCALE = 1000;
    public static final String CLIENT_VERSION = "1.00";
    public static final int TIMEOUT_SECONDS = 90;
    public static final String CSV_SAVE_PATH = "src/log/";
}
