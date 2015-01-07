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
		
}