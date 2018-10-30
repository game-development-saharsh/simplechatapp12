package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class AnyColorRentActionCard extends RentOnPaymentPropertyActionCard {
	private int numberOfDifferentColoredSetsOnWhichPaymentCanBeAsked = CardConstants.ANY_COLOR_RENT_CARD;
	public AnyColorRentActionCard() {
		setValueInMn(3);
	}
	@Override
	public int getNumberOfDifferentColoredSetsOnWhichPaymentCanBeAsked() {
		// TODO Auto-generated method stub
		return numberOfDifferentColoredSetsOnWhichPaymentCanBeAsked;
	}
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing AnyColorRentActionCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
