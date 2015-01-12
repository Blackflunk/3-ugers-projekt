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
			//Draws second card, move to nearest shipping company.
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
	
	@Test
	public void testKort3(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 8.
		players[0].setPosition(7);
		
		
		
	//Test
		//Draws third card, move to start.
		deck.pickCard(players[0], 2);
		


	//Postconditions
		//Check if the given field.
		assertEquals(0,players[0].getPosition());
	}

	@Test
	public void testKort4(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 8.
		players[0].setPosition(7);
		
		
		
	//Test
		//Move 3 positions back.
		deck.pickCard(players[0], 3);
		


	//Postconditions
		//Check if the player is on the given field.
		assertEquals(4,players[0].getPosition());
	}

	@Test
	public void testKort5(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 18.
		players[0].setPosition(17);
		
		
		
	//Test
		//Move to Frederiksberg Alle
		deck.pickCard(players[0], 4);
		


	//Postconditions
		//Check if the player is on the given field.
		assertEquals(11,players[0].getPosition());
		//Check if player received money when crossing start.
		assertEquals(34000,players[0].account.getScore());
	}

	@Test
	public void testKort6(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 18.
		players[0].setPosition(36);
		
		
		
	//Test
		//Use mols linien, if you cross start receive 4000.
		deck.pickCard(players[0], 5);
		


	//Postconditions
		//Check if the player is on the given field.
		assertEquals(15,players[0].getPosition());
		//Check if player received money when crossing start.
		assertEquals(34000,players[0].account.getScore());
	}

	@Test
	public void testKort7(){
		
	}

}
