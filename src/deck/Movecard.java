package deck;

import game.Player;

public abstract class Movecard extends Card{
	
	public Movecard(String message) {
		super(message);
	}

	public abstract void drawCard(Player player);

}
