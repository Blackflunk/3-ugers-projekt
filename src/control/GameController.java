package control;

import entity.DiceBox;
import entity.Player;
import fields.GameBoard;
import boundary.GUIController;

public class GameController {

	private int currentPlayer = 0;
	private int playerAmmount = 0;
	private boolean onwards = false;
	private Player[] playerlist;
	private boolean won = false;
	private DiceBox box = new DiceBox();
	private GameBoard gameboard = new GameBoard(box);
	private GUIController GUIC = new GUIController();
	private TurnController TurnC;
	private int lostCount = 0;
	private int mode;
	
	public GameController(int mode) {
		this.mode = mode;
	}
	
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
		if (mode==1) {
			playerAmmount = GUIC.playerAmount();
			if(playerAmmount<7  && playerAmmount>2)
				onwards=true;
			else
				GUIC.playerAmountError();
		}
		// Accepts 2 players in gamemode 2
		else if (mode==2) {
			playerAmmount = GUIC.playerAmountshowcase();
			if (playerAmmount<7  && playerAmmount>1)
				onwards=true;
			else
				GUIC.playerAmountError();
		}}
		playerlist = new Player[playerAmmount];
		GUIC.createPlayers(playerAmmount, playerlist);
		// Creates Controllers dependent on playerlist
		TurnC = new TurnController(GUIC, gameboard, playerlist, mode);
	}

	public void runGame() {
		// The game continues as long as won equals false
		while (!won) {
			if (!playerlist[currentPlayer].getStatus()) {
				// Runs turn for current Player
				TurnC.runTurn(currentPlayer);				
				GUIC.newPosition(playerlist[currentPlayer]);				
				// If a player has lost, adds one to lostCount and reset the players owned fields
				if (playerlist[currentPlayer].getStatus()) {
					GUIC.removePlayer(playerlist, currentPlayer);
					
					gameboard.resetOwnedFields(playerlist[currentPlayer]);
					lostCount++;
					
					// If only one player is left, won is set to true
					if (lostCount == playerAmmount - 1) {
						won = true;
						GUIC.showWin(playerlist, playerAmmount);
					}	
				}	
			}
			// Changes player
			changePlayer();
		}
	}
	// Method that changes turn
	public void changePlayer() {
		if (currentPlayer == playerAmmount - 1) {
			currentPlayer = 0;
		} else {
			currentPlayer++;
		}
	}
	public void showWinner() {
		GUIC.showWin(playerlist, playerlist.length);
	}
	
}

		