package game.bean.cards.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.CardConstants;

public class DebtCollectorActionCard extends PaymentActionCard {

	private int typeOfMakePayment = CardConstants.CASH_PAYMENT_ACTION_CARD;
	public DebtCollectorActionCard() {
		setValueInMn(3);
	}
	@Override
	public int getTypeOfMakePayment() {
		// TODO Auto-generated method stub
		return typeOfMakePayment;
	}
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while parsing DebtCollectorActionCard object to json.");
			e.printStackTrace();
		}
		return "";
	}

}
