package fields;

import boundary.GUIcontroller;
import game.Player;

public class Territory extends Ownable {

	private String name;
	private int price, houseprice, numberofhouses;
	private int[] rent = new int[6];
	private GUIcontroller out = new GUIcontroller();

	public Territory(String name, int price, int houseprice, int pansat, 
			int rent1, int rent2, int rent3, int rent4, int rent5, int hotel) {
		super(name, price, pansat);
		rent[0] = rent1;
		rent[1] = rent2;
		rent[2] = rent3;
		rent[3] = rent4;
		rent[4] = rent5;
		rent[5] = hotel;
		this.houseprice = houseprice;
		numberofhouses = 0;
	}

	@Override
	public void landOnField(Player player) {
		// If the current field has no owner, the player can buy it
		if (getOwner() == null) {
			if (player.account.getScore() >= price) {
				boolean buyField = out.buyField(name, price);
				if (buyField) {
					player.account.addPoints(-price);
					setOwner(player);
					out.fieldBought(name);
					out.setOwner(player);
				} else {
					out.fieldRefused(name);
				}
			} else {
				out.fieldRefusedPrice(name);
			}
		// if the owner is the player himself, nothing happens
		} else if (getOwner() == player) {
			out.fieldOwnedByPlayer(name);
		// if the field is owned by another player, a rent have to be paid
		} else {
			if (player.account.getScore() >= rent[numberofhouses]) {
				out.fieldTax(name, getOwner().getName(), rent[numberofhouses]);
				
				getOwner().account.addPoints(rent[numberofhouses]);
				player.account.addPoints(-rent[numberofhouses]);

				out.updateBalance(getOwner().getName(), getOwner().account.getScore());			// the player looses if the rent is higher than the players balance
			}
			// the player loses if the rent is higher than the players balance
			else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.addPoints(-player.account.getScore());
				
				out.insufficiantFunds(name, getOwner().getName(), player.account.getScore());
				out.updateBalance(getOwner().getName(), getOwner().account.getScore());
				
				player.setStatus(true);
			}
		}
		// Updates the GUI balance for each player
		out.updateBalance(player.getName(), player.account.getScore());
	}
	
	public int getHouseprice() {
		return houseprice;
	}
	public int getNumberofhouses() {
		return numberofhouses;
	}
	
	@Override
	public String toString() {
		return "Type: Territory --- Name: " + name + " --- Price: " + price + " --- Rent: " + rent + "\n";
	}
}
