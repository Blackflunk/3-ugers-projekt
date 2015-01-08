package deck;
import game.Player;

public class Recievecard extends Card{
	protected int bonus;

	public Recievecard(String message, int bonus) {
		super(message);
		this.bonus = bonus;
	}
	
	public void drawCard(Player player) {
		player.account.addPoints(bonus);
	}
	
	

}
