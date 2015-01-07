package test;

import game.Dice;

public class TestCase3 {

	public TestCase3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		//Preconditions
		Dice dice = new Dice();
		int WrongThrow = 0;
		
		//Test
		for (int i = 0; i < 100; i++){
		dice.throwDice();
		if (dice.getSum() < 1 || dice.getSum() > 12){
			WrongThrow++;
			}
		}
		//Postconditions
		if (WrongThrow == 0)
			System.out.println("Postcondition 1: OK");
		else
			System.out.println("Postcondition 1: Fejl");
	}

}