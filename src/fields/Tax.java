package fields;

import boundary.GUIcontroller;
import game.Player;

public class Tax extends Fields {

	private String name;
	private int pay;
	private GUIcontroller out = new GUIcontroller();

	public Tax(String name, int pay) {
		super(name);
		this.pay = pay;
		this.name = name;
	}

	@Override
	public void landOnField(Player player) {
		// If a player lands on goldmine
		if (name == "Statskat") {
			out.goldmineMessage(name);
			if (player.account.getScore() >= pay) {
				player.account.addPoints(-pay);
			} else {
				out.insufficiantFundsTax();
				player.account.addPoints(-player.account.getScore());
				player.setStatus(true);
			}
		}
		// If a player lands on caravan
		else {
			String taxPick = out.taxPick(name);
			if (taxPick == "4000") {
				if (player.account.getScore() >= pay) {
					player.account.addPoints(-pay);
				} else {
					out.taxFunds();
					player.account.addPoints(-player.account.getScore());
					player.setStatus(true);
				}
			} else {
				player.account.addPoints((int) -player.account.getScore() / 10);
			}

		}
		out.updateBalance(player.getName(), player.account.getScore());

	}
	@Override
	public String toString() {
		return "Type: Tax --- Name: " + name + " --- Tax: " + pay + "\n";
	}

}
