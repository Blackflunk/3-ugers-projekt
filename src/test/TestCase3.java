package test;

import entity.DiceBox;

public class TestCase3 {

	public TestCase3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		//Preconditions
		DiceBox box = new DiceBox();
		int WrongThrow = 0;
		
		//Test
		for (int i = 0; i < 100; i++){
		box.rollDice();
		if (box.getSum() < 1 || box.getSum() > 12){
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