package JUnit_Tests;

import static org.junit.Assert.*;
import boundary.GUIcontroller;
import fields.GameBoard;
import game.DiceBox;
import deck.Deck;
import game.Player;
import org.junit.Test;
import control.DeckController;

public class DeckTest {

	@Test
	public void testKort1() {
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		GUIcontroller GUIC = new GUIcontroller();
		DeckController DC = new DeckController(deck, GUIC, players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		players[0].setPosition(0);
	//Test
		//Move to "Groenningen"
		DC.drawCard(players[0]);

	//Postconditions
		//Tjek om spilleren er på feltet
		assertEquals(24,players[0].getPosition());
		
	}
	
	@Test
	public void testKort2() {
		//Preconditions
			DiceBox box = new DiceBox();
			GameBoard board = new GameBoard(box);
			Player[] players = new Player[3];
			Deck deck = new Deck(players, board);
			GUIcontroller GUIC = new GUIcontroller();
			DeckController DC = new DeckController(deck, GUIC, players, board);
			
			players[0] = new Player("Spiller1");
			players[1] = new Player("Spiller2");
			players[2] = new Player("Spiller3");
			players[0].setPosition(0);
		//Test
			//Draws second card,
			DC.drawCard(players[0]);
			System.out.println(players[0].getPosition());
			players[0].setPosition(2);
			DC.drawCard(players[0]);
			System.out.println(players[0].getPosition());
			DC.drawCard(players[0]);
			System.out.println(players[0].getPosition());

		//Postconditions
			//Tjek om spilleren er på feltet
			assertEquals(5,players[0].getPosition());
		}

}
