package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class ForcedDealActionCard extends ActionCard {
	private int typeOfAction = CardConstants.SWAP_A_SINGLE_CARD_ACTION_CARD;
	public ForcedDealActionCard() {
		setValueInMn(3);
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
			System.out.println("error while parsing ForcedDealActionCard object to json.");
			e.printStackTrace();
		}
		return "";
	}

}
