package test;

import game.Account;

public class TestCase2 {

	public TestCase2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		//Preconditions
		Account account = new Account();
		account.addPoints(-29600);
		System.out.println("account: " + account.getScore());
		
		//Test
		account.addPoints(-500);
		
		//Postconditions
		if (account.getScore() == 0)
			System.out.println("Postcondition 1: OK");
		else
			System.out.println("Postcondition 1: Fejl");
	}

}