package fields;

import entity.Player;

public class Territory extends Ownable {

	private int houseprice, numberofhouses;
	private int[] rent = new int[6];
	private String color;

	public Territory(String name, int price, int houseprice, int pansat, 
			int rent1, int rent2, int rent3, int rent4, int rent5, int hotel, String color) {
		super(name, price, pansat);
		rent[0] = rent1;
		rent[1] = rent2;
		rent[2] = rent3;
		rent[3] = rent4;
		rent[4] = rent5;
		rent[5] = hotel;
		this.houseprice = houseprice;
		numberofhouses = 0;
		this.color = color;
		this.name = name;
		this.price  = price;
		this.pansat = pansat;
		
	}

	@Override
	public void landOnField(Player player) {
		// If the current field has no owner, the player can buy it
		if (getOwner() == null) {
			if (player.account.getScore() >= price) {
				if (buyfield) {
					player.account.addPoints(-price);
					setOwner(player);
					buyfield = false;
					switch(color){
					case "Blue"   : player.addFieldammount_blue();
					break;
					case "Pink"   : player.addFieldammount_pink();
					break;
					case "Green"  : player.addFieldammount_green();
					break;
					case "Gray"   : player.addFieldammount_grey();
					break;
					case "Red"    : player.addFieldammount_red();
					break;
					case "White"  : player.addFieldammount_white();
					break;
					case "Yellow" : player.addFieldammount_yellow();
					break;
					case "Magneta": player.addFieldammount_magenta();
					break;
					}
				} else {
				}
			} else {
			}
		// if the owner is the player himself, nothing happens
		} else if (getOwner().equals(player)) {
		// if the field is owned by another player, a rent have to be paid
		} else {
			if (checkPayDoubleRent(player)){
				if(player.account.getScore() >= rent[0]*2)
					payDoubleRent(player);
				// the player loses if the rent is higher than the players balance
				else {
					getOwner().account.addPoints(player.account.getScore());
					player.account.addPoints(-player.account.getScore());
					player.setStatus(true);	
				}
			}
			else if(player.account.getScore() >= rent[numberofhouses])
					payRent(player);
			// the player loses if the rent is higher than the players balance
			else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.addPoints(-player.account.getScore());
				player.setStatus(true);
			}
		}
	}
	
	public void payRent(Player player){
		getOwner().account.addPoints(rent[numberofhouses]);
		player.account.addPoints(-rent[numberofhouses]);
	}
	@Override
	public boolean checkPayDoubleRent(Player player){
		switch(color){
			case "Blue" : 
				if (getOwner().getBuy_Blue() && numberofhouses == 0)
					return true;
				else
					return false;
			case "Pink" : 
				if (getOwner().getBuy_Pink() && numberofhouses == 0)
					return true;
				else
					return false;
			case "Green" : 
				if (getOwner().getBuy_Green() && numberofhouses == 0)
					return true;
				else
					return false;
			case "Gray" : 
				if (getOwner().getBuy_grey() && numberofhouses == 0)
					return true;
				else
					return false;
			case "Red" : 
				if (getOwner().getBuy_Red() && numberofhouses == 0)
					return true;
				else
					return false;
			case "White" : 
				if (getOwner().getBuy_White() && numberofhouses == 0)
					return true;
				else
					return false;
			case "Yellow" : 
				if (getOwner().getBuy_Yellow() && numberofhouses == 0)
					return true;
				else
					return false;
			case "Magneta" : 
				if (getOwner().getBuy_Magenta() && numberofhouses == 0)
					return true;
				else
					return false;
			default:
					return false;
			
		}
	}

	
	public void payDoubleRent(Player player){
		getOwner().account.addPoints(rent[0]*2);
		player.account.addPoints(-rent[0]*2);
	}
	
	public int getHouseprice() {
		return houseprice;
	}
	public int getNumberofhouses() {
		return numberofhouses;
	}
	public void setNumberofHouses(int numberofhouses){
		this.numberofhouses += numberofhouses;
	}
	public String getColor(){
		return color;
	}
	
	@Override
	public String toString() {
		return "Type: Territory --- Name: " + name + " --- Price: " + price + " --- Rent: " + rent + "\n";
	}

	public int getRent(int numberofhouses) {
		return rent[numberofhouses];
	}

}
