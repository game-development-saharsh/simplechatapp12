package constants;

public class AppConstants {
	//file path
	final static public String PATH_OF_ONLY_CARD_COUNT_DOT_CSV = ".\\src\\main\\resources\\OnlyCardCount.csv";
	
	// module names
	final static public String LOGIN_MODULE = "/login";
    final static public String FIND_OPPONENT_MODULE = "/findOpponent";
	//parameter names
	final static public String PARAM_USER_NAME = "userName";
	final static public String PARAM_PLAYER_ID = "playerId";
	
	// player constants
	final static public char PLAYER_ACTIVE = 'A';
	final static public char PLAYER_INACTIVE = 'I';

	// player constants
	final static public char GAME_ACTIVE = 'A';
	final static public char GAME_END = 'E';
	
	//message type
	final static public String MESSAGE_TYPE_INFO = "info";
	final static public String MESSAGE_TYPE_ERROR = "error";
	
	//info messages
	final static public String FINDING_MATCH = "findingMatch";
	final static public String CONTINUE_MATCH = "ContinueMatch";
	//error message
	final static public String INVALID_USERNAME = "invalidUserName";
	
	//object types
	final static public String GAME_OBJECT_TYPE = "Game";
	final static public String MESSAGE_OBJECT_TYPE = "Message";
	final static public String PLAYER_OBJECT_TYPE = "Player";
	
	//utility constants
	final static public String EMPTY_STRING = "";
}
