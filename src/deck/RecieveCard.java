package deck;
import entity.Player;

public class RecieveCard extends Card{
	protected int bonus;

	public RecieveCard(String message, int bonus) {
		super(message);
		this.bonus = bonus;
	}
	
	public void drawCard(Player player) {
		player.account.addPoints(bonus);
	}
	
	

}
