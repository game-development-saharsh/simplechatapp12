package game.bean.cards.money;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FiveMnMoneyCard extends MoneyCard {
	final int value;
	public FiveMnMoneyCard() {
		value = 5;
	}
	public int getValueInMn() {
		return value;
	}
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing FiveMnMoneyCard object to json.");
			e.printStackTrace();
		}
		return "";
	}
}
