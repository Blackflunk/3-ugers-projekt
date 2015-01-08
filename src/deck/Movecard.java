package deck;

import game.Player;
import fields.GameBoard;

public abstract class Movecard extends Card{
	protected GameBoard board;
	
	public Movecard(String message, GameBoard board) {
		super(message);
		this.board = board;
	}

	public abstract void drawCard(Player player);

}
