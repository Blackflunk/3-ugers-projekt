//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 2 to start and end the game
//********************************************************************

package control;

import javax.swing.JOptionPane;

import fields.GameBoard;
import game.DiceBox;
import game.Player;
import boundary.GUIcontroller;
import deck.Deck;

public class GameController {

	private int currentPlayer = 0;
	private int playerAmount = 0;
	private boolean onwards = false;
	private Player[] playerlist;
	private boolean won = false;
	private DiceBox box = new DiceBox();
	private GameBoard gameboard = new GameBoard(box);
	private Deck deck = new Deck(playerlist, gameboard);
	private GUIcontroller GUIC = new GUIcontroller();
	private DeckController DC = new DeckController(deck, GUIC, playerlist, gameboard);
	private TurnController TurnC = new TurnController(GUIC, gameboard, box, playerlist);
	private HouseController houseC = new HouseController(GUIC, gameboard, playerlist);
	private int lostCount = 0;
	
	public static void main(String[] args) {
		GameController game = new GameController();
		game.run();
		/** 
		 * To do list
		 * BUG FIXING!!!!
		 * lav binding i køb af felter (ingen gui kontakt i ownable)
		 * pansetning (måske)
		 * Skal stadig havet fikset huset
		 * 
		 */

	}

	public void run() {
		System.out.println(gameboard.toString());
		GUIC.createField();
		
		// Takes a chosen number and creates that amount of players
		while(!onwards){
		playerAmount = GUIC.playerAmount();
		if(playerAmount<7  && playerAmount>2){
		onwards=true;
		}else{
			GUIC.playerAmountError();
			}
		}
		playerlist = new Player[playerAmount];
		GUIC.createPlayers(playerAmount, playerlist);
		

		
		// The game continues as long as won equals false
		while (!won) {
			if (!playerlist[currentPlayer].getStatus()) {
				houseC.checkOwnedFields(playerlist[currentPlayer]);
				houseC.Housing(playerlist[currentPlayer],currentPlayer);
				// If Player is jailed
				if (playerlist[currentPlayer].isJailed())
					TurnC.runJailTurn(playerlist[currentPlayer], currentPlayer);
				// Normal Turn
				else
					TurnC.runTurn(playerlist, currentPlayer);
		
				// Execute landOnField for the players new position
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
				// Controls for further funktions on the field
				controlFieldType();
				
				// If a player has lost, adds one to lostCount and reset the players owned fields
				if (playerlist[currentPlayer].getStatus()) {
					GUIC.removePlayer(playerlist, currentPlayer);
					
					gameboard.resetOwnedFields(playerlist[currentPlayer]);
					lostCount++;
					
					// If only one player is left, won is set to true
					if (lostCount == playerAmount - 1) {
						won = true;
						GUIC.showWin(playerlist, playerAmount);
					}	
				}	
			}
			// Changes player
			changePlayer();
		}
	}
	// Method that changes turn
	public void changePlayer() {
		if (currentPlayer == playerAmount - 1) {
			currentPlayer = 0;
		} else {
			currentPlayer++;
		}
	}
	
	public void controlFieldType(){
		if (playerlist[currentPlayer].getPosition()==2 ||
				playerlist[currentPlayer].getPosition()==7 ||
				playerlist[currentPlayer].getPosition()== 17 ||
				playerlist[currentPlayer].getPosition()== 22 ||
				playerlist[currentPlayer].getPosition()==33 ||
				playerlist[currentPlayer].getPosition()==36) {
					DC.drawCard(playerlist[currentPlayer]);
				}
			else if (playerlist[currentPlayer].getPosition()==30) {
				GUIC.newPositon(playerlist[currentPlayer]);
			}
	}

	
}	