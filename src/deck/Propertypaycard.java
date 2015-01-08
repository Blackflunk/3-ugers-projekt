package deck;
import game.Player;

public class Propertypaycard extends Paycard {
	private int price_house;
	private int price_hotel;

	public Propertypaycard(String message, int price_house, int price_hotel) {
		super(message, 0);
		this.price_house = price_house;
		this.price_hotel = price_hotel;
	}
	
	public void drawCard(Player player) {
		player.account.addPoints(price_house*player.getHouseammount()+price_hotel*player.getHotelammount());
	}
	

}
