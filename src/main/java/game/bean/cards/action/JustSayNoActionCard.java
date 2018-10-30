package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class JustSayNoActionCard extends ActionCard {
	private int typeOfAction = CardConstants.CEASE_ACTION_CARD;
	public JustSayNoActionCard() {
		setValueInMn(4);
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
			System.out.println("error while parsing JustSayNoActionCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
