public class Constants {
	
	// Constants
	public static readonly string CLIENT_VERSION = "1.00";
	public static readonly string REMOTE_HOST = "localhost";
	public static readonly int REMOTE_PORT = 9252;
	
	// Request (1xx) + Response (2xx)
	public static readonly short CMSG_AUTH = 101;
	public static readonly short SMSG_AUTH = 201;
    public static readonly short CMSG_HEARTBEAT = 102;
    public static readonly short SMSG_HEARTBEAT = 202;
	public static readonly short CMSG_PLAYER = 103;
	public static readonly short SMSG_PLAYER = 203;
	public static readonly short CMSG_TEST = 104;
	public static readonly short SMSG_TEST = 204;
	public static readonly short CMSG_LOCATION = 105;
	public static readonly short SMSG_LOCATION = 205;
	public static readonly short CMSG_IN_GAME_HEARTBEAT = 106;
	public static readonly short SMSG_IN_GAME_HEARTBEAT = 206;
	
	// Other
	public static readonly string IMAGE_RESOURCES_PATH = "Images/";
	public static readonly string PREFAB_RESOURCES_PATH = "Prefabs/";
	public static readonly string TEXTURE_RESOURCES_PATH = "Textures/";
	
	// GUI Window IDs
	public enum GUI_ID {
		Login
	};

	public static int USER_ID = -1;
}