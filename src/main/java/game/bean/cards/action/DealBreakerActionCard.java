package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class DealBreakerActionCard extends StealActionCard {
	int countOfCardsThatCanBeSnatched = CardConstants.STEAL_A_SET_ACTION_CARD;
	public DealBreakerActionCard() {
		// TODO Auto-generated constructor stub
		setValueInMn(5);
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
			System.out.println("error while parsing DealBreakerActionCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
