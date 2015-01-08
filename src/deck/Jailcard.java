package deck;
import game.Player;

public class Jailcard extends Movecard {
	private int newposition = 11;

	public Jailcard(String message) {
		super(message);
	}
	
	public void drawCard(Player player) {
		player.setPosition(newposition);
		player.setJailed(true);
	}
	

}
