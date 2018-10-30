package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class RedOrYellowRentCard extends RentOnPaymentPropertyActionCard {
	private int numberOfDifferentColoredSetsOnWhichPaymentCanBeAsked = CardConstants.RED_OR_YELLOW_COLOR_RENT_CARD;
	public RedOrYellowRentCard() {
		setValueInMn(1);
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
			System.out.println("error while parsing RedOrYellowRentCard object to json.");
			e.printStackTrace();
		}
		return "";
	}

}
