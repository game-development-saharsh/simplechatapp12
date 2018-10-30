package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class PassGoActionCard extends ActionCard {
	private int typeOfAction = CardConstants.DRAW_ACTION_CARD;

	public PassGoActionCard() {
		setValueInMn(1);
	}
	@Override
	public int getTypeOfAction() {
		return typeOfAction;
	}
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing PassGoActionCard object to json.");
			e.printStackTrace();
		}
		return "";
	}

}
