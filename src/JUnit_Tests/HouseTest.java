package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import boundary.GUIcontroller;
import control.HouseController;
import deck.Deck;
import fields.GameBoard;
import game.DiceBox;
import game.Player;

public class HouseTest {

		@Test
		public void HouseTest(){
		//Preconditions
			DiceBox box = new DiceBox();
			GameBoard board = new GameBoard(box);
			Player[] players = new Player[3];
			GUIcontroller GUIC = new GUIcontroller();
			HouseController HC = new HouseController(GUIC, board, players);
			
			players[0] = new Player("Spiller1");
			players[1] = new Player("Spiller2");
			players[2] = new Player("Spiller3");
			Deck deck = new Deck(players, board);
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
			
		// Test
			HC.checkOwnedFields(players[0]);
			HC.Housing(players[0], 0);
			
		// Postconditions
			assertEquals(3,players[0].getFieldammount_green());
			assertEquals(15200, players[0].account.getScore());
		}
		
//		@Test
//		public void multipleHouses(){
//			//Preconditions
//			DiceBox box = new DiceBox();
//			GameBoard board = new GameBoard(box);
//			Player[] players = new Player[3];
//			GUIcontroller GUIC = new GUIcontroller();
//			HouseController HC = new HouseController(GUIC, board, players);
//			
//			players[0] = new Player("Spiller1");
//			players[1] = new Player("Spiller2");
//			players[2] = new Player("Spiller3");
//			Deck deck = new Deck(players, board);
//		// Preconditions
//			players[0].setPosition(11);
//			board.getField(11).setBuyfield(true);
//			board.getField(players[0].getPosition()).landOnField(players[0]);
//			players[0].setPosition(13);
//			board.getField(13).setBuyfield(true);
//			board.getField(players[0].getPosition()).landOnField(players[0]);
//			players[0].setPosition(14);
//			board.getField(14).setBuyfield(true);
//			board.getField(players[0].getPosition()).landOnField(players[0]);
//			assertEquals(21200, players[0].account.getScore());
//			
//		// Test
//			HC.checkOwnedFields(players[0]);
//			HC.Housing(players[0], 0);
//			HC.Housing(players[0], 0);
//			
//		// Postconditions
//			assertEquals(3,players[0].getFieldammount_green());
//			assertEquals(9200, players[0].account.getScore());
//		}
//		
//		@Test
//		public void multipleHouses2(){
//			//Preconditions
//			DiceBox box = new DiceBox();
//			GameBoard board = new GameBoard(box);
//			Player[] players = new Player[3];
//			GUIcontroller GUIC = new GUIcontroller();
//			HouseController HC = new HouseController(GUIC, board, players);
//			
//			players[0] = new Player("Spiller1");
//			players[1] = new Player("Spiller2");
//			players[2] = new Player("Spiller3");
//			Deck deck = new Deck(players, board);
//		// Preconditions
//			players[0].setPosition(11);
//			board.getField(11).setBuyfield(true);
//			board.getField(players[0].getPosition()).landOnField(players[0]);
//			players[0].setPosition(13);
//			board.getField(13).setBuyfield(true);
//			board.getField(players[0].getPosition()).landOnField(players[0]);
//			players[0].setPosition(14);
//			board.getField(14).setBuyfield(true);
//			board.getField(players[0].getPosition()).landOnField(players[0]);
//			assertEquals(21200, players[0].account.getScore());
//			
//		// Test
//			HC.checkOwnedFields(players[0]);
//			HC.Housing(players[0], 0);
//			HC.Housing(players[0], 0);
//			HC.Housing(players[0], 0);
//			HC.Housing(players[0], 0);
//			
//		// Postconditions
//			assertEquals(3,players[0].getFieldammount_green());
//			assertEquals(9200, players[0].account.getScore());
//		}
}

