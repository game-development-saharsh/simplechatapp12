package game.bean.cards.property;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class GreenSingleColorPropertyCard extends SingleColorPropertyCard {
	final int typeOfColours = CardConstants.GREEN_SINGLE_COLOR_PROPERTY_CARD;
	final int minimumNumberOfCardsForSet;
	final int[] rentForSet;
	
	public GreenSingleColorPropertyCard() {
		setValueInMn(4);
		minimumNumberOfCardsForSet =3;
		rentForSet = new int[3];
		rentForSet[0] = 2;
		rentForSet[1] = 4;
		rentForSet[2] = 7;
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
			System.out.println("error while parsing GreenSingleColorPropertyCard object to json.");
			e.printStackTrace();
		}
		return "";
	}

}
