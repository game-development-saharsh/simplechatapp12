package constants;


public class CardConstants {
	// constants
	final static public String CARD_OBJECT_TYPE = "card";

	// source and destination
	final static public int DRAW_PILE = 1;
	final static public int PLAY_PILE = 2;
	final static public int CARD_IN_OWN_HAND = 3;
	final static public int CARD_IN_SETS = 4;
	final static public int CARD_IN_OPPONENT_HAND = 5;
	final static public int CARD_IN_OPPONENT_BANK = 6;
	final static public int CARD_IN_OPPONENT_SETS = 7;

	// type of card
	final static public int CARD_TYPE_PROPERTY = 1;
	final static public int CARD_TYPE_ACTION = 2;
	final static public int CARD_TYPE_MONEY = 3;

	// number of color
	final static public int SINGLE_COLOR_PROPERTY_CARD = 1;
	final static public int DUAL_COLOR_PROPERTY_CARD = 2;
	final static public int ALL_COLOR_PROPERTY_CARD = 10;
	
	final static public int PINK_OR_ORANGE_COLOR_RENT_CARD = 1;
	final static public int BLUE_OR_GREEN_COLOR_RENT_CARD = 2;
	final static public int RED_OR_YELLOW_COLOR_RENT_CARD = 3;
	final static public int GREY_OR_BLACK_COLOR_RENT_CARD = 4;
	final static public int SKYBLUE_OR_BROWN_COLOR_RENT_CARD = 5;
	final static public int ANY_COLOR_RENT_CARD = 6;
	
	// type of color
	final static public int GREEN_SINGLE_COLOR_PROPERTY_CARD = 1;
	final static public int BLACK_SINGLE_COLOR_PROPERTY_CARD = 2;
	final static public int SKYBLUE_SINGLE_COLOR_PROPERTY_CARD = 3;
	final static public int PINK_SINGLE_COLOR_PROPERTY_CARD = 4;
	final static public int GREY_SINGLE_COLOR_PROPERTY_CARD = 5;
	final static public int ORANGE_SINGLE_COLOR_PROPERTY_CARD = 6;
	final static public int YELLOW_SINGLE_COLOR_PROPERTY_CARD = 7;
	final static public int RED_SINGLE_COLOR_PROPERTY_CARD = 8;
	final static public int BLUE_SINGLE_COLOR_PROPERTY_CARD = 9;
	final static public int BROWN_SINGLE_COLOR_PROPERTY_CARD = 10;
	
	final static public int GREEN_BLUE_DUAL_COLOR_PROPERTY_CARD = 11;
	final static public int GREEN_BLACK_DUAL_COLOR_PROPERTY_CARD = 12;
	final static public int GREY_BLACK_DUAL_COLOR_PROPERTY_CARD = 13;
	final static public int SKYBLUE_BLACK_DUAL_COLOR_PROPERTY_CARD = 14;
	final static public int SKYBLUE_BROWN_DUAL_COLOR_PROPERTY_CARD = 15;
	final static public int PINK_ORANGE_DUAL_COLOR_PROPERTY_CARD = 16;
	final static public int RED_YELLOW_DUAL_COLOR_PROPERTY_CARD = 17;
	
	final static public int All_COLOR_PROPERTY_WILD_CARD = 20;
	
	//type of action
	final static public int DRAW_ACTION_CARD = 1;
	final static public int VALUE_ADDITION_ACTION_CARD = 2;
	final static public int ADDITIONAL_VALUE_ADDITION_ACTION_CARD = 3;
	final static public int MAKE_PAY_ACTION_CARD = 4;
	final static public int RENT_ON_PROPERTY_ACTION_CARD = 5;
	final static public int ADDITIONAL_PAYMENT_ON_PREVIOUS_RENT_ACTION_CARD = 6;
	final static public int CASH_PAYMENT_ACTION_CARD = 7;
	final static public int CEASE_ACTION_CARD = 8;
	final static public int STEAL_ACTION_CARD = 9;
	final static public int STEAL_A_SINGLE_CARD_ACTION_CARD = 10;
	final static public int STEAL_A_SET_ACTION_CARD = 11;
	final static public int SWAP_A_SINGLE_CARD_ACTION_CARD = 12;

	
	// card names in Card_Count.csv
	final static public String MONEY_1M = "M1";
	final static public String MONEY_2M = "M2";
	final static public String MONEY_3M = "M3";
	final static public String MONEY_4M = "M4";
	final static public String MONEY_5M = "M5";
	final static public String MONEY_10M = "M10";

	final static public String ACTION_PASS_GO = "pass_go";
	final static public String ACTION_DEAL_BREAKER = "deal_breaker";
	final static public String ACTION_JUST_SAY_NO = "just_say_no";
	final static public String ACTION_SLY_DEAL = "sly_deal";
	final static public String ACTION_FORCED_DEAL = "forced_deal";
	final static public String ACTION_ITS_MY_BIRTHDAY = "its_my_birthday";
	final static public String ACTION_DEBT_COLLECTOR = "debt_collector";
	final static public String ACTION_HOUSE = "house";
	final static public String ACTION_HOTEL = "hotel";
	final static public String ACTION_PINK_ORANGE_RENT = "pink_orange_rent";
	final static public String ACTION_BLUE_GREEN_RENT = "blue_green_rent";
	final static public String ACTION_RED_YELLOW_RENT = "red_yellow_rent";
	final static public String ACTION_GREY_BLACK_RENT = "grey_black_rent";
	final static public String ACTION_SKYBLUE_BROWN_RENT = "skyblue_brown_rent";
	final static public String ACTION_DOUBLE_THE_RENT = "double_the_rent";
	final static public String ACTION_ANY_CARD_RENT = "any_card_rent";
	
	final static public String PROPERTY_GREEN = "green";
	final static public String PROPERTY_BLACK = "black";
	final static public String PROPERTY_SKYBLUE = "skyblue";
	final static public String PROPERTY_PINK = "pink";
	final static public String PROPERTY_GREY = "grey";
	final static public String PROPERTY_ORANGE = "orange";
	final static public String PROPERTY_YELLOW = "yellow";
	final static public String PROPERTY_RED = "red";
	final static public String PROPERTY_BLUE = "blue";
	final static public String PROPERTY_BROWN = "brown";
	final static public String PROPERTY_GREEN_BLUE_WILD = "green_blue_wild";
	final static public String PROPERTY_GREEN_BLACK_WILD = "green_black_wild";
	final static public String PROPERTY_GREY_BLACK_WILD = "grey_black_wild";
	final static public String PROPERTY_SKYBLUE_BLACK_WILD = "skyblue_black_wild";
	final static public String PROPERTY_SKYBLUE_BROWN_WILD = "skyblue_brown_wild";
	final static public String PROPERTY_PINK_ORANGE_WILD = "pink_orange_wild";
	final static public String PROPERTY_RED_YELLOW_WILD = "red_yellow_wild";
	final static public String PROPERTY_WILD_CARD = "property_wild_card";
	
}
