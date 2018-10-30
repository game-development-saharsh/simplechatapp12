package game.controls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import constants.AppConstants;
import game.bean.cards.Card;
import game.bean.cards.action.AnyColorRentActionCard;
import game.bean.cards.action.BirthdayPaymentActionCard;
import game.bean.cards.action.BlueOrGreenRentCard;
import game.bean.cards.action.DealBreakerActionCard;
import game.bean.cards.action.DebtCollectorActionCard;
import game.bean.cards.action.DoubleTheRentActionCard;
import game.bean.cards.action.ForcedDealActionCard;
import game.bean.cards.action.GreyOrBlackRentCard;
import game.bean.cards.action.HotelActionCard;
import game.bean.cards.action.HouseActionCard;
import game.bean.cards.action.JustSayNoActionCard;
import game.bean.cards.action.PassGoActionCard;
import game.bean.cards.action.PinkOrOrangeRentCard;
import game.bean.cards.action.RedOrYellowRentCard;
import game.bean.cards.action.SkyblueOrBrownRendCard;
import game.bean.cards.action.SlyDealActionCard;
import game.bean.cards.money.FiveMnMoneyCard;
import game.bean.cards.money.FourMnMoneyCard;
import game.bean.cards.money.OneMnMoneyCard;
import game.bean.cards.money.TenMnMoneyCard;
import game.bean.cards.money.ThreeMnMoneyCard;
import game.bean.cards.money.TwoMnMoneyCard;
import game.bean.cards.property.AllColorPropertyWildCard;
import game.bean.cards.property.BlackSingleColorPropertyCard;
import game.bean.cards.property.BlueSingleColorPropertyCard;
import game.bean.cards.property.BrownSingleColorPropertyCard;
import game.bean.cards.property.GreenAndBlackDualColorPropertyCard;
import game.bean.cards.property.GreenAndBlueDualColorPropertyCard;
import game.bean.cards.property.GreenSingleColorPropertyCard;
import game.bean.cards.property.GreyAndBlackDualColorPropertyCard;
import game.bean.cards.property.GreySingleColorPropertyCard;
import game.bean.cards.property.OrangeSingleColorPropertyCard;
import game.bean.cards.property.PinkAndOrangeDualColorPropertyCard;
import game.bean.cards.property.PinkSingleColorPropertyCard;
import game.bean.cards.property.RedAndYellowDualColorPropertyCard;
import game.bean.cards.property.RedSingleColorPropertyCard;
import game.bean.cards.property.SkyblueAndBlackDualColorPropertyCard;
import game.bean.cards.property.SkyblueAndBrownDualColorPropertyCard;
import game.bean.cards.property.SkyblueSingleColorPropertyCard;
import game.bean.cards.property.YellowSingleColorPropertyCard;

public class InitializeDrawPile {
	private File cardCountDetailFile = new File(AppConstants.PATH_OF_ONLY_CARD_COUNT_DOT_CSV);
	
//	public static void main(String[] args) throws URISyntaxException, IOException {
//		InitializeDrawPile initializeDrawPile = new InitializeDrawPile();
//		if(initializeDrawPile.getCardCountDetailFile().exists()) {
//			initializeDrawPile.prepareAllCardsInSequence();
//		}
//		else {
//			System.out.println("recource file not found.");
//		}
//	}
	
	
	public List<Card> prepareAllCardsInSequence(){
		List<Card> listOfCardsInSequence = null;
		List<String> contentList = contentOfFile();
		if(contentList.size()>0) {
			listOfCardsInSequence = prepareListOfCardsInSequenceFromContentList(contentList);
			for(int i=0;i<listOfCardsInSequence.size();i++) {
				System.out.println(listOfCardsInSequence.get(i).getCardId());
			}
		}
		return listOfCardsInSequence;
	}
	
	private  List<Card> prepareListOfCardsInSequenceFromContentList(List<String> contentList){
		List<Card> listOfCardsInSequence = new ArrayList<>();
		int count = -1;
		int id = 1;
		count = Integer.parseInt(contentList.get(0));
		listOfCardsInSequence.addAll(prepareCardsOfMoneyOneMn(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(1));
		listOfCardsInSequence.addAll(prepareCardsOfMoneyTwoMn(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(2));
		listOfCardsInSequence.addAll(prepareCardsOfMoneyThreeMn(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(3));
		listOfCardsInSequence.addAll(prepareCardsOfMoneyFourMn(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(4));
		listOfCardsInSequence.addAll(prepareCardsOfMoneyFiveMn(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(5));
		listOfCardsInSequence.addAll(prepareCardsOfMoneyTenMn(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(6));
		listOfCardsInSequence.addAll(prepareCardsOfPassGoActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(7));
		listOfCardsInSequence.addAll(prepareCardsOfDealBreakerActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(8));
		listOfCardsInSequence.addAll(prepareCardsOfJustSayNoActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(9));
		listOfCardsInSequence.addAll(prepareCardsOfSlyDealActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(10));
		listOfCardsInSequence.addAll(prepareCardsOfForcedDealActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(11));
		listOfCardsInSequence.addAll(prepareCardsOfBirthdayPaymentActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(12));
		listOfCardsInSequence.addAll(prepareCardsOfDebtCollectorActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(13));
		listOfCardsInSequence.addAll(prepareCardsOfHouseActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(14));
		listOfCardsInSequence.addAll(prepareCardsOfHotelActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(15));
		listOfCardsInSequence.addAll(prepareCardsOfPinkOrOrangeRentCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(16));
		listOfCardsInSequence.addAll(prepareCardsOfBlueOrGreenRentCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(17));
		listOfCardsInSequence.addAll(prepareCardsOfRedOrYellowRentCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(18));
		listOfCardsInSequence.addAll(prepareCardsOfGreyOrBlackRentCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(19));
		listOfCardsInSequence.addAll(prepareCardsOfSkyblueOrBrownRendCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(20));
		listOfCardsInSequence.addAll(prepareCardsOfDoubleTheRentActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(21));
		listOfCardsInSequence.addAll(prepareCardsOfAnyColorRentActionCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(22));
		listOfCardsInSequence.addAll(prepareCardsOfAllColorPropertyWildCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(23));
		listOfCardsInSequence.addAll(prepareCardsOfGreenSingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(24));
		listOfCardsInSequence.addAll(prepareCardsOfBlackSingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(25));
		listOfCardsInSequence.addAll(prepareCardsOfSkyblueSingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(26));
		listOfCardsInSequence.addAll(prepareCardsOfPinkSingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(27));
		listOfCardsInSequence.addAll(prepareCardsOfGreySingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(28));
		listOfCardsInSequence.addAll(prepareCardsOfOrangeSingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(29));
		listOfCardsInSequence.addAll(prepareCardsOfYellowSingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(30));
		listOfCardsInSequence.addAll(prepareCardsOfRedSingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(31));
		listOfCardsInSequence.addAll(prepareCardsOfBlueSingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(32));
		listOfCardsInSequence.addAll(prepareCardsOfBrownSingleColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(33));
		listOfCardsInSequence.addAll(prepareCardsOfGreenAndBlueDualColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(34));
		listOfCardsInSequence.addAll(prepareCardsOfGreenAndBlackDualColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(35));
		listOfCardsInSequence.addAll(prepareCardsOfGreyAndBlackDualColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(36));
		listOfCardsInSequence.addAll(prepareCardsOfSkyblueAndBlackDualColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(37));
		listOfCardsInSequence.addAll(prepareCardsOfSkyblueAndBrownDualColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(38));
		listOfCardsInSequence.addAll(prepareCardsOfPinkAndOrangeDualColorPropertyCard(count, id));
		id += count;
		
		count = Integer.parseInt(contentList.get(39));
		listOfCardsInSequence.addAll(prepareCardsOfRedAndYellowDualColorPropertyCard(count, id));
		id += count;
		
		return listOfCardsInSequence;
	}
	private List<OneMnMoneyCard> prepareCardsOfMoneyOneMn(int count, int id){
		List<OneMnMoneyCard> oneMnCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			OneMnMoneyCard oneMnMoneyCard = new OneMnMoneyCard();
			oneMnMoneyCard.setCardId(id);
			id++;
			oneMnMoneyCard.setNameOfCard("1 Million");
			oneMnCardsList.add(oneMnMoneyCard);
		}
		return oneMnCardsList;
	}
	private List<TwoMnMoneyCard> prepareCardsOfMoneyTwoMn(int count, int id){
		List<TwoMnMoneyCard> twoMnCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			TwoMnMoneyCard twoMnMoneyCard = new TwoMnMoneyCard();
			twoMnMoneyCard.setCardId(id);
			id++;
			twoMnMoneyCard.setNameOfCard("2 Million");
			twoMnCardsList.add(twoMnMoneyCard);
		}
		return twoMnCardsList;
	}
	private List<ThreeMnMoneyCard> prepareCardsOfMoneyThreeMn(int count, int id){
		List<ThreeMnMoneyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			ThreeMnMoneyCard moneyCard = new ThreeMnMoneyCard();
			moneyCard.setCardId(id);
			id++;
			moneyCard.setNameOfCard("3 Million");
			finalCardsList.add(moneyCard);
		}
		return finalCardsList;
	}
	private List<FourMnMoneyCard> prepareCardsOfMoneyFourMn(int count, int id){
		List<FourMnMoneyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			FourMnMoneyCard moneyCard = new FourMnMoneyCard();
			moneyCard.setCardId(id);
			id++;
			moneyCard.setNameOfCard("4 Million");
			finalCardsList.add(moneyCard);
		}
		return finalCardsList;
	}
	private List<FiveMnMoneyCard> prepareCardsOfMoneyFiveMn(int count, int id){
		List<FiveMnMoneyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			FiveMnMoneyCard moneyCard = new FiveMnMoneyCard();
			moneyCard.setCardId(id);
			id++;
			moneyCard.setNameOfCard("5 Million");
			finalCardsList.add(moneyCard);
		}
		return finalCardsList;
	}
	private List<TenMnMoneyCard> prepareCardsOfMoneyTenMn(int count, int id){
		List<TenMnMoneyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			TenMnMoneyCard moneyCard = new TenMnMoneyCard();
			moneyCard.setCardId(id);
			id++;
			moneyCard.setNameOfCard("10 Million");
			finalCardsList.add(moneyCard);
		}
		return finalCardsList;
	}
	private List<AnyColorRentActionCard> prepareCardsOfAnyColorRentActionCard(int count, int id){
		List<AnyColorRentActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			AnyColorRentActionCard card = new AnyColorRentActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Any Color Rent");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<BirthdayPaymentActionCard> prepareCardsOfBirthdayPaymentActionCard(int count, int id){
		List<BirthdayPaymentActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			BirthdayPaymentActionCard card = new BirthdayPaymentActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("It is my birthday");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<BlueOrGreenRentCard> prepareCardsOfBlueOrGreenRentCard(int count, int id){
		List<BlueOrGreenRentCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			BlueOrGreenRentCard card = new BlueOrGreenRentCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Blue Or Green Rent");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<DebtCollectorActionCard> prepareCardsOfDebtCollectorActionCard(int count, int id){
		List<DebtCollectorActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			DebtCollectorActionCard card = new DebtCollectorActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Debt Collector");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<DealBreakerActionCard> prepareCardsOfDealBreakerActionCard(int count, int id){
		List<DealBreakerActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			DealBreakerActionCard card = new DealBreakerActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Deal Breaker");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<DoubleTheRentActionCard> prepareCardsOfDoubleTheRentActionCard(int count, int id){
		List<DoubleTheRentActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			DoubleTheRentActionCard card = new DoubleTheRentActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Double The Rent");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<ForcedDealActionCard> prepareCardsOfForcedDealActionCard(int count, int id){
		List<ForcedDealActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			ForcedDealActionCard card = new ForcedDealActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Forced Deal");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<GreyOrBlackRentCard> prepareCardsOfGreyOrBlackRentCard(int count, int id){
		List<GreyOrBlackRentCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			GreyOrBlackRentCard card = new GreyOrBlackRentCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Grey Or Black Rent");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<HotelActionCard> prepareCardsOfHotelActionCard(int count, int id){
		List<HotelActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			HotelActionCard card = new HotelActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Hotel");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<HouseActionCard> prepareCardsOfHouseActionCard(int count, int id){
		List<HouseActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			HouseActionCard card = new HouseActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("House");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<JustSayNoActionCard> prepareCardsOfJustSayNoActionCard(int count, int id){
		List<JustSayNoActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			JustSayNoActionCard card = new JustSayNoActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Just Say No");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<PassGoActionCard> prepareCardsOfPassGoActionCard(int count, int id){
		List<PassGoActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			PassGoActionCard card = new PassGoActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Pass Go");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<PinkOrOrangeRentCard> prepareCardsOfPinkOrOrangeRentCard(int count, int id){
		List<PinkOrOrangeRentCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			PinkOrOrangeRentCard card = new PinkOrOrangeRentCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Pink Or Orange Rent");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<RedOrYellowRentCard> prepareCardsOfRedOrYellowRentCard(int count, int id){
		List<RedOrYellowRentCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			RedOrYellowRentCard card = new RedOrYellowRentCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Red Or Yellow Rent");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<SkyblueOrBrownRendCard> prepareCardsOfSkyblueOrBrownRendCard(int count, int id){
		List<SkyblueOrBrownRendCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			SkyblueOrBrownRendCard card = new SkyblueOrBrownRendCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Skyblue Or Brown Rent");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<SlyDealActionCard> prepareCardsOfSlyDealActionCard(int count, int id){
		List<SlyDealActionCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			SlyDealActionCard card = new SlyDealActionCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Sly Deal");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<AllColorPropertyWildCard> prepareCardsOfAllColorPropertyWildCard(int count, int id){
		List<AllColorPropertyWildCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			AllColorPropertyWildCard card = new AllColorPropertyWildCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Property Wild Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<BlackSingleColorPropertyCard> prepareCardsOfBlackSingleColorPropertyCard(int count, int id){
		List<BlackSingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			BlackSingleColorPropertyCard card = new BlackSingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Black Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<BlueSingleColorPropertyCard> prepareCardsOfBlueSingleColorPropertyCard(int count, int id){
		List<BlueSingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			BlueSingleColorPropertyCard card = new BlueSingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Blue Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<BrownSingleColorPropertyCard> prepareCardsOfBrownSingleColorPropertyCard(int count, int id){
		List<BrownSingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			BrownSingleColorPropertyCard card = new BrownSingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Brown Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<GreenAndBlackDualColorPropertyCard> prepareCardsOfGreenAndBlackDualColorPropertyCard(int count, int id){
		List<GreenAndBlackDualColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			GreenAndBlackDualColorPropertyCard card = new GreenAndBlackDualColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Green And Black Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<GreenAndBlueDualColorPropertyCard> prepareCardsOfGreenAndBlueDualColorPropertyCard(int count, int id){
		List<GreenAndBlueDualColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			GreenAndBlueDualColorPropertyCard card = new GreenAndBlueDualColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Green And Blue Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<GreenSingleColorPropertyCard> prepareCardsOfGreenSingleColorPropertyCard(int count, int id){
		List<GreenSingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			GreenSingleColorPropertyCard card = new GreenSingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Green Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<GreyAndBlackDualColorPropertyCard> prepareCardsOfGreyAndBlackDualColorPropertyCard(int count, int id){
		List<GreyAndBlackDualColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			GreyAndBlackDualColorPropertyCard card = new GreyAndBlackDualColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Grey And Black Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<GreySingleColorPropertyCard> prepareCardsOfGreySingleColorPropertyCard(int count, int id){
		List<GreySingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			GreySingleColorPropertyCard card = new GreySingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Grey Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<OrangeSingleColorPropertyCard> prepareCardsOfOrangeSingleColorPropertyCard(int count, int id){
		List<OrangeSingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			OrangeSingleColorPropertyCard card = new OrangeSingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Orange Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<PinkAndOrangeDualColorPropertyCard> prepareCardsOfPinkAndOrangeDualColorPropertyCard(int count, int id){
		List<PinkAndOrangeDualColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			PinkAndOrangeDualColorPropertyCard card = new PinkAndOrangeDualColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Pink And Orange Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<RedAndYellowDualColorPropertyCard> prepareCardsOfRedAndYellowDualColorPropertyCard(int count, int id){
		List<RedAndYellowDualColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			RedAndYellowDualColorPropertyCard card = new RedAndYellowDualColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Red And Yellow Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<RedSingleColorPropertyCard> prepareCardsOfRedSingleColorPropertyCard(int count, int id){
		List<RedSingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			RedSingleColorPropertyCard card = new RedSingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Red Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<PinkSingleColorPropertyCard> prepareCardsOfPinkSingleColorPropertyCard(int count, int id){
		List<PinkSingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			PinkSingleColorPropertyCard card = new PinkSingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Pink Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<SkyblueAndBlackDualColorPropertyCard> prepareCardsOfSkyblueAndBlackDualColorPropertyCard(int count, int id){
		List<SkyblueAndBlackDualColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			SkyblueAndBlackDualColorPropertyCard card = new SkyblueAndBlackDualColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Skyblue And Black Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<SkyblueAndBrownDualColorPropertyCard> prepareCardsOfSkyblueAndBrownDualColorPropertyCard(int count, int id){
		List<SkyblueAndBrownDualColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			SkyblueAndBrownDualColorPropertyCard card = new SkyblueAndBrownDualColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Skyblue And Brown Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<SkyblueSingleColorPropertyCard> prepareCardsOfSkyblueSingleColorPropertyCard(int count, int id){
		List<SkyblueSingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			SkyblueSingleColorPropertyCard card = new SkyblueSingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Skyblue Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	private List<YellowSingleColorPropertyCard> prepareCardsOfYellowSingleColorPropertyCard(int count, int id){
		List<YellowSingleColorPropertyCard> finalCardsList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			YellowSingleColorPropertyCard card = new YellowSingleColorPropertyCard();
			card.setCardId(id);
			id++;
			card.setNameOfCard("Yellow Property Card");
			finalCardsList.add(card);
		}
		return finalCardsList;
	}
	
	
	private List<String> contentOfFile() {
		List<String> contentList = new ArrayList<String>();

		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream(cardCountDetailFile);
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        contentList.add(line);
		        // System.out.println(line);
		    }
		    // note that Scanner suppresses exceptions
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		return contentList;
	}
	
	public File getCardCountDetailFile() {
		return cardCountDetailFile;
	}

	public void setCardCountDetailFile(File cardCountDetailFile) {
		this.cardCountDetailFile = cardCountDetailFile;
	}
}
