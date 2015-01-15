package control;

import entity.DiceBox;
import entity.Player;
import fields.GameBoard;
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
	private GUIcontroller GUIC = new GUIcontroller();
	private TurnController TurnC;
	private int lostCount = 0;
	
	public void init() {
		setupGame();
		runGame();
		showWinner();
	}
	
	public void setupGame() {
		System.out.println(gameboard.toString());
		GUIC.createField();
		
		// Takes a chosen number and creates that amount of players
		while(!onwards){
		playerAmount = GUIC.playerAmount();
		if(playerAmount<7  && playerAmount>2){
			onwards=true;
		}else
			GUIC.playerAmountError();
		}
		playerlist = new Player[playerAmount];
		GUIC.createPlayers(playerAmount, playerlist);
		// Creates Controllers dependent on playerlist
		TurnC = new TurnController(GUIC, gameboard, playerlist);
	}

	public void runGame() {
		// The game continues as long as won equals false
		while (!won) {
			if (!playerlist[currentPlayer].getStatus()) {
				// If Player is jailed
				TurnC.runTurn(playerlist, currentPlayer);
				
				// Controls for further funktions on the field
				GUIC.newPositon(playerlist[currentPlayer]);
				
				// If a player has lost, adds one to lostCount and reset the players owned fields
				/** 
				 * skal laves i FieldController
				 */
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
	public void showWinner() {
		GUIC.showWin(playerlist, playerlist.length);
	}
	
}

		