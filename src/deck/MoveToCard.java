package deck;

import entity.Player;
import fields.GameBoard;
public class MoveToCard extends MoveCard {
	private int newposition;

	public MoveToCard(String message, int newposition, GameBoard board) {
		super(message, board);
		this.newposition = newposition;
	}

	@Override
	public void drawCard(Player player) {
		if (player.getPosition()>=newposition)
			player.passStart();
		player.setPosition(newposition);
	}
	
	
	

}
