//********************************************************************
//  Fields.java       Authors: Group 57
//
//  A class to hold field text and points for CDIO part 2
//********************************************************************

package fields;

import game.Player;

public abstract class Fields {

	
	public Fields() {
	
	}
	public abstract void landOnField(Player player);
	
	public abstract String toString();
	
	public Player getOwner() {
		return null;
	}
	public int getPrice() {
		return 0;
	}
	public int getHouseprice() {
		return 0;
	}
	public int getNumberofhouses() {
		return 0;
	}
		
}