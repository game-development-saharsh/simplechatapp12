package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class BlueOrGreenRentCard extends RentOnPaymentPropertyActionCard {
	private int numberOfDifferentColoredSetsOnWhichPaymentCanBeAsked = CardConstants.BLUE_OR_GREEN_COLOR_RENT_CARD;
	public BlueOrGreenRentCard() {
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
			System.out.println("error while parsing BlueOrGreenRentCard object to json.");
			e.printStackTrace();
		}
		return "";
	}

}
