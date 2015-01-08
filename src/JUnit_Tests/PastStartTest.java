package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fields.GameBoard;
import game.Player;


public class PastStartTest {

	@Test
	public void test1() {
	//Preconditions
	GameBoard gameboard = new GameBoard(null);
	Player player1 = new Player("Spiller1");
	//Test
		//Set the player position to field 37.
		player1.setPosition(37);
		//Move player 5 positions forward.
		player1.movePosition(5);
	//Postconditions
		//Check if position 2
		assertEquals(2,player1.getPosition());
	}
	
	@Test
	public void test2(){
	//Preconditions
		//Initialise the gameboard and player object.
		GameBoard gameboard = new GameBoard(null);
		Player player1 = new Player("Spiller1");
		//Set the player score to 5000.
		player1.account.setScore(5000);
	
	//Test
		//Set the player position to field 37.
		player1.setPosition(37);
		//Move player 5 positions forward.
		player1.movePosition(5);
	//Postconditions
		//Check if position 2
		assertEquals(2,player1.getPosition());
		//Check if player received 4000 when crossing start.
		assertEquals(9000,player1.account.getScore());
	}
	

}
