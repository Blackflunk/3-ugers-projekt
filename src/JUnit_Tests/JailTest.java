package JUnit_Tests;

import static org.junit.Assert.*;
import entity.DiceBox;
import entity.Player;
import fields.GameBoard;

import org.junit.Test;

import boundary.GUIcontroller;
import control.TurnController;
import deck.Deck;

public class JailTest {

	@Test
	public void testJail1() {
		// Tests the getoutofjailcard
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] playerlist = new Player[3];
		playerlist[0] = new Player("Spiller1");
		playerlist[1] = new Player("Spiller2");
		playerlist[2] = new Player("Spiller3");
		GUIcontroller GC = new GUIcontroller();
		TurnController TC = new TurnController(GC, board, box, playerlist);
		
		// Preconditions
		playerlist[0].setOutofjailcard(true);
		playerlist[0].setJailed(true);
		playerlist[0].setPosition(10);
		
		// Test
		TC.exitCard(playerlist[0], 0);
		
		// Postconditions
		assertEquals(false, playerlist[0].isJailed());
	}
	@Test
	public void testJail2() {
		// Tests pay to get out of jail
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] playerlist = new Player[3];
		playerlist[0] = new Player("Spiller1");
		playerlist[1] = new Player("Spiller2");
		playerlist[2] = new Player("Spiller3");
		GUIcontroller GC = new GUIcontroller();
		TurnController TC = new TurnController(GC, board, box, playerlist);
		
		// Preconditions
		playerlist[0].setJailed(true);
		playerlist[0].setPosition(10);
		
		// Test 
		TC.exitPay(playerlist[0], 0);
		
		// Postconditions
		assertEquals(29000, playerlist[0].account.getScore());
	}
	@Test
	public void testJail3() {
		// Test throw to exit jail
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] playerlist = new Player[3];
		playerlist[0] = new Player("Spiller1");
		playerlist[1] = new Player("Spiller2");
		playerlist[2] = new Player("Spiller3");
		GUIcontroller GC = new GUIcontroller();
		TurnController TC = new TurnController(GC, board, box, playerlist);
		
		// Preconditions
		playerlist[0].setJailed(true);
		playerlist[0].setPosition(10);
		
		// First Throw - not pair
		box.setDice(0, 6);
		box.setDice(1, 4);
		TC.exitThrowTest(playerlist[0], 0, box);
		
		assertEquals(true, playerlist[0].isJailed());
		
		// Second Throw - not pair
		box.setDice(0, 5);
		box.setDice(1, 1);
		TC.exitThrowTest(playerlist[0], 0, box);
		
		assertEquals(true, playerlist[0].isJailed());
		
		// Third Throw - pair
		box.setDice(0, 4);
		box.setDice(1, 4);
		TC.exitThrowTest(playerlist[0], 0, box);
		
		assertEquals(false, playerlist[0].isJailed());
		assertEquals(18, playerlist[0].getPosition());
		
	}
	@Test
	public void testJail4() {
		// Test throw to exit jail, but after 3 turns (9 tries), he is forced to pay
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] playerlist = new Player[3];
		playerlist[0] = new Player("Spiller1");
		playerlist[1] = new Player("Spiller2");
		playerlist[2] = new Player("Spiller3");
		GUIcontroller GC = new GUIcontroller();
		TurnController TC = new TurnController(GC, board, box, playerlist);
		
		// Preconditions
		playerlist[0].setJailed(true);
		playerlist[0].setPosition(10);
		
		// Turn 1
		// First Throw - not pair
				box.setDice(0, 6);
				box.setDice(1, 4);
				TC.exitThrowTest(playerlist[0], 0, box);
				
				assertEquals(true, playerlist[0].isJailed());
				
		// Second Throw - not pair
				box.setDice(0, 5);
				box.setDice(1, 1);
				TC.exitThrowTest(playerlist[0], 0, box);
				
				assertEquals(true, playerlist[0].isJailed());
		
		// Third Throw - not pair
				box.setDice(0, 5);
				box.setDice(1, 4);
				TC.exitThrowTest(playerlist[0], 0, box);
				
				assertEquals(true, playerlist[0].isJailed());
				assertEquals(1,playerlist[0].getJailcount());
		
		// Turn 2
		// First Throw - not pair
				box.setDice(0, 6);
				box.setDice(1, 4);
				TC.exitThrowTest(playerlist[0], 0, box);
				
				assertEquals(true, playerlist[0].isJailed());
		
		// Second Throw - not pair
				box.setDice(0, 5);
				box.setDice(1, 1);
				TC.exitThrowTest(playerlist[0], 0, box);
				
				assertEquals(true, playerlist[0].isJailed());
				
		// Third Throw - not pair
				box.setDice(0, 5);
				box.setDice(1, 4);
				TC.exitThrowTest(playerlist[0], 0, box);
				
				assertEquals(true, playerlist[0].isJailed());
				assertEquals(2,playerlist[0].getJailcount());
				
		// Turn 3
		// First Throw - not pair
				box.setDice(0, 6);
				box.setDice(1, 4);
				TC.exitThrowTest(playerlist[0], 0, box);
				
				assertEquals(true, playerlist[0].isJailed());
		
		// Second Throw - not pair
				box.setDice(0, 5);
				box.setDice(1, 1);
				TC.exitThrowTest(playerlist[0], 0, box);
				
				assertEquals(true, playerlist[0].isJailed());
				
		// Third Throw - not pair
		// Now the player should be forced to pay
				box.setDice(0, 5);
				box.setDice(1, 4);
				TC.exitThrowTest(playerlist[0], 0, box);
				
				
		// Postconditions
				assertEquals(false, playerlist[0].isJailed());
				assertEquals(29000, playerlist[0].account.getScore());
				assertEquals(0,playerlist[0].getJailcount());
	}

}
