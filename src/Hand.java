
import java.util.ArrayList;

public class Hand {
	protected ArrayList<Card> cards;
	
	// Constructor 
	public Hand(){
		cards = new ArrayList<Card>();
	}
	public void clear(){
		cards.clear();
	}
	public void add(Card card){
		cards.add(card);
	}
	public String showHand(){
		// Show cards and total but only if they are face up
		String str = "";
		boolean allFaceUp = true;
		for (Card c: cards){
			str += c.toString() + "\n";
			if (!c.isFaceUp){
				allFaceUp = false;
			}
		}
		//If all cards are face up, show total 
		if (allFaceUp){
			str += "Total ponts = " + getTotal() + "\n";
		}
		return str;
	}
	public void flipCards(){
		for (Card c: cards){
			c.flipCard();
		}
	}
	public boolean give(Card card, Hand otherHand){
		if (!cards.contains(card)){
			return false;
		}else {
			cards.remove(card);
			otherHand.add(card);
			return true;
		}
	}
		// Return total points of a hand
	public int getTotal(){
		int totalPts =0;
		boolean hasAce = false;
		// Getting total points Aces = 1
		for (int i = 0; i < cards.size(); i++){
			totalPts += cards.get(i).getRank();
			//check to see if the card is an Ace
			if (cards.get(i).printRank() == "Ace"){
				hasAce = true;
				}
			// Make Ace worth 11 if total points <= 11
			if (hasAce && totalPts <= 11){
				totalPts += 10; // Add 10 more to the Ace
			}
			if (hasAce && totalPts > 21){
				totalPts -= 10;
			}
		}
		return totalPts;	
	}

}
