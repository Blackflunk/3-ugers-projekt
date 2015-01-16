package fields;

import entity.DiceBox;
import entity.Player;


public class LaborCamp extends Ownable {

	private int rent;
	private DiceBox box;
	private int fullRent;

	public LaborCamp(String name, int price, int pansat, int rent, DiceBox box) {
		super(name, price, pansat);
		this.rent = rent;
		this.box = box;
	}
	@Override
	public int getRent(int numberoflaborcamps) {
		if (owner.getLaborCamp() == 1)
			return 80*box.getSum();
		else
			return 200*box.getSum();
	}

	@Override
	public void landOnField(Player player) {
		// If the current field has no owner, the player can buy it
		if (getOwner() == null) {
			if (player.account.getScore() >= price) {
				if (buyfield) {
					player.account.addPoints(-price);
					setOwner(player);
					player.addLaborCamp();
				} 
			} 
			// if the owner is the player himself, nothing happens
		} else if (getOwner().equals(player)) {
			// nothing happens
		}
		// if the field is owned by another player, a rent have to be paid
		else {
			if(getOwner().getLaborCamp()==2){
				rent = 200;
			}else{
				rent = 80;
			}
			fullRent = rent * box.getSum();
			if (player.account.getScore() >= fullRent) {
				getOwner().account.addPoints(fullRent);
				player.account.addPoints(-fullRent);
			// the player looses if the rent is higher than the players balance
			} else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.addPoints(-player.account.getScore());
				player.setStatus(true);
			}
		}
	}

	@Override
	public String toString() {
		return "Type: Labor Camp --- Name: " + name + " --- Price: " + price + " --- Rent: " + rent + "\n";
	}
}
