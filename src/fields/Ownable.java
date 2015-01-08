package fields;

import game.Player;

public abstract class Ownable extends Fields {
	
	protected Player owner;
	protected int price;
	protected int pansat;

	public Ownable(String name, int price, int pansat) {
		super(name);
		this.price = price;
		this.pansat = pansat;
	}	
	
	@Override
	public abstract void landOnField(Player player);
	
	@Override
	public abstract String toString();
	
	public void setOwner (Player player) {
		owner = player;
	}
	public Player getOwner() {
		return owner;
	}
	public int getPrice() {
		return price;
	}
}
