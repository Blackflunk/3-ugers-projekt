package test;

import game.GameBoard;
import game.Player;
import fields.*;

public class TestCase4 {

	public TestCase4() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Player player = new Player("Player 1");
		GameBoard gameboard = new GameBoard(null);

		// Preconditions
		((Ownable) gameboard.getField(1)).setOwner(player);
		System.out.println("gameboard.getField(1).getOwner().getName: "
				+ ((Ownable) gameboard.getField(1)).getOwner().getName());
		((Ownable) gameboard.getField(16)).setOwner(player);
		System.out.println("gameboard.getField(16).getOwner().getName: "
				+ ((Ownable) gameboard.getField(16)).getOwner().getName());
		((Ownable) gameboard.getField(18)).setOwner(player);
		System.out.println("gameboard.getField(18).getOwner().getName: "
				+ ((Ownable) gameboard.getField(18)).getOwner().getName());

		// Test
		System.out.println("gameboard.resetOwnedFields(player 1)");
		gameboard.resetOwnedFields(player);

		// Postconditions
		if (((Ownable) gameboard.getField(1)).getOwner() == null)
			System.out.println("Postcondition 1: OK");
		else
			System.out.println("Postcondition 1: Fejl");
		if (((Ownable) gameboard.getField(16)).getOwner() == null)
			System.out.println("Postcondition 2: OK");
		else
			System.out.println("Postcondition 2: Fejl");
		if (((Ownable) gameboard.getField(18)).getOwner() == null)
			System.out.println("Postcondition 3: OK");
		else
			System.out.println("Postcondition 3: Fejl");
	}

}
