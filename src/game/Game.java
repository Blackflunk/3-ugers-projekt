//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 2 to start and end the game
//********************************************************************

package game;

import javax.swing.JOptionPane;

import boundary.GUIcontroller;

public class Game {

	int currentPlayer = 0;
	int playerAmount = 0;
	boolean onwards = false;
	
	public static void main(String[] args) {
		Game game = new Game();
		game.run();

	}

	public void run() {

		boolean won = false;
		DiceBox dice = new DiceBox();
		GameBoard gameboard = new GameBoard(dice);
		Player[] player;
		GUIcontroller out = new GUIcontroller();
		int lostCount = 0;

		System.out.println(gameboard.toString());
		out.createField();
		
		// Takes a chosen number and creates that amount of players
		
		while(!onwards){
		playerAmount = out.playerAmount();
		if(playerAmount<7  && playerAmount>2){
		onwards=true;
		}else{
			out.playerAmountError();
			}
		}
		player = new Player[playerAmount];
		out.createPlayers(playerAmount, player);
		

		
		// The game continues as long as won equals false
		while (!won) {
			if (!player[currentPlayer].getStatus()) {

				out.nextPlayer(player, currentPlayer);
				dice.rollDice();
				out.showDice(dice.getDice1(), dice.getDice2());
				out.updatePosition(player, currentPlayer, dice.getSum());
		
				// Execute landOnField for the players new position
				gameboard.getField(player[currentPlayer].getPosition()).landOnField(player[currentPlayer]);
				
				// If a player has lost, adds one to lostCount and reset the players owned fields
				if (player[currentPlayer].getStatus()) {
					out.removePlayer(player, currentPlayer);
					
					gameboard.resetOwnedFields(player[currentPlayer]);
					lostCount++;
					
					// If only one player is left, won is set to true
					if (lostCount == playerAmount - 1) {
						won = true;
						out.showWin(player, playerAmount);
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
}