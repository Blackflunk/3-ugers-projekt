//********************************************************************
//  Fields.java       Authors: Group 57
//
//  A class to hold field text and points for CDIO part 2
//********************************************************************

package fields;

import game.Player;

public abstract class Fields {
	protected String name;
	
	public Fields(String name) {
		this.name = name;
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
	
	public void setNumberofHouses(int numberofhouses){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isBuyfield() {
		return false;
	}
	public void setBuyfield(boolean buyfield) {
		
	}
	public int getRent(int rentnumber) {
		return 0;
	}
		
}
