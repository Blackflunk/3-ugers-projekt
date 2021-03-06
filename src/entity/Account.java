package entity;

public class Account {
	private int balance;

	// Object that stores the score of the two players
	public Account() {
		balance = 30000;
	}

	// Public get method to get the score of chosen player
	public int getScore() {
		return balance;
	}
	
	// Public set method to set the score of a chosen player
	public void setScore(int balance){
		this.balance = balance;
	}
	
	// Public method to add points to chosen player
	public boolean addPoints(int points) {

		if (balance + points >= 0) {
			balance += points;
			return true;
		} else {
			balance = 0;
			return false;
		}
	}
}
