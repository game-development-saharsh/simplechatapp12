package game.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.AppConstants;

public class Game {
	static int instanceCounter = 0;
	private int gameId;
	private List<Player> listOfPlayers;
	private Date gameStartedAt;
	private char gameStatus;
	private String objectType = AppConstants.GAME_OBJECT_TYPE;
	
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing game object to json.");
			e.printStackTrace();
		}
		return "";
	}
	public Game() {
		instanceCounter++;
		gameId=instanceCounter;
		listOfPlayers = new ArrayList<>();
	}
	public Game(Player playerOne, Player playerTwo) {
		instanceCounter++;
		gameId=instanceCounter;
		listOfPlayers = new ArrayList<>();
		listOfPlayers.add(playerOne);
		listOfPlayers.add(playerTwo);
		gameStartedAt = new Date();
		gameStatus = AppConstants.GAME_ACTIVE;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public List<Player> getListOfPlayers() {
		return listOfPlayers;
	}
	public void setListOfPlayers(List<Player> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}
	public Date getGameStartedAt() {
		return gameStartedAt;
	}
	public void setGameStartedAt(Date gameStartedAt) {
		this.gameStartedAt = gameStartedAt;
	}
	
	public char getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(char gameStatus) {
		this.gameStatus = gameStatus;
	}
//	public static void main(String[] args) {
//		Game game = new Game(new Player("a"), new Player("b"));
//		System.out.println(game.playerToJSON());
//	}
	public String getObjectType() {
		return objectType;
	}
}
