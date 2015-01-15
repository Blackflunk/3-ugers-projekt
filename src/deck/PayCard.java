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
		player.account.addPoints(-price);
	}
	

	
	

}
