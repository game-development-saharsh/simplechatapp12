package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class SlyDealActionCard extends StealActionCard {
	int countOfCardsThatCanBeSnatched = CardConstants.STEAL_A_SINGLE_CARD_ACTION_CARD;
	public SlyDealActionCard() {
		// TODO Auto-generated constructor stub
		setValueInMn(3);
	}
	@Override
	public int getCountOfCardsThatCanBeSnatched() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing SlyDealActionCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
