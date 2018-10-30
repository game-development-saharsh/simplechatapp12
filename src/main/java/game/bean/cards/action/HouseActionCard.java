package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HouseActionCard extends ValueAdditionOnPropertyActionCard {
	public HouseActionCard() {
		setValueInMn(3);
	}
	
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing HouseActionCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
