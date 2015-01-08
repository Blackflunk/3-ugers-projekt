package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fields.GameBoard;
import fields.MoveToJail;
import game.Player;

public class MoveToJailTest {
	@Test
	public void testFaengsel(){
	
	//Preconditions
		//Initialise gameboard and player objects.
	GameBoard gameboard = new GameBoard(null);
	Player player1 = new Player("Spiller1");
	
	//Test
		// Sets the players position to 30.
	player1.setPosition(30);
	gameboard.getField(player1.getPosition()).landOnField(player1);

	//Postconditions
		// Check if it is true that the player is now in jail.
	assertEquals(true, player1.isJailed());
	}
}
