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
	
	public TurnController(GUIcontroller GUIC, GameBoard board, DiceBox box, Player[] playerlist) {
		this.GUIC = GUIC;
		this.board = board;
		this.box = box;
		this.playerlist = playerlist;
	}
	
	public void runJailTurn(Player player, int currentPlayer){
		// If player has a getoutofjailcard
		if (player.hasOutofjailcard()) {
			player.setJailed(false);
			player.setJailcount(0);
			runTurn(playerlist, currentPlayer);
		}
		// If player pays for exit
		else if (GUIC.jailOptions(player)) {
			player.account.addPoints(-1000);
			player.setJailed(false);
			player.setJailcount(0);
			runTurn(playerlist, currentPlayer);
		}
		// If player wants to throw the dice for exit
		else {
			if (player.getJailcount() < 3) {
			for (int i=1; i<=3; i++) {
			box.rollDice();
			GUIC.showDice(box.getDice1(), box.getDice2());
			if (box.isEqual()){
				player.movePosition(box.getSum());
				board.getField(player.getPosition()).landOnField(player);
				player.setJailed(false);
				player.setJailcount(0);
				afterJailTurn(currentPlayer);
				break;
			}
			}
			// If the player didn't get out
			if (player.isJailed())
				player.addJailcount();
			}
			// If the player tried exitting 3 times (forced pay) 
			if (player.getJailcount() == 3) {
				GUIC.showMessage("Du har prøvet at komme ud af fængslet 3 gange, uden held - du betaler 1000kr for at komme ud"
						+ " du får ikke lov til at rykke denne tur");
				player.account.addPoints(-1000);
				player.setJailed(false);
				player.setJailcount(0);
			}
		}
	}
	
	// Standard tur
	public void runTurn(Player[] playerlist, int currentPlayer) {
		GUIC.nextPlayer(playerlist, currentPlayer);
		box.rollDice();
		GUIC.showDice(box.getDice1(), box.getDice2());
		GUIC.updatePosition(playerlist, currentPlayer, box.getSum());
		board.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
	}
	
	// Tur, efter exit fra jail
	public void afterJailTurn(int currentPlayer) {
		GUIC.showMessage("Du forlod fængslet, og rykker summen på terningerne");
		GUIC.updatePosition(playerlist, currentPlayer, box.getSum());
		board.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
	}
	
	

}
