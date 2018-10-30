package game.bean.cards.property;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class GreenAndBlueDualColorPropertyCard extends DualColorPropertyCard {
	final int typeOfColours = CardConstants.GREEN_BLUE_DUAL_COLOR_PROPERTY_CARD;

	@Override
	public int getTypeOfColor() {
		return typeOfCard;
	}
	public GreenAndBlueDualColorPropertyCard() {
		setValueInMn(4);
	}
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing GreenAndBlueDualColorPropertyCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
