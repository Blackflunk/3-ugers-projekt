package deck;
import game.Player;

public class Paycard extends Card{
	protected int price;
	
	public Paycard(String message, int price) {
		super(message);
		this.price = price;
	}
	
	@Override 
	public void drawCard(Player player) {
		player.account.addPoints(-price);
	}
	

	
	

}
