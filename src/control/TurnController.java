package control;

import boundary.GUIcontroller;
import entity.DiceBox;
import entity.Player;
import fields.GameBoard;

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
	
	//lav en for lï¿½kke sï¿½ den updater vï¿½rd tur
	public void runTurn(Player[] playerlist, int currentPlayer) {
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
		int count = 0;
		boolean run = true;
		while(run){
		if(count==0)
		GUIC.nextPlayer(playerlist, currentPlayer);
		else if (count==2)
		GUIC.showMessage("Tryk for at slå igen, hvis du slår to ens igen ryger du i fængsel");
		else
		GUIC.showMessage("Tryk for at slå igen");
		
		box.rollDice();
		GUIC.showDice(box.getDice1(), box.getDice2());
		if (count !=3) {
		GUIC.updatePosition(playerlist, currentPlayer, box.getSum());
		FC.landOnField(playerlist, currentPlayer);
		}
		if (box.isEqual()){
			count ++;
		} else
			run = false;
		if (count>=3){
			run = false;
			playerlist[currentPlayer].setJailed(true);
			playerlist[currentPlayer].setPosition(10);
			GUIC.showMessage("Du har slået 3 par i træk, du ryger i fængsel");
			GUIC.newPositon(playerlist[currentPlayer]);
		}
		}
		}
	
	// Tur, efter exit fra jail
	public void afterJailTurn(Player[] playerlist, int currentPlayer) {
		GUIC.showMessage("Du forlod fï¿½ngslet, og rykker summen pï¿½ terningerne");
		GUIC.newPositon(playerlist[currentPlayer]);
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
			/**
			 * indsÃ¦t GUI slag
			 */
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
				GUIC.showMessage("Du har prï¿½vet at komme ud af fï¿½ngslet 3 gange, uden held - du betaler 1000kr for at komme ud"
						+ " du fï¿½r ikke lov til at rykke denne tur");
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
	// For testing only
	public void runNormaltestTurn(Player[] playerlist, int currentPlayer, 
			DiceBox box1, DiceBox box2, DiceBox box3) {
		int count = 0;
		boolean run = true;
		while(run){
		if(count==0)
		GUIC.nextPlayer(playerlist, currentPlayer);
		else if (count==2)
		GUIC.showMessage("Tryk for at slå igen, hvis du slår to ens igen ryger du i fængsel");
		else
		GUIC.showMessage("Tryk for at slå igen");
		
		if (count==0) {
		GUIC.showDice(box1.getDice1(), box1.getDice2());
		GUIC.updatePosition(playerlist, currentPlayer, box1.getSum());
		} else if (count==1) {
		GUIC.showDice(box2.getDice1(), box2.getDice2());
		GUIC.updatePosition(playerlist, currentPlayer, box2.getSum());
		} else {
		GUIC.showDice(box3.getDice1(), box3.getDice2());
		GUIC.updatePosition(playerlist, currentPlayer, box3.getSum());
		}
		
		FC.landOnField(playerlist, currentPlayer);
		if (box.isEqual()){
			count ++;
		} else
			run = false;
		if (count>=3){
			run = false;
			playerlist[currentPlayer].setJailed(true);
			playerlist[currentPlayer].setPosition(10);
			GUIC.showMessage("Du har slået 3 par i træk, du ryger i fængsel");
			GUIC.newPositon(playerlist[currentPlayer]);
		}
		}
		}
}
