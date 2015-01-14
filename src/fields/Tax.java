package fields;

import entity.Player;
import boundary.GUIcontroller;

public class Tax extends Field {

	private String name;
	private int pay;
	private boolean option;
	private boolean paypercent;

	public Tax(String name, int pay, boolean option) {
		super(name);
		this.pay = pay;
		this.name = name;
		this.option = option;
	}

	@Override
	public void landOnField(Player player) {
		// If a player lands on goldmine
		if (option) {
			if (paypercent) {
				player.account.addPoints(-player.account.getScore() / 10);
			}
			else{
			// out.goldmineMessage(name);
			if (player.account.getScore() >= pay) {
				player.account.addPoints(-pay);
			} else {
				// out.insufficiantFundsTax();
				player.account.addPoints(-player.account.getScore());
				player.setStatus(true);
			}
			}
		}
		// If a player lands on caravan
		else {
			if (player.account.getScore() >= pay) {
				player.account.addPoints(-pay);
			} else {
				// out.insufficiantFundsTax();
				player.account.addPoints(-player.account.getScore());
				player.setStatus(true);
			}
		}
		// out.updateBalance(player.getName(), player.account.getScore());

	}
	@Override
	public String toString() {
		return "Type: Tax --- Name: " + name + " --- Tax: " + pay + "\n";
	}

	public boolean isPaypercent() {
		return paypercent;
	}

	public void setPaypercent(boolean paypercent) {
		this.paypercent = paypercent;
	}

}
