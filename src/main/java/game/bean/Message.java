package game.bean;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.AppConstants;

public class Message {
	private String messageType;
	private String messageText;
	private Map<String, String> additionalStringMessage = new HashMap<>();
	private String objectType = AppConstants.MESSAGE_OBJECT_TYPE;
	
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing message object to json.");
			e.printStackTrace();
		}
		return AppConstants.EMPTY_STRING;
	}
	
	public Message(String type, String message) {
		setMessageType(type);
		setMessage(message);
	}

	public String getMessage() {
		return messageText;
	}

	public void setMessage(String message) {
		this.messageText = message;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getObjectType() {
		return objectType;
	}

	public Map<String, String> getAdditionalStringMessage() {
		return additionalStringMessage;
	}

	public void setAdditionalStringMessage(Map<String, String> additionalStringMessage) {
		this.additionalStringMessage = additionalStringMessage;
	}
	
}
