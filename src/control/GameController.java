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
	private boolean khan = true;
	private boolean build;
	private String possibleBuild;
	private boolean won = false;
	private DiceBox box = new DiceBox();
	private GameBoard gameboard = new GameBoard(box);
	private Deck deck = new Deck(playerlist, gameboard);
	private GUIcontroller GUIC = new GUIcontroller();
	private DeckController DC = new DeckController(deck, GUIC, playerlist, gameboard);
	private TurnController TurnC = new TurnController(GUIC, gameboard, box, playerlist);
	private int lostCount = 0;
	
	public static void main(String[] args) {
		GameController game = new GameController();
		game.run();
		/** 
		 * To do list
		 * lav binding i køb af felter (ingen gui kontakt i ownable)
		 * pansetning (måske)
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
				checkOwnedFields();
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
		if(playerlist[currentPlayer].getFieldammount_blue() == 2){
			playerlist[currentPlayer].setBuy_Blue(khan);
		}
	}
	
	public void checkPink(){
		if(playerlist[currentPlayer].getFieldammount_pink() == 3){
			playerlist[currentPlayer].setBuy_Pink(khan);
		}
	}
	
	public void checkGreen(){
		if(playerlist[currentPlayer].getFieldammount_green() == 3){
			playerlist[currentPlayer].setBuy_Green(khan);
		}
	}
	
	public void checkGrey(){
		if(playerlist[currentPlayer].getFieldammount_grey() == 3){
			playerlist[currentPlayer].setBuy_grey(khan);
		}
	}
	
	public void checkRed(){
		if(playerlist[currentPlayer].getFieldammount_red() == 3){
			playerlist[currentPlayer].setBuy_Red(khan);
		}
	}
	
	public void checkWhite(){
		if(playerlist[currentPlayer].getFieldammount_white() == 3){
			playerlist[currentPlayer].setBuy_White(khan);
		}
	}
	
	public void checkYellow(){
		if(playerlist[currentPlayer].getFieldammount_yellow() == 3){
			playerlist[currentPlayer].setBuy_Yellow(khan);
		}
	}
	
	public void checkMagneta(){
		if(playerlist[currentPlayer].getFieldammount_magenta() == 2){
			playerlist[currentPlayer].setBuy_Magenta(khan);
		}
	}
	
	public boolean getBuild(int n){
		if(n == 1){
			return playerlist[currentPlayer].getBuy_Blue();
		}
		else if(n == 2){
			return playerlist[currentPlayer].getBuy_Pink();
		}
		else if(n == 3){
			return playerlist[currentPlayer].getBuy_Green();
		}
		else if(n == 4){
			return playerlist[currentPlayer].getBuy_grey();
		}
		else if(n == 5){
			return playerlist[currentPlayer].getBuy_Red();
		}
		else if(n == 6){
			return playerlist[currentPlayer].getBuy_White();
		}
		else if(n == 7){
			return playerlist[currentPlayer].getBuy_Yellow();
		}
		else if(n == 8){
			return playerlist[currentPlayer].getBuy_Magenta();
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