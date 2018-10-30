package game.bean.cards.property;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class GreySingleColorPropertyCard extends SingleColorPropertyCard {
	final int typeOfColours = CardConstants.GREY_SINGLE_COLOR_PROPERTY_CARD;
	final int minimumNumberOfCardsForSet;
	final int[] rentForSet;
	
	public GreySingleColorPropertyCard() {
		setValueInMn(2);
		minimumNumberOfCardsForSet =2;
		rentForSet = new int[2];
		rentForSet[0] = 1;
		rentForSet[1] = 2;
	}
	
	@Override
	public int getTypeOfColor() {
		return typeOfColours;
	}
	
	@Override
	public int getMinimumNumberOfCardsForSet() {
		// TODO Auto-generated method stub
		return minimumNumberOfCardsForSet;
	}

	@Override
	public int[] getRentForSet() {
		// TODO Auto-generated method stub
		return rentForSet;
	}
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing GreySingleColorPropertyCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
