package JUnit_Tests;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
import boundary.GUIcontroller;
import fields.GameBoard;
import game.DiceBox;
import deck.Deck;
import game.Player;

import org.junit.Test;

import control.DeckController;
import control.FieldController;
import control.HouseController;

import org.junit.Test;

public class TestKøb {

	@Test
	public void test() {
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		GUIcontroller GUIC = new GUIcontroller();
		FieldController FC = new FieldController(GUIC, board, box, players);
		DeckController DC = new DeckController(deck, GUIC, players, board, FC);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		players[0].setPosition(0);
	//Test
		//Move to "Groenningen"
		board.getField(24).setBuyfield(true);
		players[0].setPosition(24);
		board.getField(24).landOnField(players[0]);
		assertEquals(25200, players[0].account.getScore());
		players[1].setPosition(24);
		board.getField(24).landOnField(players[1]);

	//Postconditions
		//Tjek om spilleren er på feltet
		assertEquals(25600,players[0].account.getScore());
		assertEquals(29600,players[1].account.getScore());
		
	}	
}
