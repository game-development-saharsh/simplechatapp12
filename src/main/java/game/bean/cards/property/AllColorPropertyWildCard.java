package game.bean.cards.property;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class AllColorPropertyWildCard extends PropertyCard {
	int numberOfColors = CardConstants.ALL_COLOR_PROPERTY_CARD;

	@Override
	public int getNumberOfColours() {
		return numberOfColors;
	}
	
	public AllColorPropertyWildCard() {
		setValueInMn(0);
	}
	
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing AllColorPropertyWildCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
