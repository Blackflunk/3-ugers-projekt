package fields;

import boundary.GUIcontroller;
import game.Player;


public class Refuge extends Fields {
	
private int bonus;
private GUIcontroller out = new GUIcontroller();
	
	public Refuge(String name, int bonus) {
		super(name);
		this.bonus = bonus;
		this.name = name;
	}
	@Override
	public void landOnField(Player player) {
			out.bonusMessage(name, bonus);
			player.account.addPoints(bonus);
			out.updateBalance(player.getName(), player.account.getScore());
	}
	@Override
	public String toString() {
		return "Type: Refuge --- Name: " + name + " --- Bonus: " + bonus + "\n";
	}

}
