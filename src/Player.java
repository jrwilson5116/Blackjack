//Contains money and betting functions and player name
public class Player {
	private int chips;
	private String playerName;
	
	//Constructor
	public Player(String name){
		playerName = name;
		chips = 50; //Everybody starts with 50
	}
	
	//Win a hand mutator
	public void winChips(int pot){
		chips += pot;
	}
	
	//Lose a hand mutator
	public void loseChips(int currentBet){
		chips -= currentBet;
	}
	
	//To string for output
	public String toString(){
		String output = playerName + "\nChips: " + chips;
		return output;
	}
}
