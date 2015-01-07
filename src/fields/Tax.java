package fields;

import boundary.GUIcontroller;
import game.Player;

public class Tax extends Fields {

	private String name;
	private int pay;
	private GUIcontroller out = new GUIcontroller();

	public Tax(String name, int pay) {
		this.name = name;
		this.pay = pay;
	}

	@Override
	public void landOnField(Player player) {
		// If a player lands on goldmine
		if (name == "Goldmine") {
			out.goldmineMessage(name);
			if (player.account.getScore() >= pay) {
				player.account.addPoints(-pay);
			} else {
				out.insufficiantFundsTax();
				player.account.addPoints(-player.account.getScore());
				player.setStatus();
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
					player.setStatus();
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
