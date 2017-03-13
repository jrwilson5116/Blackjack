
public class Blackjack {

	/**Joey Wilson
	 * 3/12/2017
	 * Console blackjack game for practice with OOP and Java style enumerators 
	 */
	
	public static void main(String[] args) {
		
		// Create a deck
		Deck d1 = new Deck();
		d1.populate();
		d1.shuffle();
		
		//Create our playing hands
		Hand h1, h2, h3, dealer;
		h1 = new Hand();
		h2 = new Hand();
		h3 = new Hand();
		dealer = new Hand();
		Hand[] hands = {h1, h2, h3};
		
		//Deal cards to our hands
		d1.deal(hands, 2);
		//Deal cards to dealer
		d1.deal(dealer, 2);
		
		//Show the players hands
		for (int i = 0; i< hands.length; i++){
			hands[i].flipCards();
			System.out.println(hands[i].showHand());
		}
		//Flip the dealer's first card
		dealer.cards.get(0).flipCard();
		
		//Show the dealer's cards
		System.out.println("\nDealers cards: \n" + dealer.showHand());
		
	}

}
