package test;

import fields.GameBoard;
import game.DiceBox;
import game.Player;
import deck.Deck;

public class TestCase6 {
	public static void main(String[] args) {
		Player[] players = new Player[3];
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Deck deck = new Deck(players, board);
		
		System.out.println(deck);
		deck.drawCard(players[0]);
		
		System.out.println(deck);
	}

}
