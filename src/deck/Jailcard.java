package deck;
import game.Player;
import fields.GameBoard;

public class Jailcard extends Movecard {
	private int newposition = 11;

	public Jailcard(String message, GameBoard board) {
		super(message, board);
	}
	
	public void drawCard(Player player) {
		player.setPosition(newposition);
		player.setJailed(true);
	}
	

}
