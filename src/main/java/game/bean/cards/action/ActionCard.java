package game.bean.cards.action;

import constants.CardConstants;
import game.bean.cards.Card;

public abstract class ActionCard extends Card {
	final int typeOfCard = CardConstants.CARD_TYPE_ACTION;

	@Override
	public int getTypeOfCard() {
		return typeOfCard;
	}
	
	public abstract int getTypeOfAction();

}
