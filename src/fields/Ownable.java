package fields;

import game.Player;

public abstract class Ownable extends Fields {
	
	private Player owner;
	private String name;
	private int price;
	private int pansat;

	public Ownable(String name, int price, int pansat) {
		this.name = name;
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
}
