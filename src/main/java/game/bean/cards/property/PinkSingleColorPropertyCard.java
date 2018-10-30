package game.bean.cards.property;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class PinkSingleColorPropertyCard extends SingleColorPropertyCard {
	final int typeOfColours = CardConstants.PINK_SINGLE_COLOR_PROPERTY_CARD;
	final int minimumNumberOfCardsForSet;
	final int[] rentForSet;
	
	public PinkSingleColorPropertyCard() {
		setValueInMn(2);
		minimumNumberOfCardsForSet =3;
		rentForSet = new int[3];
		rentForSet[0] = 1;
		rentForSet[1] = 2;
		rentForSet[2] = 4;
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
			System.out.println("error while parsing PinkSingleColorPropertyCard object to json.");
			e.printStackTrace();
		}
		return "";
	}

}
