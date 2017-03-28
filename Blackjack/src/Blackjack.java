import java.util.Scanner;


public class Blackjack {

	/**Joey Wilson
	 * 3/12/2017
	 * Console blackjack game for practice with OOP and Java style enumerators
	 */

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		char userInput;

		// Create a deck
		Deck d1 = new Deck();
		d1.populate();

		//Loop to let you play more hands
		while (userInput != 'y'){
			//Shuffle
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

			//Hit or pass
			for (int i = 0; i < hands.length; i++){
				System.out.println("Hit or pass?(h/p): ");
				userInput = myScanner.next().trim().charAt(0);
				if (userInput == 'h'){
					hit(hands[i],d1);
					while (hands[i].getTotal()>0 && userInput == 'h'){
						System.out.println("Hit again?(h/p):");
						userInput = myScanner.next().trim().charAt(0);
						if (userInput == 'h')
							hit(hands[i],d1);
						}
					}
			}
			//Hit for the dealer
			while (dealer.getTotal()<16){
				hit(dealer,d1);
				System.out.println("\nDealers cards: \n" + dealer.showHand());
			}
			//Find winner
			if (h1.getTotal()>h2.getTotal() && h1.getTotal()>h3.getTotal()&& h1.getTotal()>dealer.getTotal()){
				System.out.println("Player 1 is the winner!!!");
			}else if (h2.getTotal()>h1.getTotal() && h2.getTotal()>h3.getTotal()&& h2.getTotal()>dealer.getTotal()){
				System.out.println("Player 2 is the winner!!!");
			}else if (h3.getTotal()>h1.getTotal() && h3.getTotal()>h2.getTotal()&& h3.getTotal()>dealer.getTotal()){
				System.out.println("Player 3 is the winner!!!");
			}else {
				System.out.println("The house wins...");
			}
			System.out.println("Would  you like to play another hand?(y/n)");
			myScanner.next().trim().charAt(0);
		}
		myScanner.close();
	}
	//Hit function
	public static void hit(Hand hand,Deck deck){
		deck.deal(hand, 1);
		hand.flipCards();
		System.out.println(hand.showHand());
		if (hand.getTotal()>21){
			System.out.println("You busted! Bummer!");
			hand.cards.clear();
		}
	}

}
