//********************************************************************
//  Player.java       Authors: Group 57
//
//  A class to hold information and methods regarding the player in CDIO part 3
//********************************************************************

package game;

public class Player {
	private String name;
	private int position, fleets, laborCamp;
	private boolean lost;
	public Account account = new Account();

	// Object that stores the name and position of a player
	public Player(String name) {
		position = 0;
		fleets = 0;
		laborCamp = 0;
		lost = false;
		this.name = name;
	}

	// Method that returns the name of the player
	public String getName() {
		return name;
	}

	// Method that sets the position of the player
	public void setPosition(int roll) {
		if (position + roll > 21) {
			position = position + roll - 22;
		} else {
			position += roll;
		}
	}
	// Method that returns the position of the player
	public int getPosition() {
		return position;
	}
	// Adds a fleet to the players owned fleets
	public void setFleets() {
		fleets++;
	}
	// Returns the number of the players owned fleets
	public int getFleets() {
		return fleets;
	}
	public void setLaborCamp(){
		laborCamp++;
	}
	public int getLaborCamp(){
		return laborCamp;
	}
	public void setStatus() {
		lost = true;
	}
	public boolean getStatus() {
		return lost;
	}
	
}
