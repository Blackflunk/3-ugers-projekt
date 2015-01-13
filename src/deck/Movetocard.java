package deck;

import game.Player;
import fields.GameBoard;
public class Movetocard extends Movecard {
	private int newposition;

	public Movetocard(String message, int newposition, GameBoard board) {
		super(message, board);
		this.newposition = newposition;
	}

	@Override
	public void drawCard(Player player) {
		if (player.getPosition()<=newposition)
			player.passStart();
		player.setPosition(newposition);
		board.getField(newposition).landOnField(player);
	}
	
	
	

}
