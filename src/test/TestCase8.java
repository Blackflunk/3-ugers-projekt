package test;
import control.TurnController;
import boundary.GUIcontroller;
import fields.GameBoard;
import entity.DiceBox;
import entity.Player;

public class TestCase8 {
	
	public static void main(String[] args) {
		Player[] spillerarray = new Player[2];
		spillerarray[0] = new Player("spiller1");
		spillerarray[1] = new Player("spiller2");
		DiceBox dice1 = new DiceBox();
		DiceBox dice2 = new DiceBox();
		DiceBox dice3 = new DiceBox();
		GameBoard board = new GameBoard(dice1);
		GUIcontroller gc = new GUIcontroller();
		TurnController tc = new TurnController(gc, board, dice1, spillerarray); 
		
		dice1.setDice(0, 5);
		dice1.setDice(1, 5);
		dice2.setDice(0, 4);
		dice2.setDice(1, 4);
		dice3.setDice(0, 6);
		dice3.setDice(1, 6);
		
		tc.runNormaltestTurn(spillerarray, 0, dice1, dice2, dice3);
		
		if (spillerarray[0].isJailed())
			System.out.println("ok");
	}

}
