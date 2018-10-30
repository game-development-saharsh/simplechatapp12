package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class SkyblueOrBrownRendCard extends RentOnPaymentPropertyActionCard {
	private int numberOfDifferentColoredSetsOnWhichPaymentCanBeAsked = CardConstants.SKYBLUE_OR_BROWN_COLOR_RENT_CARD;
	public SkyblueOrBrownRendCard() {
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
			System.out.println("error while parsing SkyblueOrBrownRendCard object to json.");
			e.printStackTrace();
		}
		return "";
	}


}
