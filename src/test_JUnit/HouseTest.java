package test_JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import boundary.GUIController;
import control.HouseController;
import entity.DiceBox;
import entity.Player;
import fields.GameBoard;

public class HouseTest {

	@Before
	public void ini(){
	DiceBox box = new DiceBox();
	GameBoard board = new GameBoard(box);
	Player[] players = new Player[3];
	players[0] = new Player("Spiller1");
	players[1] = new Player("Spiller2");
	players[2] = new Player("Spiller3");
	GUIController GUIC = new GUIController();
	HouseController HC = new HouseController(GUIC, board, players);
	}
	
	@Test
	public void testHouse(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		GUIController GUIC = new GUIController();
		HouseController HC = new HouseController(GUIC, board, players);
	// Preconditions
		players[0].setPosition(11);
		board.getField(11).setBuyfield(true);
		board.getField(players[0].getPosition()).landOnField(players[0]);
		players[0].setPosition(13);
		board.getField(13).setBuyfield(true);
		board.getField(players[0].getPosition()).landOnField(players[0]);
		players[0].setPosition(14);
		board.getField(14).setBuyfield(true);
		board.getField(players[0].getPosition()).landOnField(players[0]);
		assertEquals(21200, players[0].account.getScore());
		assertEquals(30000, players[1].account.getScore());
	// Test
		HC.checkOwnedFields(0);
		HC.buyHouse(0);

		players[1].setPosition(11);
		board.getField(players[1].getPosition()).landOnField(players[1]);
	

	// Postconditions
		assertEquals(3,players[0].getFieldammount_green());
		assertEquals(16200, players[0].account.getScore());
		assertEquals(29000, players[1].account.getScore());
		
	}
}

