package JUnit_Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import fields.MoveToJail;
import game.GameBoard;
import game.Player;

public class MoveToJailTest {
	@Test
	public void testFaengsel(){
	
	//Preconditions
	GameBoard gameboard = new GameBoard(null);
	Player player1 = new Player("Spiller1");
	
	//Test
	player1.setPosition(30);
	gameboard.getField(player1.getPosition()).landOnField(player1);

	//Postconditions
	assertEquals(true, player1.isJailed());
	}
}
