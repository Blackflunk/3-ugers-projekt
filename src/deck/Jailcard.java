package deck;
import entity.Player;
import fields.GameBoard;

public class Jailcard extends Movecard {
	private int newposition = 10;

	public Jailcard(String message, GameBoard board) {
		super(message, board);
	}
	
	public void drawCard(Player player) {
		player.setPosition(newposition);
		player.setJailed(true);
	}
	

}
