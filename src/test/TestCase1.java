package test;

import game.Player;
public class TestCase1 {

	public TestCase1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		//Preconditions
		Player player = new Player("Test");
		player.setPosition(18);
		System.out.println("player.getPosition(): " + player.getPosition());
		
		//Test
		player.setPosition(10);
		
		//Postconditions
		if (player.getPosition() == 6)
			System.out.println("Postcondition 1: OK");
		else
			System.out.println("Postcondition 1: Fejl");
	}

}
