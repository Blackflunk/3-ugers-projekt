package JUnit_Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import fields.MoveToJail;
import game.GameBoard;
import game.Player;

public class MoveToJailTest {
	@Test
	public void testF�ngsel(){
	
	//Preconditions
		//opretter spiller
	GameBoard gameboard = new GameBoard(null);
	Player player1 = new Player("Spiller1");
	
	//Test
		// lader spilleren lande p� felt 31 "g� i f�ngsel"
	player1.setPosition(30);
	gameboard.getField(player1.getPosition()).landOnField(player1);

	//Postconditions
		// Tjekker at spilleren er i f�ngsel
	assertEquals(true, player1.isJailed());
	}
}
