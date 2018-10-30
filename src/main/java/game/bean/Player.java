package game.bean;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.AppConstants;

public class Player {
	static int instanceCounter = 0;

	private String userName;
	private int playerId;
	private Date joinedAt;
	private char status;
	private String objectType = AppConstants.PLAYER_OBJECT_TYPE;
	
	public Player() {
		instanceCounter++;
		playerId=instanceCounter;
	}
	public Player(String userName) {
		instanceCounter++;
		playerId=instanceCounter;
		setUserName(userName);
		status = AppConstants.PLAYER_ACTIVE;
		joinedAt = new Date();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public Date getJoinedAt() {
		return joinedAt;
	}
	public void setJoinedAt(Date joinedAt) {
		this.joinedAt = joinedAt;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing player object to json.");
			e.printStackTrace();
		};
		return "";
	}
//	public static void main(String[] args) {
//		Player player = new Player("abc");
//		System.out.println(player.playerToJSON());
//		
//		Calendar date = Calendar.getInstance();
//		date.setTimeInMillis(1540723586310L);
//		
//		System.out.println("date: "+date.get(Calendar.YEAR)+"-"+date.get(Calendar.MONTH)+"-"+date.get(Calendar.DATE)+" "+
//				date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND)+":"+date.get(Calendar.MILLISECOND));
//		
//	}
	public String getObjectType() {
		return objectType;
	}
}
