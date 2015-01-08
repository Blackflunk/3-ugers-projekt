package JUnit_Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import fields.MoveToJail;
import game.GameBoard;
import game.Player;

public class MoveToJailTest {
	@Test
	public void testFængsel(){
	
	//Preconditions
		//opretter spiller
	GameBoard gameboard = new GameBoard(null);
	Player player1 = new Player("Spiller1");
	
	//Test
		// lader spilleren lande på felt 31 "gå i fængsel"
	player1.setPosition(30);
	gameboard.getField(player1.getPosition()).landOnField(player1);

	//Postconditions
		// Tjekker at spilleren er i fængsel
	assertEquals(true, player1.isJailed());
	}
}
