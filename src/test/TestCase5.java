package test;
import deck.Deck;
import fields.GameBoard;
import game.Player;
import game.DiceBox;

public class TestCase5 {
	
	public static void main(String[] args) {
		Player[] players = new Player[3];
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		
		Deck deck = new Deck(players, board);
		System.out.println(deck);
		deck.mixDeck();
		System.out.println("efter mix");
		System.out.println(deck);
	}

}
