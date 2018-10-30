package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.AppConstants;
import game.bean.Game;
import game.bean.Message;
import game.bean.Player;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	List<Player> playerPool = new ArrayList<>();
	List<Game> gamePool = new ArrayList<>();
	boolean firstRequest = true;

	public ActionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (firstRequest) {
			// perform all actions
			System.out.println("first request.");
			firstRequest = false;
		}
		String module = request.getRequestURI();
		String queryString = request.getQueryString();
		System.out.println("here module: " + module + ", queryString: " + queryString);
		if (module.equalsIgnoreCase(AppConstants.LOGIN_MODULE)) {
			String userName = request.getParameter(AppConstants.PARAM_USER_NAME);
			if (validateUserName(userName)) {
				response.getWriter()
						.append(new Message(AppConstants.MESSAGE_TYPE_ERROR, AppConstants.INVALID_USERNAME).toJSON());
			} else {
				int playerId = addPlayerToThePoolAndRetrievePlayerId(userName);
				Message messageToWrite = new Message(AppConstants.MESSAGE_TYPE_INFO, AppConstants.FINDING_MATCH);
				messageToWrite.getAdditionalStringMessage().put(AppConstants.PARAM_PLAYER_ID,
						AppConstants.EMPTY_STRING + playerId);
				response.getWriter().append(messageToWrite.toJSON());
			}
		} else if (module.equalsIgnoreCase(AppConstants.FIND_OPPONENT_MODULE)) {
			// if player is present in pool the continue
			// else stop searching
			String playerIdString = request.getParameter(AppConstants.PARAM_PLAYER_ID);
			int playerId = Integer.parseInt(playerIdString);
			if (playerPool != null && playerPool.size() < 2) {
				// check if player exists in pool
				if (checkPlayerIdPresentInIdlePlayerPool(playerId)) {
					writeContinueMessage(response);
				} else {
					// check playerId exists in game pool
					int indexOfPlayerId = fetchIndexOfPlayerIdInGamePool(playerId);
					if (indexOfPlayerId == -1) {
						writeContinueMessage(response);
					}
					else {
						Game joinedGame = gamePool.get(indexOfPlayerId);
						if(joinedGame != null) {
							response.getWriter().append(joinedGame.toJSON());
						}
						else {
							writeContinueMessage(response);
						}
					}
				}
			} else {
				if(checkPlayerIdPresentInIdlePlayerPool(playerId)) {
					Game newGame = findPlayerIdInPoolAndStartNewGame(playerId);
					if(newGame != null) {
						response.getWriter().append(newGame.toJSON());
					}
					else {
						writeContinueMessage(response);
					}
					
				} else {
					int indexOfPlayerId = fetchIndexOfPlayerIdInGamePool(playerId);
					if (indexOfPlayerId == -1) {
						writeContinueMessage(response);
					}
					else {
						Game joinedGame = gamePool.get(indexOfPlayerId);
						if(joinedGame != null) {
							response.getWriter().append(joinedGame.toJSON());
						}
						else {
							writeContinueMessage(response);
						}
					}
				}
				
			}
		} else if (module.equalsIgnoreCase("")) {
			response.getWriter().append("Served at: ").append("module: " + module + ", queryString: " + queryString);
		}
	}

	// find opponent module -- Start
	private void writeContinueMessage(HttpServletResponse response) throws IOException {
		Message messageToWrite = new Message(AppConstants.MESSAGE_TYPE_INFO, AppConstants.CONTINUE_MATCH);
		response.getWriter().append(messageToWrite.toJSON());
	}
	private boolean checkPlayerIdPresentInIdlePlayerPool(int playerId) {
		boolean playerPresent = false;
		for (int i = 0; i < playerPool.size(); i++) {
			if (playerId == playerPool.get(i).getPlayerId()) {
				playerPresent = true;
				break;
			}
		}
		return playerPresent;
	}
	private int fetchIndexOfPlayerIdInGamePool(int playerId) {
		
		int playerIdIndex = -1;
		for (int i = 0; i < gamePool.size(); i++) {
			//logic
			Game game= gamePool.get(i);
			if (playerId == game.getListOfPlayers().get(0).getPlayerId() || playerId == game.getListOfPlayers().get(1).getPlayerId()) {
				playerIdIndex = i;
				break;
			}
		}
		return playerIdIndex;
	}
	private synchronized Game findPlayerIdInPoolAndStartNewGame(int playerId) {
		int indexOfPlayerIdInPool = -1;
		// find index of concerned player in pool
		for (int i = 0; i < playerPool.size(); i++) {
			if (playerId == playerPool.get(i).getPlayerId()) {
				indexOfPlayerIdInPool = i;
				break;
			}
		}
		// if index is not 0 then match with 0th player
		// else if index is 0 the match with next player
		Player playerOne = null;
		Player playerTwo = null;
		if(indexOfPlayerIdInPool == -1) {
			return null;
		}
		if (indexOfPlayerIdInPool == 0) {
			playerOne = playerPool.get(0);
			playerTwo = playerPool.get(1);
		} else {
			playerOne = playerPool.get(indexOfPlayerIdInPool);
			playerTwo = playerPool.get(0);
		}
		// add both players in game pool
		Game gameCreated = new Game(playerOne, playerTwo);
		gamePool.add(gameCreated);
		// remove object matching indices of both players from player pool
		playerPool.remove(playerOne);
		playerPool.remove(playerTwo);
		return gameCreated;
	}
	// find opponent module -- end

	// login module --Start
	private boolean validateUserName(String userName) {
		if (userName == null || userName.equals("")) {
			return false;
		}
		Pattern pattern = Pattern.compile("[^a-z0-9A-Z ]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(userName);
		return matcher.find();
	}
	private int addPlayerToThePoolAndRetrievePlayerId(String userName) {
		Player playerToAdd = new Player(userName);
		playerPool.add(playerToAdd);
		return playerToAdd.getPlayerId();
	}
	// login module --end

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
