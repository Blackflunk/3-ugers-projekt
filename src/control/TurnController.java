package control;

import boundary.GUIcontroller;
import fields.GameBoard;
import game.Player;
import game.DiceBox;

public class TurnController {
	private GUIcontroller GUIC;
	private GameBoard board;
	private DiceBox box;
	private Player[] playerlist;
	private FieldController FC;
	// for testing only
	private int k = 0;
	
	public TurnController(GUIcontroller GUIC, GameBoard board, DiceBox box, Player[] playerlist) {
		this.GUIC = GUIC;
		this.board = board;
		this.box = box;
		this.playerlist = playerlist;
		FC = new FieldController(GUIC, board, box, playerlist);
	}
	
	//lav en for løkke så den updater værd tur
	public void runTurn(Player[] playerlist, int currentPlayer) {
		GUIC.updateBalance(playerlist[0].getName(), playerlist[0].account.getScore());
		GUIC.updateBalance(playerlist[1].getName(), playerlist[1].account.getScore());
		GUIC.updateBalance(playerlist[2].getName(), playerlist[2].account.getScore());
		if (playerlist[currentPlayer].isJailed())
			runJailTurn(playerlist, currentPlayer);
		else
			runNormalTurn(playerlist, currentPlayer);
	}
	
	public void runJailTurn(Player[] playerlist, int currentPlayer){
		// If player has a getoutofjailcard
		if (playerlist[currentPlayer].hasOutofjailcard()) {
			exitCard(playerlist[currentPlayer], currentPlayer);
			runNormalTurn(playerlist, currentPlayer);
		}
		// If player pays for exit
		else if (GUIC.jailOptions(playerlist[currentPlayer])) {
			exitPay(playerlist[currentPlayer], currentPlayer);
			runNormalTurn(playerlist, currentPlayer);
		}
		// If player wants to throw the dice for exit
		else 
			exitThrow(playerlist, currentPlayer);
	}
	
	// Standard tur
	public void runNormalTurn(Player[] playerlist, int currentPlayer) {
		GUIC.nextPlayer(playerlist, currentPlayer);
		box.rollDice();
		GUIC.showDice(box.getDice1(), box.getDice2());
		GUIC.updatePosition(playerlist, currentPlayer, box.getSum());
		FC.landOnField(playerlist, currentPlayer);
	}
	
	// Tur, efter exit fra jail
	public void afterJailTurn(Player[] playerlist, int currentPlayer) {
		GUIC.showMessage("Du forlod fængslet, og rykker summen på terningerne");
		GUIC.updatePosition(playerlist, currentPlayer, box.getSum());
		FC.landOnField(playerlist, currentPlayer);
	}
	
	
	// runtypes in runJailTurn()
	public void exitCard(Player player, int currentPlayer) {
		player.setJailed(false);
		player.setJailcount(0);
	}
	
	public void exitPay(Player player, int currentPlayer) {
		player.account.addPoints(-1000);
		player.setJailed(false);
		player.setJailcount(0);
	}
	public void exitThrow(Player[] playerlist, int currentPlayer) {
		if (playerlist[currentPlayer].getJailcount() < 3) {
			for (int i=1; i<=3; i++) {
			box.rollDice();
			GUIC.showDice(box.getDice1(), box.getDice2());
			if (box.isEqual()){
				playerlist[currentPlayer].movePosition(box.getSum());
				board.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
				playerlist[currentPlayer].setJailed(false);
				playerlist[currentPlayer].setJailcount(0);
				afterJailTurn(playerlist, currentPlayer);
				break;
			}
			}
			// If the player didn't get out
			if (playerlist[currentPlayer].isJailed())
				playerlist[currentPlayer].addJailcount();
			}
			// If the playerlist[currentPlayer] tried exitting 3 times (forced pay) 
			if (playerlist[currentPlayer].getJailcount() == 3) {
				GUIC.showMessage("Du har prøvet at komme ud af fængslet 3 gange, uden held - du betaler 1000kr for at komme ud"
						+ " du får ikke lov til at rykke denne tur");
				playerlist[currentPlayer].account.addPoints(-1000);
				playerlist[currentPlayer].setJailed(false);
				playerlist[currentPlayer].setJailcount(0);
	}
	}
	// For testing only
	// No GUI, Controlable dicebox
	public void exitThrowTest(Player player, int currentPlayer, DiceBox testbox) {
		if (player.getJailcount() < 3) {
			if (testbox.isEqual()){
				player.movePosition(testbox.getSum());
				player.setJailed(false);
				player.setJailcount(0);
			}
			else
				k++;
			// If the player didn't get out
			if (k>=3) {
				if (player.isJailed()) {
					player.addJailcount();
					k=0;
				}
			// If the player tried exitting 3 times (forced pay) 
					if (player.getJailcount() == 3) {
						player.account.addPoints(-1000);
						player.setJailed(false);
						player.setJailcount(0);
			}
			}
	}
		
	
	}
}
