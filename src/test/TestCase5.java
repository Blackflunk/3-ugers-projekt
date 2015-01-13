package test;
import deck.Deck;
import entity.DiceBox;
import entity.Player;
import fields.GameBoard;

public class TestCase5 {
	
	public static void main(String[] args) {
		Player[] players = new Player[3];
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		
		Deck deck = new Deck(players, board);
		System.out.println(deck);
		deck.shuffleDeck();
		System.out.println("efter mix");
		System.out.println(deck);
	}

}
