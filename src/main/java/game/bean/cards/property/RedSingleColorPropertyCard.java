package game.bean.cards.property;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class RedSingleColorPropertyCard extends SingleColorPropertyCard {
	final int typeOfColours = CardConstants.RED_SINGLE_COLOR_PROPERTY_CARD;
	final int minimumNumberOfCardsForSet;
	final int[] rentForSet;
	
	public RedSingleColorPropertyCard() {
		setValueInMn(3);
		minimumNumberOfCardsForSet =3;
		rentForSet = new int[3];
		rentForSet[0] = 2;
		rentForSet[1] = 3;
		rentForSet[2] = 6;
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
			System.out.println("error while parsing RedSingleColorPropertyCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
