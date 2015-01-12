package fields;

import game.Player;

public class Fleet extends Ownable {
	private String name;
	private int price;
	private int[] rent = new int[4];

	public Fleet(String name, int price, int pansat, int rent_1, int rent_2, int rent_3,
			int rent_4) {
		super(name, price, pansat);
		this.rent[0] = rent_1;
		this.rent[1] = rent_2;
		this.rent[2] = rent_3;
		this.rent[3] = rent_4;
		this.name = name;
		this.price = price;
		this.pansat = pansat;

	}
	@Override
	public int getRent(int numberoffleets) {
		return rent[numberoffleets];
	}

	@Override
	public void landOnField(Player player) {
		// If the current field has no owner, the player can buy it
		if (getOwner() == null) {
			if (player.account.getScore() >= price) {
				if (buyfield) {
					player.account.addPoints(-price);
					setOwner(player);
					player.addFleet();
				} else {
				}
			} else {
			}
			// if the owner is the player himself, nothing happens
		} else if (getOwner() == player) {
		}
		// if the field is owned by another player, a rent have to be paid
		else {
			if (player.account.getScore() >= rent[getOwner().getFleets() - 1]) {
				player.account.addPoints(-rent[getOwner().getFleets() - 1]);
				getOwner().account.addPoints(rent[getOwner().getFleets() - 1]);
				// the player loses if the rent is higher than the players
				// balance
			} else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.addPoints(-player.account.getScore());
				player.setStatus(true);
			}
		}
	}

	@Override
	public String toString() {
		return "Type: Fleet --- Name: " + name + " --- Price: " + price + " --- Rent 1: " + rent[0]
				+ " --- Rent 2: " + rent[1] + " --- Rent 3: " + rent[2] + " --- Rent 4: "
				+ rent[3] + "\n";
	}
}
