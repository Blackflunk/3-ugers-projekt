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
		//S�tter ham p� position 37.
		player1.setPosition(37);
		//Rykker ham over start ved at sl� 5.
		player1.movePosition(5);
	//Postconditions
		//Tjekker om han er p� position 2.
		assertEquals(2,player1.getPosition());
	}
	
	@Test
	public void test2(){
	//Preconditions
		//Opretter gameboard og spiller
		GameBoard gameboard = new GameBoard(null);
		Player player1 = new Player("Spiller1");
		//S�tter spillerens scorer til 5000
		player1.account.setScore(5000);
	
	//Test
		//S�tter ham p� position 37.
		player1.setPosition(37);
		//Rykker ham over start ved at sl� 5.
		player1.movePosition(5);
	//Postconditions
		//Tjekker om han er p� position 2.
		assertEquals(2,player1.getPosition());
		//Tjekker om man har modtaget penge over start.
		assertEquals(9000,player1.account.getScore());
	}
	

}
