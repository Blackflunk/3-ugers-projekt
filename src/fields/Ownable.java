package fields;

import entity.Player;

public abstract class Ownable extends Field {
	
	protected Player owner;
	protected int price;
	protected int pansat;
	protected boolean buyfield = false;

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
	
	@Override
	public boolean isBuyfield() {
		return buyfield;
	}
	
	@Override
	public void setBuyfield(boolean buyfield) {
		this.buyfield = buyfield;
	}
}
