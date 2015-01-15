package fields;

import entity.Player;

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
			//
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
		// If field don't have a pay option
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
	@Override
	public boolean isPaypercent() {
		return paypercent;
	}
	@Override
	public void setPaypercent(boolean paypercent) {
		this.paypercent = paypercent;
	}

	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
	}
	@Override
	public int getPrice() {
		return pay;
	}

}
