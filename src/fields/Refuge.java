package fields;

import entity.Player;


public class Refuge extends Field {
	
private int bonus;
	
	public Refuge(String name, int bonus) {
		super(name);
		this.bonus = bonus;
		this.name = name;
	}
	@Override
	public void landOnField(Player player) {
			player.account.addPoints(bonus);
	}
	@Override
	public int getRent(int t) {
		return bonus;
	}
	@Override
	public String toString() {
		return "Type: Refuge --- Name: " + name + " --- Bonus: " + bonus + "\n";
	}

}
