
package fields;

import entity.Player;

public abstract class Field {
	protected String name;
	
	public Field(String name) {
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
	public boolean isOption() {
		return false;
	}
	public boolean isPaypercent() {
		return false;
	}
	public void setPaypercent(boolean paypercent) {
		}
	public boolean checkPayDoubleRent(Player player){
		return false;
	}
	public void addNumberofHouses(int add){	
	}
	public int getNetworth(){
		return 0;
	}
	public void setNetworth(int networth){
		
	}
		
}
