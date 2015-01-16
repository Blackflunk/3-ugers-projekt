package deck;
import entity.Player;

public class PropertyPayCard extends PayCard {
	private int price_house;
	private int price_hotel;

	public PropertyPayCard(String message, int price_house, int price_hotel) {
		super(message, 0);
		this.price_house = price_house;
		this.price_hotel = price_hotel;
	}
	
	public void drawCard(Player player) {
		if (player.account.getScore()<price_house*player.getHouseammount()+price_hotel*player.getHotelammount()){
			player.setStatus(true);
			player.account.setScore(0);
		}
		else
		player.account.addPoints(price_house*player.getHouseammount()+price_hotel*player.getHotelammount());
	}
	

}
