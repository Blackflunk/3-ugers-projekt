package deck;

import game.Player;

public class Queenscard extends Card{

	public Queenscard(String message) {
		super(message);
	}

	@Override
	public void drawCard(Player player) {
		player.setOutofjailcard(true);		
	}

}
