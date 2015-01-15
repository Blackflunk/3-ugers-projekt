package deck;

import entity.Player;
import fields.GameBoard;

public abstract class MoveCard extends Card{
	protected GameBoard board;
	
	public MoveCard(String message, GameBoard board) {
		super(message);
		this.board = board;
	}

	public abstract void drawCard(Player player);

}
