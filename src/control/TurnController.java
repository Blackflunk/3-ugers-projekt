package control;

import boundary.GUIController;
import entity.DiceBox;
import entity.Player;
import fields.GameBoard;

public class TurnController {
	private GUIController GUIC;
	private GameBoard board;
	private DiceBox box = new DiceBox();
	private Player[] playerlist;
	private FieldController FC;
	private HouseController houseC;
	String choiceofTurn;
	private int mode;
	
	// for testing only
	private int k = 0;
	
	public TurnController(GUIController GUIC, GameBoard board, Player[] playerlist, int mode) {
		this.GUIC = GUIC;
		this.board = board;
		this.playerlist = playerlist;
		this.mode = mode;
		FC = new FieldController(GUIC, board, playerlist);
		houseC = new HouseController(GUIC, board, playerlist);
	}
	
	//lav en for l�kke s� den updater v�rd tur
	public void runTurn(int currentPlayer) {
		if (playerlist[currentPlayer].isJailed())
			runJailTurn(currentPlayer);
		else
			runNormalTurn(currentPlayer);
	}
	
	public void runJailTurn(int currentPlayer){
		// If player has a getoutofjailcard
		if (playerlist[currentPlayer].hasOutofjailcard()) {
			exitCard(currentPlayer);
			runNormalTurn(currentPlayer);
		}
		// If player pays for exit
		else if (GUIC.jailOptions(playerlist[currentPlayer])) {
			exitPay(currentPlayer);
			runNormalTurn(currentPlayer);
		}
		// If player wants to throw the dice for exit
		else 
			exitThrow(currentPlayer);
	}
	
	// Standard tur
	public void runNormalTurn(int currentPlayer) {
		int count = 0;
		boolean run = true;
		choiceofTurn = GUIC.startOfTurn(playerlist, currentPlayer);

		if(choiceofTurn.equals("Koeb hus")){
			houseC.checkOwnedFields(currentPlayer);
			if(playerlist[currentPlayer].getBuy_Blue()== true||playerlist[currentPlayer].getBuy_Pink()== true||playerlist[currentPlayer].getBuy_Green()== true
					||playerlist[currentPlayer].getBuy_grey()== true||playerlist[currentPlayer].getBuy_Red()== true||playerlist[currentPlayer].getBuy_White() == true
					||playerlist[currentPlayer].getBuy_Yellow()== true||playerlist[currentPlayer].getBuy_Magenta()== true){
			houseC.buyHouse(currentPlayer);
			}
			
		}else if(choiceofTurn.equals("Saelg hus")){
			
			String sellHouse;
			boolean sellMore = true;
			String[] ar = houseC.checkIfPossibleSell(currentPlayer, board);
			System.out.println(ar.toString());
			if(ar.length == 0){
				GUIC.noHouseToSell();
				sellMore = false;
			}
			if(ar.length > 0){
				while(sellMore == true){	
					if(ar.length > 0){
						sellHouse = GUIC.offerToSellHouse(houseC.checkFieldsWithHouses(currentPlayer, board));
						if(houseC.checkIfPossibleSell(currentPlayer, board).length == 0){
							sellMore = false;
						}else{
						houseC.sellHouse(currentPlayer, board, sellHouse);
						sellMore = GUIC.offerToMoreSellHouses();
						}
					}
				}
			}
		}else if(choiceofTurn.equals("Saelg grund")){
			
		}
		
		while(run){
		if(count==0)
		GUIC.nextPlayer(playerlist, currentPlayer);
		else if (count==2)
		GUIC.twoPair();
		else
		GUIC.onePair();
		if (mode==1){
		box.rollDice();
		GUIC.showDice(box.getDice1(), box.getDice2());
		} else if (mode==2) {
			box.setDice(0, 1);
			box.setDice(1, 0);
			GUIC.showDice(box.getDice1(), 1);
		}
			
		if(box.getSum() + playerlist[currentPlayer].getPosition() >= 40)
			GUIC.pastStart();
		if (count !=3) {
		GUIC.updatePosition(playerlist, currentPlayer, box.getSum());
		FC.landOnField(currentPlayer);
		}
		if (box.isEqual()){
			count ++;
		} else
			run = false;
		if (count>=3){
			run = false;
			playerlist[currentPlayer].setJailed(true);
			playerlist[currentPlayer].setPosition(10);
			GUIC.threePair();
			GUIC.newPositon(playerlist[currentPlayer]);
		}
		}
		}
	
	// Tur, efter exit fra jail
	public void afterJailTurn(int currentPlayer) {
		GUIC.afterJail();
		GUIC.newPositon(playerlist[currentPlayer]);
		FC.landOnField(currentPlayer);
	}
	
	
	// runtypes in runJailTurn()
	public void exitCard(int currentPlayer) {
		playerlist[currentPlayer].setJailed(false);
		playerlist[currentPlayer].setJailcount(0);
	}
	
	public void exitPay(int currentPlayer) {
		playerlist[currentPlayer].account.addPoints(-1000);
		playerlist[currentPlayer].setJailed(false);
		playerlist[currentPlayer].setJailcount(0);
	}
	public void exitThrow(int currentPlayer) {
		if (playerlist[currentPlayer].getJailcount() < 3) {
			for (int i=1; i<=3; i++) {
			box.rollDice();
			GUIC.showDice(box.getDice1(), box.getDice2());
			if (box.isEqual()){
				playerlist[currentPlayer].movePosition(box.getSum());
				board.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
				playerlist[currentPlayer].setJailed(false);
				playerlist[currentPlayer].setJailcount(0);
				afterJailTurn(currentPlayer);
				break;
			}
			}
			// If the player didn't get out
			if (playerlist[currentPlayer].isJailed())
				playerlist[currentPlayer].addJailcount();
			}
			// If the playerlist[currentPlayer] tried exitting 3 times (forced pay) 
			if (playerlist[currentPlayer].getJailcount() == 3) {
				GUIC.showMessage("Du har pr�vet at komme ud af f�ngslet 3 gange, uden held - du betaler 1000kr for at komme ud"
						+ " du f�r ikke lov til at rykke denne tur");
				playerlist[currentPlayer].account.addPoints(-1000);
				playerlist[currentPlayer].setJailed(false);
				playerlist[currentPlayer].setJailcount(0);
	}
	}
	// For testing only
	// No GUI, Controlable dicebox
	public void exitThrowTest(int currentPlayer, DiceBox testbox) {
		if (playerlist[currentPlayer].getJailcount() < 3) {
			if (testbox.isEqual()){
				playerlist[currentPlayer].movePosition(testbox.getSum());
				playerlist[currentPlayer].setJailed(false);
				playerlist[currentPlayer].setJailcount(0);
			}
			else
				k++;
			// If the player didn't get out
			if (k>=3) {
				if (playerlist[currentPlayer].isJailed()) {
					playerlist[currentPlayer].addJailcount();
					k=0;
				}
			// If the player tried exitting 3 times (forced pay) 
					if (playerlist[currentPlayer].getJailcount() == 3) {
						playerlist[currentPlayer].account.addPoints(-1000);
						playerlist[currentPlayer].setJailed(false);
						playerlist[currentPlayer].setJailcount(0);
			}
			}
	}
	}
	// For testing only
	public void runNormaltestTurn(int currentPlayer, 
			DiceBox box1, DiceBox box2, DiceBox box3) {
		int count = 0;
		boolean run = true;
		while(run){
		if(count==0)
		GUIC.nextPlayer(playerlist, currentPlayer);
		else if (count==2)
		GUIC.twoPair();
		else
		GUIC.onePair();;
		
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
		
		FC.landOnField(currentPlayer);
		if (box.isEqual()){
			count ++;
		} else
			run = false;
		if (count>=3){
			run = false;
			playerlist[currentPlayer].setJailed(true);
			playerlist[currentPlayer].setPosition(10);
			GUIC.threePair();;
			GUIC.newPositon(playerlist[currentPlayer]);
		}
		}
		}
}
