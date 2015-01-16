package deck;
import entity.Player;

public class PayCard extends Card{
	protected int price;
	
	public PayCard(String message, int price) {
		super(message);
		this.price = price;
	}
	
	@Override 
	public void drawCard(Player player) {
		if (player.account.getScore()<price){
			player.setStatus(true);
			player.account.setScore(0);
		}
		else
		player.account.addPoints(-price);
	}
}
