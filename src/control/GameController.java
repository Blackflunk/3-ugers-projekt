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

	int currentPlayer = 0;
	int playerAmount = 0;
	boolean onwards = false;
	Player[] player;
	boolean khan = true;
	boolean build;
	String possibleBuild;
	public static void main(String[] args) {
		GameController game = new GameController();
		game.run();

	}

	public void run() {

		boolean won = false;
		DiceBox box = new DiceBox();
		GameBoard gameboard = new GameBoard(box);
		Deck deck = new Deck(player, gameboard);
		GUIcontroller out = new GUIcontroller();
		DeckController DC = new DeckController(deck, out, player, gameboard);
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
				checkOwnedFields();
				//if(player[currentPlayer].getBuy_Blue()||player[])
				out.nextPlayer(player, currentPlayer);
				box.rollDice();
				out.showDice(box.getDice1(), box.getDice2());
				out.updatePosition(player, currentPlayer, box.getSum());
		
				// Execute landOnField for the players new position
				gameboard.getField(player[currentPlayer].getPosition()).landOnField(player[currentPlayer]);
				
				if (player[currentPlayer].getPosition()==2 ||
					player[currentPlayer].getPosition()==7 ||
					player[currentPlayer].getPosition()== 17 ||
					player[currentPlayer].getPosition()== 22 ||
					player[currentPlayer].getPosition()==33 ||
					player[currentPlayer].getPosition()==36) {
						DC.drawCard(player[currentPlayer]);
					}
				else if (player[currentPlayer].getPosition()==30) {
					out.newPositon(player[currentPlayer]);
				}
				
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

	public void checkOwnedFields(){
		checkBlue();
		checkPink();
		checkGreen();
		checkGrey();
		checkRed();
		checkWhite();
		checkYellow();
		checkMagneta();
	}
	public void checkBlue(){
		if(player[currentPlayer].getFieldammount_blue() == 2){
			player[currentPlayer].setBuy_Blue(khan);
		}
	}
	
	public void checkPink(){
		if(player[currentPlayer].getFieldammount_pink() == 3){
			player[currentPlayer].setBuy_Pink(khan);
		}
	}
	
	public void checkGreen(){
		if(player[currentPlayer].getFieldammount_green() == 3){
			player[currentPlayer].setBuy_Green(khan);
		}
	}
	
	public void checkGrey(){
		if(player[currentPlayer].getFieldammount_grey() == 3){
			player[currentPlayer].setBuy_grey(khan);
		}
	}
	
	public void checkRed(){
		if(player[currentPlayer].getFieldammount_red() == 3){
			player[currentPlayer].setBuy_Red(khan);
		}
	}
	
	public void checkWhite(){
		if(player[currentPlayer].getFieldammount_white() == 3){
			player[currentPlayer].setBuy_White(khan);
		}
	}
	
	public void checkYellow(){
		if(player[currentPlayer].getFieldammount_yellow() == 3){
			player[currentPlayer].setBuy_Yellow(khan);
		}
	}
	
	public void checkMagneta(){
		if(player[currentPlayer].getFieldammount_magenta() == 2){
			player[currentPlayer].setBuy_Magenta(khan);
		}
	}
	
	public boolean getBuild(int n){
		if(n == 1){
			return player[currentPlayer].getBuy_Blue();
		}
		else if(n == 2){
			return player[currentPlayer].getBuy_Pink();
		}
		else if(n == 3){
			return player[currentPlayer].getBuy_Green();
		}
		else if(n == 4){
			return player[currentPlayer].getBuy_grey();
		}
		else if(n == 5){
			return player[currentPlayer].getBuy_Red();
		}
		else if(n == 6){
			return player[currentPlayer].getBuy_White();
		}
		else if(n == 7){
			return player[currentPlayer].getBuy_Yellow();
		}
		else if(n == 8){
			return player[currentPlayer].getBuy_Magenta();
		}
		return false;
		/*switch(n){
		case 1 : return player[currentPlayer].getBuy_Blue();
		case 2 : return player[currentPlayer].getBuy_Pink();
		case 3 : return player[currentPlayer].getBuy_Green();
		case 4 : return player[currentPlayer].getBuy_grey();
		case 5 : return player[currentPlayer].getBuy_Red();
		case 6 : return player[currentPlayer].getBuy_White();
		case 7 : return player[currentPlayer].getBuy_Yellow();
		case 8 : return player[currentPlayer].getBuy_magenta();
		
		}*/
	}
	
	public void getRoad(int n){
		if(n == 1){
			possibleBuild += " Roedovervej og Hvidovervej";
		}
		else if(n == 2){
			possibleBuild += " Roskildevej, Valby Langgade og Allegade";
		}
		else if(n == 3){
			possibleBuild += " Fredriksberg Alle, Bulowsvej og GL Kongevej";
		}
		else if(n == 4){
			possibleBuild += " Bernstorffsvej, Hellerupvej og Strandvej";
		}
		else if(n == 5){
			possibleBuild += " Trianglen, Oesterbrogade og Groenningen";
		}
		else if(n == 6){
			possibleBuild += " Bredgade, Kgs Nytorv og Istergade";
		}
		else if(n == 7){
			possibleBuild += " Amagertorv, Vimmelskaftet og Nygade";
		}
		else if(n == 8){
			possibleBuild += " Frederiksberggade og Raedhuspladsen";
		}
		
		/*switch(n){
		case 1 : possibleBuild += " Roedovervej og Hvidovervej";
		case 2 : possibleBuild += " Roskildevej, Valby Langgade og Allegade";
		case 3 : possibleBuild += " Fredriksberg Alle, Bulowsvej og GL Kongevej";
		case 4 : possibleBuild += " Bernstorffsvej, Hellerupvej og Strandvej";
		case 5 : possibleBuild += " Trianglen, Oesterbrogade og Groenningen";
		case 6 : possibleBuild += " Bredgade, Kgs Nytorv og Istergade";
		case 7 : possibleBuild += " Amagertorv, Vimmelskaftet og Nygade";
		case 8 : possibleBuild += " Frederiksberggade og Raedhuspladsen";	
		break;
		}	*/
	}
}	