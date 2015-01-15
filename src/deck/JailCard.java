package deck;
import entity.Player;
import fields.GameBoard;

public class JailCard extends MoveCard {
	private int newposition = 10;

	public JailCard(String message, GameBoard board) {
		super(message, board);
	}
	
	public void drawCard(Player player) {
		player.setPosition(newposition);
		player.setJailed(true);
	}
	

}
