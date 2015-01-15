package test_JUnit;

import static org.junit.Assert.*;
import entity.DiceBox;
import entity.Player;
import fields.GameBoard;
import org.junit.Test;

public class TestPurchase {

	@Test
	public void test() {
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];	
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
		//Tjek om spilleren er p� feltet
		assertEquals(25600,players[0].account.getScore());
		assertEquals(29600,players[1].account.getScore());
		
	}	
}
